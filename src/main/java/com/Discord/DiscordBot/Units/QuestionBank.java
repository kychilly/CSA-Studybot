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
        // Initialize other units eventually
        Unit1.initializeUnit1Questions();
        Unit2.initializeUnit2Questions();
        Unit3.initializeUnit3Questions();
        Unit4.initializeUnit4Questions();
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