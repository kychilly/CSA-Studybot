package com.Discord.DiscordBot.Units;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    private static ArrayList<Question> unit1Questions;
    private static ArrayList<Question> unit2Questions;
    private static ArrayList<Question> unit3Questions;
    private static ArrayList<Question> unit4Questions;

    public QuestionBank() {
        initializeUnit1Questions();

        // Initialize other units when needed
    }

    private void initializeUnit1Questions() {
        unit1Questions = new ArrayList<>();

        // Unit 1: Using Objects & Methods (15-25% of exam)
        unit1Questions.add(new Question(
                "What is the output of: System.out.println(5 + \"10\");",
                "510",
                "15",
                "Compile error",
                "Runtime error",
                "A",
                1
        ));

        unit1Questions.add(new Question(
                "Which of these is NOT a primitive data type in Java?",
                "int",
                "double",
                "String",
                "boolean",
                "C",
                1
        ));

        unit1Questions.add(new Question(
                "What is the correct way to create a String object?",
                "String s = new String(\"hello\");",
                "String s = \"hello\";",
                "Both A and B",
                "Neither A nor B",
                "C",
                1
        ));

        // Get chatgpt to generate more questions lol
        System.out.println(unit1Questions.size() + " questions in unit 1");
    }

    public void initializeUnit2Questions() {

    }

    public void initializeUnit3Questions() {

    }

    public void initializeUnit4Questions() {

    }

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

    // Get random question given the ArrayList(unit1Questions gets random from unit1Questions)
    public static Question getRandomQuestion(ArrayList<Question> questions) {
        if (questions.isEmpty()) {
            System.out.println("Question list is null");
            return null;
        }
        return questions.get((int)(Math.random()*questions.size()));
    }
}