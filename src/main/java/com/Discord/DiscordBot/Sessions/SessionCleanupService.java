package com.Discord.DiscordBot.Sessions;

import com.Discord.DiscordBot.Constants;
import com.Discord.DiscordBot.commands.TestCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.sharding.ShardManager;
import java.awt.Color;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SessionCleanupService {
    private final ShardManager shardManager;
    private final long cleanupIntervalMinutes;
    private final long sessionTimeoutMinutes;

    public SessionCleanupService(ShardManager shardManager,
                                 long cleanupIntervalMinutes,
                                 long sessionTimeoutMinutes) {
        this.shardManager = shardManager;
        this.cleanupIntervalMinutes = cleanupIntervalMinutes;
        this.sessionTimeoutMinutes = sessionTimeoutMinutes;
    }

    public void startCleanupTask() {
        Timer timer = new Timer(true); // Daemon thread
        timer.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          cleanupInactiveSessions();
                                      }
                                  },
                TimeUnit.MINUTES.toMillis(cleanupIntervalMinutes),
                TimeUnit.MINUTES.toMillis(cleanupIntervalMinutes));
    }

    private void cleanupInactiveSessions() {
        long now = System.currentTimeMillis();
        List<Long> toRemove = new ArrayList<>();
        Map<Long, MessageInfo> messagesToEdit = new HashMap<>(); // userId -> MessageInfo

        // First collect IDs to remove and message info
        synchronized (TestCommand.class) {
            TestCommand.getActiveTests().forEach((userId, session) -> {
                if (now - session.getLastActivityTime() >
                        TimeUnit.MINUTES.toMillis(sessionTimeoutMinutes)) {
                    toRemove.add(userId);
                    messagesToEdit.put(userId,
                            new MessageInfo(session.getMessageId(), session.getChannelId(), session.getUser()));
                }
            });
        }

        // Process removals, message edits, and notifications
        toRemove.forEach(userId -> {
            MessageInfo messageInfo = messagesToEdit.get(userId);
            if (messageInfo != null) {
                try {
                    TextChannel channel = shardManager.getTextChannelById(messageInfo.channelId());
                    if (channel != null) {
                        // Retrieve user information
                        shardManager.retrieveUserById(userId).queue(user -> {
                            channel.editMessageEmbedsById(messageInfo.messageId(),
                                    new EmbedBuilder()
                                            .setTitle("⏰ Test Session Expired")
                                            .setDescription(user.getAsMention() + String.format(", your test session has expired after %d minutes of inactivity." +
                                                    "\n\n" + "Use /%s to start another test.",
                                                    Constants.testTimeoutInMinutes,
                                                    Constants.slashPrefix))
                                            .setColor(new Color(255, 82, 82))
                                            .setThumbnail(user.getEffectiveAvatarUrl())
                                            .setFooter("⏰ Test timed out • " + Instant.now().atZone(ZoneId.of("America/New_York")).format(DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a")))
                                            .build()
                            ).setComponents(Collections.emptyList()).queue();
                        }, error -> {
                            // Fallback if user can't be retrieved
                            channel.editMessageEmbedsById(messageInfo.messageId(),
                                    new EmbedBuilder()
                                            .setTitle("⏰ Test Session Expired")
                                            .setDescription("Your test session has expired after " +
                                                    sessionTimeoutMinutes + " minutes of inactivity.")
                                            .setColor(new Color(255, 82, 82))
                                            .setFooter("Session ended • " +
                                                            Instant.now()
                                                                    .atZone(ZoneId.of("America/New_York"))
                                                                    .format(DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a")),
                                                    "https://cdn.jsdelivr.net/gh/twitter/twemoji@14.0.2/assets/72x72/23f0.png")
                                            .build()
                            ).setComponents(Collections.emptyList()).queue();
                        });
                    }
                } catch (Exception e) {
                    System.out.println("[SessionCleanup] Failed to edit message for user " + userId);
                }
            }

            // Remove the session
            synchronized (TestCommand.class) {
                TestCommand.getActiveTests().remove(userId);
            }

            // Notify the user
            notifyUser(userId);
            System.out.println("[Cleanup] Removed inactive session for: " + userId);
        });
    }

    private void notifyUser(long userId) {
        shardManager.retrieveUserById(userId).queue(user -> {
            user.openPrivateChannel().queue(channel -> {
                channel.sendMessage("⌛ Your test session expired after " +
                                sessionTimeoutMinutes + " minutes of inactivity.\n" +
                                "Use the test command again to start a new session.")
                        .queue();
            }, error -> {
                System.out.println("[SessionCleanup] Couldn't DM user " + userId);
            });
        }, error -> {
            System.out.println("[SessionCleanup] Couldn't find user " + userId);
        });
    }

    public record MessageInfo(long messageId, long channelId, User user) {}
}