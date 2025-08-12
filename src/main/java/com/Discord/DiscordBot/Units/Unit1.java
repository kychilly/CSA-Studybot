package com.Discord.DiscordBot.Units;

import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;
import java.util.HashMap;

import static com.Discord.DiscordBot.Units.QuestionBank.unit1Questions;

public class Unit1 {

    public static int numUnit1Questions;

    public static void initializeUnit1Questions() {
        unit1Questions = new ArrayList<>();

        // String object questions
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"hello\".substring(1, 4));\n```",
                "ell", "hel", "llo", "hello",
                "A", 1, 1, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"APCSA\".length());\n```",
                "4", "5", "6", "Error",
                "B", 1, 2, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"computer\".indexOf('p'));\n```",
                "2", "3", "4", "-1",
                "B", 1, 3, "easy"));

        // Math class questions
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Math.pow(2, 3));\n```",
                "6", "8", "8.0", "9.0",
                "C", 1, 4, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println((int)(Math.random() * 10));\n```",
                "0-9", "1-10", "0-10", "1-9",
                "A", 1, 5, "medium"));

        // String concatenation
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(1 + 2 + \"3\" + 4 + 5);\n```",
                "12345", "3345", "1239", "33",
                "B", 1, 6, "medium"));

        // More String methods
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"banana\".substring(2, 5));\n```",
                "nan", "ana", "nana", "ban",
                "A", 1, 7, "easy"));

        // Object method calls
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString s = \"hello\";\nSystem.out.println(s.toUpperCase().substring(1));\n```",
                "HELLO", "ELLO", "HELL", "ello",
                "B", 1, 8, "medium"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"abc\".compareTo(\"abb\"));\n```",
                "-1", "0", "1", "2",
                "C", 1, 9, "medium"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Java\".equals(\"java\"));\n```",
                "true", "false", "0", "1",
                "B", 1, 10, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"hello\".charAt(1));\n```",
                "h", "e", "l", "o",
                "B", 1, 11, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"text\".replace('t', 'p'));\n```",
                "pexp", "text", "pep", "pext",
                "A", 1, 12, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"ABCD\".toLowerCase());\n```",
                "abcd", "ABCD", "aBcD", "error",
                "A", 1, 13, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\" hello \".trim());\n```",
                "hello", " hello", "hello ", " hello ",
                "A", 1, 14, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"a\".compareTo(\"b\"));\n```",
                "-1", "0", "1", "2",
                "A", 1, 15, "medium"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"abc\".concat(\"def\"));\n```",
                "abcdef", "abc def", "abc+def", "error",
                "A", 1, 16, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Mississippi\".indexOf(\"iss\", 2));\n```",
                "1", "2", "4", "-1",
                "C", 1, 17, "hard"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"wxyz\".startsWith(\"wx\"));\n```",
                "true", "false", "0", "1",
                "A", 1, 18, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"hello\".replace(\"ll\", \"rr\"));\n```",
                "herro", "hello", "heo", "error",
                "A", 1, 19, "easy"));
        // Primitive types and operators
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nint x = 5;\ndouble y = 2;\nSystem.out.println(x / y);\n```",
                "2", "2.0", "2.5", "3",
                "C", 1, 20, "medium"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(17 % 5);\n```",
                "2", "3", "3.4", "4",
                "A", 1, 21, "easy"));

        // Object reference questions
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString s1 = \"hello\";\nString s2 = s1;\ns1 = \"world\";\nSystem.out.println(s2);\n```",
                "hello", "world", "null", "Error",
                "A", 1, 22, "medium"));

        // Operator precedence
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(3 + 4 * 5);\n```",
                "35", "23", "60", "Error",
                "B", 1, 23, "easy"));

        // Casting questions
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\ndouble d = 4.7;\nint i = (int) d;\nSystem.out.println(i);\n```",
                "4", "4.7", "5", "Error",
                "A", 1, 24, "easy"));

        // Compound assignment
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nint x = 5;\nx *= 3 + 2;\nSystem.out.println(x);\n```",
                "17", "25", "13", "30",
                "B", 1, 25, "medium"));

        // String comparison
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString s1 = \"hello\";\nString s2 = new String(\"hello\");\nSystem.out.println(s1 == s2);\n```",
                "true", "false", "0", "Error",
                "B", 1, 26, "hard"));

        // Escape sequences
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"a\\tb\\nc\");\n```",
                "a b c", "a\\tb\\nc", "a\tb\nc", "Error",
                "C", 1, 27, "easy"));

        // Integer division
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(10 / 4);\n```",
                "2", "2.5", "3", "3.0",
                "A", 1, 28, "easy"));

        // Compound operators with casting
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nint x = 5;\nx += 3.5;\nSystem.out.println(x);\n```",
                "8", "8.5", "9", "Error",
                "A", 1, 29, "hard"));

        // String method chaining
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\" Hello World \".trim().substring(6).toLowerCase());\n```",
                "world", "world ", "World", "error",
                "A", 1, 30, "hard"));
        // Object method calls with null
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString s = null;\nSystem.out.println(s.length());\n```",
                "0", "4", "null", "Throws NullPointerException",
                "D", 1, 31, "medium"));

        // String immutability
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString s = \"hello\";\ns.toUpperCase();\nSystem.out.println(s);\n```",
                "HELLO", "hello", "Error", "null",
                "B", 1, 32, "medium"));

        // Method chaining with Math class
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Math.sqrt(Math.pow(3, 2)));\n```",
                "3", "3.0", "9", "9.0",
                "B", 1, 33, "medium"));

        // String comparison with case sensitivity
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".equalsIgnoreCase(\"hELLo\"));\n```",
                "true", "false", "0", "1",
                "A", 1, 34, "easy"));

        // String constructor behavior
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString a = \"AP\";\nString b = new String(\"AP\");\nSystem.out.println(a.equals(b));\n```",
                "true", "false", "Error", "null",
                "A", 1, 35, "medium"));

        // Substring edge case
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"java\".substring(1,1));\n```",
                "j", "a", "av", "(empty string)",
                "D", 1, 36, "hard"));

        // String format method
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(String.format(\"%s-%d\", \"CS\", 2024));\n```",
                "CS-2024", "CS2024", "Error", "null",
                "A", 1, 37, "medium"));

        // Wrapper class methods
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Integer.parseInt(\"10\"));\n```",
                "10", "\"10\"", "10.0", "Error",
                "A", 1, 38, "easy"));

        // String contains() method
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"programming\".contains(\"gram\"));\n```",
                "true", "false", "3", "Error",
                "A", 1, 39, "easy"));

        // String lastIndexOf()
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"banana\".lastIndexOf('a'));\n```",
                "1", "3", "5", "6",
                "C", 1, 40, "medium"));
        // String pool
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString s1 = \"AP\";\nString s2 = \"AP\";\nSystem.out.println(s1 == s2);\n```",
                "true", "false", "Error", "null",
                "A", 1, 41, "hard"));
        // Math class rounding
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Math.round(3.5));\n```",
                "3", "3.0", "4", "4.0",
                "C", 1, 42, "easy"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"a1b2c3\".replaceAll(\"\\\\d\", \"*\"));\n```",
                "a*b*c*", "a1b2c3", "******", "Error",
                "A", 1, 43, "hard"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString s = \"  AP CSA  \";\nSystem.out.println(s.trim().length());\n```",
                "5", "6", "9", "10",
                "A", 1, 44, "medium"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Integer.valueOf(\"10\") + 5);\n```",
                "15", "105", "\"105\"", "Error",
                "A", 1, 45, "medium"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".regionMatches(true, 1, \"ELL\", 0, 2));\n```",
                "true", "false", "Error", "null",
                "A", 1, 46, "hard"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Math.abs(-2147483648));\n```",
                "2147483648", "2147483647", "-2147483648", "Error",
                "C", 1, 47, "hard"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Arrays.toString(\"A,B,C\".split(\",\")));\n```",
                "[A, B, C]", "[A,B,C]", "[ABC]", "Error",
                "A", 1, 48, "medium"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nStringBuilder sb = new StringBuilder(\"AP\");\nsb.append(\"CSA\");\nSystem.out.println(sb);\n```",
                "AP", "CSA", "APCSA", "Error",
                "C", 1, 49, "medium"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Double.compare(0.1 + 0.2, 0.3));\n```",
                "0", "1", "-1", "false",
                "B", 1, 50, "hard"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"hello\".substring(5));\n```",
                "(empty string)", "Error", "h", "o",
                "A", 1, 51, "medium"));
        unit1Questions.add(new Question(
                "Which range of values can be produced?\n```java\n(int)(Math.random() * 20) + 5;\n```",
                "0-19", "5-20", "5-24", "5-19",
                "C", 1, 52, "medium"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(String.valueOf(123).length());\n```",
                "3", "123", "1", "Error",
                "A", 1, 53, "easy"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString s = \"Java\";\ns.toLowerCase();\nSystem.out.println(s);\n```",
                "java", "Java", "JAVA", "Error",
                "B", 1, 54, "medium"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nString s = null;\nSystem.out.println(s == null ? \"empty\" : s.length());\n```",
                "0", "empty", "null", "Error",
                "B", 1, 55, "medium"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"APCSA\".startsWith(\"AP\", 0));\n```",
                "true", "false", "0", "1",
                "A", 1, 56, "easy"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println((double)(5 / 2));\n```",
                "2", "2.0", "2.5", "3.0",
                "B", 1, 57, "hard"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"banana\".replaceFirst(\"a\", \"o\"));\n```",
                "bonana", "banono", "bonono", "Error",
                "A", 1, 58, "medium"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Math.min(3.2, 3));\n```",
                "3", "3.0", "3.2", "Error",
                "B", 1, 59, "medium"));
        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(String.join(\"-\", \"A\",\"B\",\"C\"));\n```",
                "A-B-C", "ABC", "A,B,C", "Error",
                "A", 1, 60, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".charAt(1));\n```",
                "H", "e", "l", "Error",
                "B", 1, 61, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Java\".indexOf('a'));\n```",
                "0", "1", "2", "3",
                "B", 1, 62, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"123\".compareTo(\"1234\"));\n```",
                "0", "1", "-1", "Error",
                "C", 1, 63, "medium"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Math.pow(2, 3));\n```",
                "6", "8", "8.0", "9.0",
                "C", 1, 64, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"AP\".concat(\"CS\"));\n```",
                "APCS", "AP CS", "AP+CS", "Error",
                "A", 1, 65, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println((int)(Math.random() * 10));\n```",
                "0-9", "1-10", "0-10", "1-9",
                "A", 1, 66, "medium"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".length());\n```",
                "4", "5", "6", "Error",
                "B", 1, 67, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".substring(1, 4));\n```",
                "ell", "ello", "Hel", "Error",
                "A", 1, 68, "medium"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Integer.parseInt(\"123\"));\n```",
                "123", "\"123\"", "123.0", "Error",
                "A", 1, 69, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".equals(\"hello\"));\n```",
                "true", "false", "0", "Error",
                "B", 1, 70, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Math.sqrt(4));\n```",
                "2", "2.0", "4", "16",
                "B", 1, 71, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".toUpperCase());\n```",
                "HELLO", "hello", "Hello", "Error",
                "A", 1, 72, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".replace('l', 'p'));\n```",
                "Heppo", "Hep", "Hello", "Error",
                "A", 1, 73, "medium"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(String.format(\"%d\", 10));\n```",
                "10", "\"10\"", "10.0", "Error",
                "A", 1, 74, "medium"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".contains(\"ell\"));\n```",
                "true", "false", "1", "Error",
                "A", 1, 75, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Math.round(3.5));\n```",
                "3", "4", "3.0", "4.0",
                "B", 1, 76, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".equalsIgnoreCase(\"HELLO\"));\n```",
                "true", "false", "1", "Error",
                "A", 1, 77, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(\"Hello\".lastIndexOf('l'));\n```",
                "1", "2", "3", "4",
                "C", 1, 78, "medium"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Double.parseDouble(\"3.14\"));\n```",
                "3", "3.14", "\"3.14\"", "Error",
                "B", 1, 79, "easy"));

        unit1Questions.add(new Question(
                "What is printed by the following code?\n```java\nSystem.out.println(Math.max(5, 3));\n```",
                "5", "5.0", "3", "3.0",
                "A", 1, 80, "easy"));

        numUnit1Questions = unit1Questions.size();
        System.out.println(String.format("There are %d questions in unit 1", numUnit1Questions));
    }

}