package com.Discord.DiscordBot.Units;

import static com.Discord.DiscordBot.Units.QuestionBank.unit2Questions;

public class Unit2 {

    public static void initializeUnit2Questions() {
        // if-else questions
        unit2Questions.add(new Question(
                "What is printed when x = 5? if (x > 3) { System.out.print(\"A\"); } else { System.out.print(\"B\"); }",
                "A", "B", "AB", "Nothing",
                "A", 2));

        unit2Questions.add(new Question(
                "What is printed when x = 2? if (x % 2 == 0) { System.out.print(\"E\"); } else { System.out.print(\"O\"); }",
                "E", "O", "EO", "Nothing",
                "A", 2));

        unit2Questions.add(new Question(
                "What is printed when x = 10? if (x > 5) { System.out.print(\"M\"); } if (x > 8) { System.out.print(\"L\"); }",
                "M", "L", "ML", "LM",
                "C", 2));

// nested if-else
        unit2Questions.add(new Question(
                "What is printed when x = 7? if (x > 5) { if (x < 10) { System.out.print(\"P\"); } } else { System.out.print(\"Q\"); }",
                "P", "Q", "PQ", "Nothing",
                "A", 2));

// boolean expressions
        unit2Questions.add(new Question(
                "What is printed when a = true, b = false? System.out.print(a && b || !b);",
                "true", "false", "error", "nothing",
                "A", 2));

// while loops
        unit2Questions.add(new Question(
                "What is printed? int i = 3; while (i > 0) { System.out.print(i); i--; }",
                "321", "123", "012", "210",
                "A", 2));

// for loops
        unit2Questions.add(new Question(
                "What is printed? for (int i = 1; i < 5; i += 2) { System.out.print(i); }",
                "135", "1234", "13", "24",
                "C", 2));

// loop control
        unit2Questions.add(new Question(
                "What is printed? for (int i = 0; i < 3; i++) { if (i == 1) continue; System.out.print(i); }",
                "012", "02", "13", "023",
                "B", 2));

        unit2Questions.add(new Question(
                "What is printed? int x = 5; while (x > 0) { x -= 2; System.out.print(x); }",
                "531", "31", "53", "31-1",
                "B", 2));

// compound boolean expressions
        unit2Questions.add(new Question(
                "What is printed when x = 4? if (x >= 1 && x <= 5 || x == 10) { System.out.print(\"Y\"); } else { System.out.print(\"N\"); }",
                "Y", "N", "YN", "NY",
                "A", 2));

// nested loops
        unit2Questions.add(new Question(
                "What is printed? for (int i = 1; i <= 2; i++) { for (int j = 1; j <= 2; j++) { System.out.print(i + j); } }",
                "232434", "234", "2345", "1234",
                "B", 2));

// switch statements
        unit2Questions.add(new Question(
                "What is printed when day = 2? switch(day) { case 1: System.out.print(\"M\"); break; case 2: System.out.print(\"T\"); break; default: System.out.print(\"X\"); }",
                "M", "T", "X", "MT",
                "B", 2));

// post vs pre increment
        unit2Questions.add(new Question(
                "What is printed? int x = 3; System.out.print(x++ + ++x);",
                "6", "7", "8", "9",
                "C", 2));

// loop edge cases
        unit2Questions.add(new Question(
                "What is printed? for (int i = 5; i > 5; i--) { System.out.print(i); }",
                "5", "54321", "Nothing", "Infinite loop",
                "C", 2));

// complex conditionals
        unit2Questions.add(new Question(
                "What is printed when x = 6? if (!(x < 5) && x != 7) { System.out.print(\"C\"); }",
                "C", "Nothing", "error", "true",
                "A", 2));

// loop with break
        unit2Questions.add(new Question(
                "What is printed? for (int i = 0; i < 5; i++) { if (i == 3) break; System.out.print(i); }",
                "012", "0123", "01234", "123",
                "A", 2));

// modulus in loops
        unit2Questions.add(new Question(
                "What is printed? for (int i = 1; i <= 5; i++) { if (i % 2 == 0) System.out.print(i); }",
                "135", "24", "246", "12345",
                "B", 2));

// string manipulation with loops
        unit2Questions.add(new Question(
                "What is printed? String s = \"abc\"; for (int i = 0; i < s.length(); i++) { System.out.print(s.charAt(i) + 1); }",
                "bcd", "98 99 100", "abc1", "error",
                "B", 2));

// nested if complexity
        unit2Questions.add(new Question(
                "What is printed when x = 12, y = 5? if (x > 10) { if (y > 3) { System.out.print(\"A\"); } } else { System.out.print(\"B\"); }",
                "A", "B", "AB", "Nothing",
                "A", 2));

// loop variable scope
        unit2Questions.add(new Question(
                "What is printed? for (int i = 0; i < 2; i++) { int x = i; } System.out.print(x);",
                "01", "0", "1", "error",
                "D", 2));

// compound assignment in loops
        unit2Questions.add(new Question(
                "What is printed? int x = 10; while (x > 0) { x /= 2; System.out.print(x + \" \"); }",
                "5 2 1 0", "5 2 1", "10 5 2 1", "5 2 1 0.5",
                "A", 2));

// logical operator precedence
        unit2Questions.add(new Question(
                "What is printed when a = true, b = false? System.out.print(a || b && !a);",
                "true", "false", "error", "nothing",
                "A", 2));

// loop with multiple variables
        unit2Questions.add(new Question(
                "What is printed? for (int i = 0, j = 2; i < j; i++, j--) { System.out.print(i + j); }",
                "2", "22", "20", "02",
                "A", 2));

// switch without break
        unit2Questions.add(new Question(
                "What is printed when n = 1? switch(n) { case 1: System.out.print(\"A\"); case 2: System.out.print(\"B\"); default: System.out.print(\"C\"); }",
                "A", "AB", "ABC", "C",
                "C", 2));

// do-while loop
        unit2Questions.add(new Question(
                "What is printed? int x = 5; do { System.out.print(x); x--; } while (x > 3);",
                "5", "54", "543", "54",
                "B", 2));

// loop with array
        unit2Questions.add(new Question(
                "What is printed? int[] arr = {1,2,3}; for (int num : arr) { System.out.print(num * 2); }",
                "123", "246", "135", "error",
                "B", 2));

// complex loop condition
        unit2Questions.add(new Question(
                "What is printed? for (int i = 1; i < 10; i *= 2) { System.out.print(i); }",
                "1248", "1234", "2468", "1357",
                "A", 2));

// nested if-else if
        unit2Questions.add(new Question(
                "What is printed when score = 85? if (score >= 90) { System.out.print(\"A\"); } else if (score >= 80) { System.out.print(\"B\"); } else { System.out.print(\"C\"); }",
                "A", "B", "C", "AB",
                "B", 2));

// loop with String manipulation
        unit2Questions.add(new Question(
                "What is printed? String s = \"java\"; for (int i = s.length()-1; i >= 0; i--) { System.out.print(s.charAt(i)); }",
                "java", "avaj", "j a v a", "a v a j",
                "B", 2));
        System.out.println(String.format("There are %s unit 2 questions", unit2Questions.size()));
    }


}
