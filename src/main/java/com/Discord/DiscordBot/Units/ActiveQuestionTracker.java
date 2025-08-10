package com.Discord.DiscordBot.Units;

import com.Discord.DiscordBot.Constants;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.sharding.ShardManager;

import java.util.HashMap;
import java.util.Map;

public class ActiveQuestionTracker {

    private static final Map<User, Question> userQuestions = new HashMap<>();
    private static final Map<Long, User> activeMessageIds = new HashMap<>(); // The IDs of the question messages the bot sent. Returns the user message associated with
    private static final Map<User, Integer> questionIds = new HashMap<>(); // The IDs of the user's questions
    private static final Map<User, Long> questionTimestamps = new HashMap<>(); // Stores the amount of time left before question ends(gets deleted cause afk)
    private static final Map<User, Long> questionChannelIds = new HashMap<>(); // Compliments questionTimestamps

    public static void addActiveQuestion(User user, Question question, long messageId, int questionId, long channelId) {
        userQuestions.put(user, question);
        activeMessageIds.put(messageId, user);
        questionIds.put(user, questionId);
        questionTimestamps.put(user, System.currentTimeMillis());
        questionChannelIds.put(user, channelId);
    }

    public static void removeActiveQuestion(User user, Long messageId) {
        userQuestions.remove(user);
        activeMessageIds.remove(messageId);
        questionIds.remove(user);
        questionTimestamps.remove(user);
        questionChannelIds.remove(user);
    }

    public static boolean hasActiveQuestion(User user) {
        return userQuestions.containsKey(user);
    }

    public static Question getActiveQuestion(User user) {
        return userQuestions.get(user);
    }

    public static User getUserByMessageId(Long messageId) {
        return activeMessageIds.get(messageId);
    }

    public static int getQuestionId(User user) {
        return questionIds.get(user);
    }

    // Sussy timer stuff
    public static void checkForExpiredQuestions(ShardManager shardManager) {
        long currentTime = System.currentTimeMillis();
        long timeoutMillis = 2 * 60 * 1000; // 2 minutes in milliseconds

        // Create a copy to avoid concurrent modification
        new HashMap<>(questionTimestamps).forEach((user, timestamp) -> {
            if (currentTime - timestamp > timeoutMillis) {
                // Question has expired
                Long messageId = getMessageIdForUser(user);
                removeActiveQuestion(user, messageId);
                notifyUserOfExpiration(shardManager, user);
            }
        });
    }

    private static void notifyUserOfExpiration(ShardManager shardManager, User user) {
        Long channelId = getChannelIdForUser(user);

        if (channelId != null) {
            TextChannel channel = shardManager.getTextChannelById(channelId);
            if (channel != null) {
                try {
                    channel.sendMessage(user.getAsMention() + " ⌛ Your question has expired because you didn't respond within 2 minutes.")
                            .queue(
                                    success -> {},
                                    error -> sendDMNotification(shardManager, user)
                            );
                } catch (Exception e) {
                    sendDMNotification(shardManager, user);
                }
            } else {
                sendDMNotification(shardManager, user);
            }
        } else {
            sendDMNotification(shardManager, user);
        }
    }

    private static void sendDMNotification(ShardManager shardManager, User user) {
        shardManager.retrieveUserById(user.getId()).queue(
                botUser -> {
                    botUser.openPrivateChannel().queue(
                            channel -> {
                                channel.sendMessage("⌛ Your question has expired because you didn't respond within 2 minutes. " +
                                                "Use the commands again to get a new question.")
                                        .queue(null,
                                                e -> System.out.println("Failed to send DM to " + user.getId())
                                        );
                            },
                            e -> System.out.println("Couldn't open DM channel for " + user.getId())
                    );
                },
                e -> System.out.println("Couldn't retrieve user " + user.getId())
        );
    }

    private static Long getMessageIdForUser(User user) {
        return activeMessageIds.entrySet().stream()
                .filter(entry -> entry.getValue().equals(user))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static Long getChannelIdForUser(User user) {
        return questionChannelIds.get(user);
    }

}