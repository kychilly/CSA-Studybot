package com.Discord.DiscordBot.Units;

public class Unit1 {
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
}