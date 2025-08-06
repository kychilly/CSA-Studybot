package com.Discord.DiscordBot.Units;

import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;
import java.util.HashMap;

import static com.Discord.DiscordBot.Units.QuestionBank.unit1Questions;

public class Unit1 {

    public static int numUnit1Questions;

    // Used to create the unit 1 questions
    public static void initializeUnit1Questions() {
        unit1Questions = new ArrayList<>();

        // String object questions
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"hello\".substring(1, 4));\n```",
                "ell", "hel", "llo", "hello",
                "A", 1, 1));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"APCSA\".length());\n```",
                "4", "5", "6", "Error",
                "B", 1, 2));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"computer\".indexOf('p'));\n```",
                "2", "3", "4", "-1",
                "B", 1, 3));

        // Math class questions
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Math.pow(2, 3));\n```",
                "6", "8", "8.0", "9.0",
                "C", 1, 4));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println((int)(Math.random() * 10));\n```",
                "0-9", "1-10", "0-10", "1-9",
                "A", 1, 5));

        // String concatenation
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(1 + 2 + \"3\" + 4 + 5);\n```",
                "12345", "3345", "1239", "33",
                "B", 1, 6));

        // More String methods
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"banana\".substring(2, 5));\n```",
                "nan", "ana", "nana", "ban",
                "A", 1, 7));

        // Object method calls
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString s = \"hello\";\nSystem.out.println(s.toUpperCase().substring(1));\n```",
                "HELLO", "ELLO", "HELL", "ello",
                "B", 1, 8));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"abc\".compareTo(\"abb\"));\n```",
                "-1", "0", "1", "2",
                "C", 1, 9));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Java\".equals(\"java\"));\n```",
                "true", "false", "0", "1",
                "B", 1, 10));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"hello\".charAt(1));\n```",
                "h", "e", "l", "o",
                "B", 1, 11));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"text\".replace('t', 'p'));\n```",
                "pexp", "text", "pep", "pext",
                "A", 1, 12));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"ABCD\".toLowerCase());\n```",
                "abcd", "ABCD", "aBcD", "error",
                "A", 1, 13));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\" hello \".trim());\n```",
                "hello", " hello", "hello ", " hello ",
                "A", 1, 14));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"a\".compareTo(\"b\"));\n```",
                "-1", "0", "1", "2",
                "A", 1, 15));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"abc\".concat(\"def\"));\n```",
                "abcdef", "abc def", "abc+def", "error",
                "A", 1, 16));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Mississippi\".indexOf(\"iss\", 2));\n```",
                "1", "2", "4", "-1",
                "C", 1, 17));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"wxyz\".startsWith(\"wx\"));\n```",
                "true", "false", "0", "1",
                "A", 1, 18));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"hello\".replace(\"ll\", \"rr\"));\n```",
                "herro", "hello", "heo", "error",
                "A", 1, 19));

        numUnit1Questions = unit1Questions.size();
        System.out.println(String.format("There are %d questions in unit 1", numUnit1Questions));
    }

}