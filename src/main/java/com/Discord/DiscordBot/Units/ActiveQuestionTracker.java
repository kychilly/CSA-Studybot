package com.Discord.DiscordBot.Units;

import net.dv8tion.jda.api.entities.User;

import java.util.HashMap;
import java.util.Map;

public class ActiveQuestionTracker {

    private static final Map<User, Question> userQuestions = new HashMap<>();
    private static final Map<Long, User> activeMessageIds = new HashMap<>(); // The IDs of the question messages the bot sent. Returns the user message associated with
    private static final Map<User, Integer> questionIds = new HashMap<>(); // The IDs of the user's questions

    public static void addActiveQuestion(User user, Question question, long messageId, int questionId) {
        userQuestions.put(user, question);
        activeMessageIds.put(messageId, user);
        questionIds.put(user, questionId);
    }

    public static void removeActiveQuestion(User user, Long messageId) {
        userQuestions.remove(user);
        activeMessageIds.remove(messageId);
        questionIds.remove(user);
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
}