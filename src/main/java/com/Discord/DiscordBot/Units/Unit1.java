package com.Discord.DiscordBot.Units;

import net.dv8tion.jda.api.entities.User;

import java.util.HashMap;

public class Unit1 {

    private static HashMap<User, String> incorrectUserAnswers = new HashMap<>();

    public static boolean checkAnswer(Question question, String answer) {
        if (question == null || answer == null || answer.isEmpty()) {
            return false;
        }
        return question.isCorrect(answer);
    }

    public static String getFormattedQuestion(Question question) {
        if (question == null) {
            return "No question available.";
        }
        return String.format("%s\nA) %s\nB) %s\nC) %s\nD) %s",
                question.getQuestion(),
                question.getOptionA(),
                question.getOptionB(),
                question.getOptionC(),
                question.getOptionD());
    }

    // Store incorrect answer
    public static void storeIncorrectAnswer(User user, String answer) {
        incorrectUserAnswers.put(user, answer);
    }

    // Get incorrect answer
    public static String getIncorrectAnswer(User user) {
        return incorrectUserAnswers.get(user);
    }

    // Clear when starting new game
    public static void clearUserAnswers(User user) {
        incorrectUserAnswers.remove(user);
    }
}