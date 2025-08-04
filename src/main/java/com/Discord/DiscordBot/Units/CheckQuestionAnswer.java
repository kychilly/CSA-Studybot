package com.Discord.DiscordBot.Units;

public class CheckQuestionAnswer {

    // This class literally just checks the question answer. Yes, single method in single class
    public static boolean checkAnswer(Question question, String answer) {
        if (question == null || answer == null || answer.isEmpty()) {
            return false;
        }
        return question.isCorrect(answer);
    }

}
