package com.Discord.DiscordBot.Units;

import net.dv8tion.jda.api.utils.messages.MessageEditBuilder;

import java.util.ArrayList;

public class Unit1 {
    private static ArrayList<Question> questions = new ArrayList<>();

    public Unit1() {
        questions = QuestionBank.getUnit1Questions();
    }



    public boolean checkAnswer(Question question, String answer) {
        return question.isCorrect(answer);
    }

    public static String getFormattedQuestion(Question question) {
        return String.format("%s\nA) %s\nB) %s\nC) %s\nD) %s",
                question.getQuestion(),
                question.getOptionA(),
                question.getOptionB(),
                question.getOptionC(),
                question.getOptionD());
    }
}