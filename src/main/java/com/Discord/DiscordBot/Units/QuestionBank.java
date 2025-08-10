package com.Discord.DiscordBot.Units;

import java.util.ArrayList;

public class QuestionBank {
    public static ArrayList<Question> unit1Questions = new ArrayList<>();
    public static ArrayList<Question> unit2Questions = new ArrayList<>();
    public static ArrayList<Question> unit3Questions = new ArrayList<>();
    public static ArrayList<Question> unit4Questions = new ArrayList<>();
    public static ArrayList<Question> questionBank = new ArrayList<>();

    public QuestionBank() {
        initializeQuestions();
    }

    private void initializeQuestions() {
        Unit1.initializeUnit1Questions();
        Unit2.initializeUnit2Questions();
        Unit3.initializeUnit3Questions();
        Unit4.initializeUnit4Questions();
        initializeQuestionBank();
    }

    public static ArrayList<Question> getQuestionBank() { return questionBank; }
    public static ArrayList<Question> getUnit1Questions() {
        return unit1Questions;
    }
    public static ArrayList<Question> getUnit2Questions() {
        return unit2Questions;
    }
    public static ArrayList<Question> getUnit3Questions() {
        return unit3Questions;
    }
    public static ArrayList<Question> getUnit4Questions() {
        return unit4Questions;
    }

    public void initializeQuestionBank() {
        questionBank.addAll(unit1Questions);
        questionBank.addAll(unit2Questions);
        questionBank.addAll(unit3Questions);
        questionBank.addAll(unit4Questions);
    }

    public static ArrayList<Question> getSpecificQuestionMethod(int n) {
        if (n == 1) {
            return unit1Questions;
        } else if (n == 2) {
            return unit2Questions;
        } else if (n == 3) {
            return unit3Questions;
        } else if (n == 4) {
            return unit4Questions;
        }
        System.out.println("bug in QuestionBank line 55 getSpecificQuestionMethod(int n)");
        return unit4Questions;
    }

    // Get random question given the ArrayList(unit1Questions gets random from unit1Questions)
    public static Question getRandomQuestion(ArrayList<Question> questions, int prevQuestionId) {
        if (questions.isEmpty()) {
            System.out.println("Make more questions lol");
            return null;
        }
        // Makes sure the question is not the same one from before
        Question question;
        do {
            question = questions.get((int) (Math.random() * questions.size()));
        } while (question.getQuestionId() == prevQuestionId);
        return question;
    }
}