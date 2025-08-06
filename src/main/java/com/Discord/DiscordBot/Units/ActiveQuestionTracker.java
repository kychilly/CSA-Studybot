package com.Discord.DiscordBot.Units;

import net.dv8tion.jda.api.entities.User;

import java.util.HashMap;
import java.util.Map;

public class ActiveQuestionTracker {
    private static final Map<User, Question> userQuestions = new HashMap<>();
    private static final Map<User, Long> messageIds = new HashMap<>();
    private static final Map<User, Integer> questionIds = new HashMap<>();

    public static void addActiveQuestion(User user, Question question, long messageId, int questionId) {
        userQuestions.put(user, question);
        messageIds.put(user, messageId);
        questionIds.put(user, questionId);
    }

    public static void removeActiveQuestion(User user) {
        userQuestions.remove(user);
        messageIds.remove(user);
        questionIds.remove(user);
    }

    public static boolean hasActiveQuestion(User user) {
        return userQuestions.containsKey(user);
    }

    public static Question getActiveQuestion(User user) {
        return userQuestions.get(user);
    }

    public static Long getMessageId(User user) {
        return messageIds.get(user);
    }

    public static int getQuestionId(User user) {
        return questionIds.get(user);
    }
}