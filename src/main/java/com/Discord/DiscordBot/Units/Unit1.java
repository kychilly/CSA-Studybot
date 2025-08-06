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
                "What is printed by: System.out.println(\"hello\".substring(1, 4));",
                "ell", "hel", "llo", "hello",
                "A", 1, 1));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"APCSA\".length());",
                "4", "5", "6", "Error",
                "B", 1, 2));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"computer\".indexOf('p'));",
                "2", "3", "4", "-1",
                "B", 1, 3));

        // Math class questions
        unit1Questions.add(new Question(
                "What is printed by: System.out.println(Math.pow(2, 3));",
                "6", "8", "8.0", "9.0",
                "C", 1, 4));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println((int)(Math.random() * 10));",
                "0-9", "1-10", "0-10", "1-9",
                "A", 1, 5));

        // String concatenation
        unit1Questions.add(new Question(
                "What is printed by: System.out.println(1 + 2 + \"3\" + 4 + 5);",
                "12345", "3345", "1239", "33",
                "B", 1, 6));

        // More String methods
        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"banana\".substring(2, 5));",
                "nan", "ana", "nana", "ban",
                "A", 1, 7));

        // Object method calls
        unit1Questions.add(new Question(
                "What is printed by: String s = \"hello\"; System.out.println(s.toUpperCase().substring(1));",
                "HELLO", "ELLO", "HELL", "ello",
                "B", 1, 8));

        // More questions continue...
        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"abc\".compareTo(\"abb\"));",
                "-1", "0", "1", "2",
                "C", 1, 9));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"Java\".equals(\"java\"));",
                "true", "false", "0", "1",
                "B", 1, 10));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"hello\".charAt(1));",
                "h", "e", "l", "o",
                "B", 1, 11));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"text\".replace('t', 'p'));",
                "pexp", "text", "pep", "pext",
                "A", 1, 12));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"ABCD\".toLowerCase());",
                "abcd", "ABCD", "aBcD", "error",
                "A", 1, 13));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\" hello \".trim());",
                "hello", " hello", "hello ", " hello ",
                "A", 1, 14));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"a\".compareTo(\"b\"));",
                "-1", "0", "1", "2",
                "A", 1, 15));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"abc\".concat(\"def\"));",
                "abcdef", "abc def", "abc+def", "error",
                "A", 1, 16));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"Mississippi\".indexOf(\"iss\", 2));",
                "1", "2", "4", "-1",
                "C", 1, 17));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"wxyz\".startsWith(\"wx\"));",
                "true", "false", "0", "1",
                "A", 1, 18));

        unit1Questions.add(new Question(
                "What is printed by: System.out.println(\"hello\".replace(\"ll\", \"rr\"));",
                "herro", "hello", "heo", "error",
                "A", 1, 19));

        // add like 30+ more questions, currently at 20
        System.out.println(unit1Questions.size() + " questions in unit 1");
        numUnit1Questions = unit1Questions.size();
    }
}