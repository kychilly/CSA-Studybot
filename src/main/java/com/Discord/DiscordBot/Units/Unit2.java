package com.Discord.DiscordBot.Units;

import static com.Discord.DiscordBot.Units.QuestionBank.unit2Questions;

public class Unit2 {

    public static int numUnit2Questions;

    public static void initializeUnit2Questions() {

        // if-else questions
        unit2Questions.add(new Question(
                "What is printed when x = 5?\n```java\nif (x > 3) {\n    System.out.print(\"A\");\n} else {\n    System.out.print(\"B\");\n}\n```",
                "A", "B", "AB", "Nothing",
                "A", 2, 1000));

        unit2Questions.add(new Question(
                "What is printed when x = 2?\n```java\nif (x % 2 == 0) {\n    System.out.print(\"E\");\n} else {\n    System.out.print(\"O\");\n}\n```",
                "E", "O", "EO", "Nothing",
                "A", 2, 1001));

        unit2Questions.add(new Question(
                "What is printed when x = 10?\n```java\nif (x > 5) {\n    System.out.print(\"M\");\n}\nif (x > 8) {\n    System.out.print(\"L\");\n}\n```",
                "M", "L", "ML", "LM",
                "C", 2, 1002));

        // nested if-else
        unit2Questions.add(new Question(
                "What is printed when x = 7?\n```java\nif (x > 5) {\n    if (x < 10) {\n        System.out.print(\"P\");\n    }\n} else {\n    System.out.print(\"Q\");\n}\n```",
                "P", "Q", "PQ", "Nothing",
                "A", 2, 1003));

        // boolean expressions
        unit2Questions.add(new Question(
                "What is printed when a = true, b = false?\n```java\nSystem.out.print(a && b || !b);\n```",
                "true", "false", "error", "nothing",
                "A", 2, 1004));

        // while loops
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint i = 3;\nwhile (i > 0) {\n    System.out.print(i);\n    i--;\n}\n```",
                "321", "123", "012", "210",
                "A", 2, 1005));

        // for loops
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 1; i < 5; i += 2) {\n    System.out.print(i);\n}\n```",
                "135", "1234", "13", "24",
                "C", 2, 1006));

        // loop control
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 0; i < 3; i++) {\n    if (i == 1) continue;\n    System.out.print(i);\n}\n```",
                "012", "02", "13", "023",
                "B", 2, 1007));

        unit2Questions.add(new Question(
                "What is printed?\n```java\nint x = 5;\nwhile (x > 0) {\n    x -= 2;\n    System.out.print(x);\n}\n```",
                "531", "31", "53", "31-1",
                "B", 2, 1008));

        // compound boolean expressions
        unit2Questions.add(new Question(
                "What is printed when x = 4?\n```java\nif (x >= 1 && x <= 5 || x == 10) {\n    System.out.print(\"Y\");\n} else {\n    System.out.print(\"N\");\n}\n```",
                "Y", "N", "YN", "NY",
                "A", 2, 1009));

        // nested loops
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 1; i <= 2; i++) {\n    for (int j = 1; j <= 2; j++) {\n        System.out.print(i + j);\n    }\n}\n```",
                "232434", "234", "2345", "1234",
                "B", 2, 1010));

        // switch statements
        unit2Questions.add(new Question(
                "What is printed when day = 2?\n```java\nswitch(day) {\n    case 1: System.out.print(\"M\"); break;\n    case 2: System.out.print(\"T\"); break;\n    default: System.out.print(\"X\");\n}\n```",
                "M", "T", "X", "MT",
                "B", 2, 1011));

        // post vs pre increment
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint x = 3;\nSystem.out.print(x++ + ++x);\n```",
                "6", "7", "8", "9",
                "C", 2, 1012));

        // loop edge cases
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 5; i > 5; i--) {\n    System.out.print(i);\n}\n```",
                "5", "54321", "Nothing", "Infinite loop",
                "C", 2, 1013));

        // complex conditionals
        unit2Questions.add(new Question(
                "What is printed when x = 6?\n```java\nif (!(x < 5) && x != 7) {\n    System.out.print(\"C\");\n}\n```",
                "C", "Nothing", "error", "true",
                "A", 2, 1014));

        // loop with break
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 0; i < 5; i++) {\n    if (i == 3) break;\n    System.out.print(i);\n}\n```",
                "012", "0123", "01234", "123",
                "A", 2, 1015));

        // modulus in loops
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 1; i <= 5; i++) {\n    if (i % 2 == 0)\n        System.out.print(i);\n}\n```",
                "135", "24", "246", "12345",
                "B", 2, 1016));

        // string manipulation with loops
        unit2Questions.add(new Question(
                "What is printed?\n```java\nString s = \"abc\";\nfor (int i = 0; i < s.length(); i++) {\n    System.out.print(s.charAt(i) + 1);\n}\n```",
                "bcd", "98 99 100", "abc1", "error",
                "B", 2, 1017));

        // nested if complexity
        unit2Questions.add(new Question(
                "What is printed when x = 12, y = 5?\n```java\nif (x > 10) {\n    if (y > 3) {\n        System.out.print(\"A\");\n    }\n} else {\n    System.out.print(\"B\");\n}\n```",
                "A", "B", "AB", "Nothing",
                "A", 2, 1018));

        // loop variable scope
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 0; i < 2; i++) {\n    int x = i;\n}\nSystem.out.print(x);\n```",
                "01", "0", "1", "error",
                "D", 2, 1019));

        // compound assignment in loops
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint x = 10;\nwhile (x > 0) {\n    x /= 2;\n    System.out.print(x + \" \");\n}\n```",
                "5 2 1 0", "5 2 1", "10 5 2 1", "5 2 1 0.5",
                "A", 2, 1020));

        // logical operator precedence
        unit2Questions.add(new Question(
                "What is printed when a = true, b = false?\n```java\nSystem.out.print(a || b && !a);\n```",
                "true", "false", "error", "nothing",
                "A", 2, 1021));

        // loop with multiple variables
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 0, j = 2; i < j; i++, j--) {\n    System.out.print(i + j);\n}\n```",
                "2", "22", "20", "02",
                "A", 2, 1022));

        // switch without break
        unit2Questions.add(new Question(
                "What is printed when n = 1?\n```java\nswitch(n) {\n    case 1: System.out.print(\"A\");\n    case 2: System.out.print(\"B\");\n    default: System.out.print(\"C\");\n}\n```",
                "A", "AB", "ABC", "C",
                "C", 2, 1023));

        // do-while loop
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint x = 5;\ndo {\n    System.out.print(x);\n    x--;\n} while (x > 3);\n```",
                "5", "54", "543", "54",
                "B", 2, 1024));

        // loop with array
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint[] arr = {1, 2, 3};\nfor (int num : arr) {\n    System.out.print(num * 2);\n}\n```",
                "123", "246", "135", "error",
                "B", 2, 1025));

        // complex loop condition
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 1; i < 10; i *= 2) {\n    System.out.print(i);\n}\n```",
                "1248", "1234", "2468", "1357",
                "A", 2, 1026));

        // nested if-else if
        unit2Questions.add(new Question(
                "What is printed when score = 85?\n```java\nif (score >= 90) {\n    System.out.print(\"A\");\n} else if (score >= 80) {\n    System.out.print(\"B\");\n} else {\n    System.out.print(\"C\");\n}\n```",
                "A", "B", "C", "AB",
                "B", 2, 1027));

        // loop with String manipulation
        unit2Questions.add(new Question(
                "What is printed?\n```java\nString s = \"java\";\nfor (int i = s.length() - 1; i >= 0; i--) {\n    System.out.print(s.charAt(i));\n}\n```",
                "java", "avaj", "j a v a", "a v a j",
                "B", 2, 1028));

        // Enhanced for loop with array
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint[] nums = {3, 1, 4};\nfor (int n : nums) {\n    System.out.print(n % 2);\n}\n```",
                "314", "101", "3 1 4", "1 1 0",
                "B", 2, 1029));

// Compound boolean logic
        unit2Questions.add(new Question(
                "What is printed when x = 7?\n```java\nSystem.out.print((x > 5) == !(x <= 5));\n```",
                "true", "false", "Error", "7",
                "A", 2, 1030));

// Nested loops with break
        unit2Questions.add(new Question(
                "What is printed?\n```java\nouter:\nfor (int i = 0; i < 3; i++) {\n    for (int j = 0; j < 3; j++) {\n        if (i == j) break outer;\n        System.out.print(i+j);\n    }\n}\n```",
                "0", "024", "02", "Nothing",
                "A", 2, 1031));

// Switch expression (Java 14+)
        unit2Questions.add(new Question(
                "What is printed when n = 2?\n```java\nSystem.out.print(switch(n) {\n    case 1 -> \"A\";\n    case 2 -> \"B\";\n    default -> \"C\";\n});\n```",
                "A", "B", "C", "Error",
                "B", 2, 1032));

// Loop with continue
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 0; i < 4; i++) {\n    if (i == 2) continue;\n    System.out.print(i);\n}\n```",
                "0123", "013", "123", "023",
                "B", 2, 1033));

// Logical operator precedence
        unit2Questions.add(new Question(
                "What is printed when a=true, b=false?\n```java\nSystem.out.print(a || b && false);\n```",
                "true", "false", "Error", "null",
                "A", 2, 1034));

// Do-while edge case
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint x = 1;\ndo {\n    x *= 2;\n} while (x < 0);\nSystem.out.print(x);\n```",
                "1", "2", "0", "Infinite loop",
                "B", 2, 1035));

// String traversal with while
        unit2Questions.add(new Question(
                "What is printed?\n```java\nString s = \"AP\";\nint i = 0;\nwhile (i < s.length()) {\n    System.out.print(s.charAt(i));\n    i++;\n}\n```",
                "AP", "A P", "0 1", "Error",
                "A", 2, 1036));

// Modulus in conditionals
        unit2Questions.add(new Question(
                "What is printed when num=15?\n```java\nSystem.out.print(num % 10 == 5 ? \"Yes\" : \"No\");\n```",
                "Yes", "No", "15", "Error",
                "A", 2, 1037));

// Loop counter manipulation
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 0; i < 5; i += 2) {\n    System.out.print(i);\n    i--;\n}\n```",
                "0-1-2-3-4", "02", "024", "Infinite loop",
                "D", 2, 1038));

        unit2Questions.add(new Question(
                "What is printed when x = 3 and y = 5?\n```java\nif (x > 2 && y < 6 || x + y == 8) {\n    System.out.print(\"A\");\n} else {\n    System.out.print(\"B\");\n}\n```",
                "A", "B", "AB", "Error",
                "A", 2, 1039));
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint x = 5;\nwhile (x > 0 && x % 2 == 1) {\n    System.out.print(x);\n    x -= 2;\n}\n```",
                "5", "53", "531", "53-1",
                "B", 2, 1040));
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 0; i < 10; i++) {\n    if (i * i > 10) break;\n    System.out.print(i);\n}\n```",
                "0123", "01234", "012", "012345",
                "A", 2, 1041));
        unit2Questions.add(new Question(
                "What is printed when s = \"hello\"?\n```java\nif (s.equals(\"hello\")) {\n    if (s.length() > 4) {\n        System.out.print(\"A\");\n    } else {\n        System.out.print(\"B\");\n    }\n} else {\n    System.out.print(\"C\");\n}\n```",
                "A", "B", "C", "AC",
                "A", 2, 1042));
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint i = 1;\ndo {\n    System.out.print(i++);\n} while (i <= 3);\n```",
                "123", "12", "23", "234",
                "A", 2, 1043));
        unit2Questions.add(new Question(
                "What is printed when a = true and b = false?\n```java\nSystem.out.print(!a || b && a);\n```",
                "true", "false", "Error", "null",
                "B", 2, 1044));
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 1, j = 4; i < j; i++, j--) {\n    System.out.print(i + j);\n}\n```",
                "5", "57", "5-7", "57-9",
                "A", 2, 1045));
        unit2Questions.add(new Question(
                "What is printed when day = 3?\n```java\nswitch(day) {\n    case 1: System.out.print(\"M\");\n    case 2: System.out.print(\"T\");\n    case 3: System.out.print(\"W\");\n    default: System.out.print(\"F\");\n}\n```",
                "W", "WF", "WTF", "F",
                "B", 2, 1046));
        unit2Questions.add(new Question(
                "What is printed?\n```java\nString word = \"loop\";\nfor (int i = 0; i < word.length(); i += 2) {\n    System.out.print(word.charAt(i));\n}\n```",
                "loop", "lo", "lp", "oo",
                "C", 2, 1047));
        unit2Questions.add(new Question(
                "What is printed when x = 4 and y = 5?\n```java\nif (x++ > 4) {\n    if (--y < 5) {\n        System.out.print(\"A\");\n    }\n} else {\n    System.out.print(\"B\");\n}\nSystem.out.print(y);\n```",
                "A5", "B4", "B5", "A4",
                "C", 2, 1048));
        // Complex Boolean Evaluation
        unit2Questions.add(new Question(
                "What is printed when x = 5, y = 3?\n```java\nSystem.out.print(x > 3 && y < 4 || x + y == 8);\n```",
                "true", "false", "Error", "5",
                "A", 2, 1049));

// Nested Loop Pattern
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 1; i <= 2; i++) {\n    for (int j = 1; j <= i; j++) {\n        System.out.print(j);\n    }\n}\n```",
                "112", "1212", "112123", "12",
                "A", 2, 1050));

// Switch with Return Values
        unit2Questions.add(new Question(
                "What is printed when choice = 2?\n```java\nString result = switch(choice) {\n    case 1 -> \"A\";\n    case 2 -> { yield \"B\"; }\n    default -> \"C\";\n};\nSystem.out.print(result);\n```",
                "A", "B", "C", "Error",
                "B", 2, 1051));

// Loop with Conditional Continue
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 0; i < 5; i++) {\n    if (i % 2 != 0) continue;\n    System.out.print(i);\n}\n```",
                "024", "135", "01234", "1234",
                "A", 2, 1052));

// Compound Assignment in While
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint x = 10;\nwhile ((x /= 2) > 1) {\n    System.out.print(x);\n}\n```",
                "52", "5", "52", "521",
                "A", 2, 1053));

// String Character Check
        unit2Questions.add(new Question(
                "What is printed when s = \"apple\"?\n```java\nSystem.out.print(s.length() > 4 && s.charAt(0) == 'a');\n```",
                "true", "false", "Error", "apple",
                "A", 2, 1054));

// Nested If with Decrement
        unit2Questions.add(new Question(
                "What is printed when num = 4?\n```java\nif (num-- > 3) {\n    if (++num == 4) {\n        System.out.print(num);\n    }\n}\n```",
                "3", "4", "5", "Nothing",
                "B", 2, 1055));

// Loop with Multiple Conditions
        unit2Questions.add(new Question(
                "What is printed?\n```java\nfor (int i = 1; i < 10; i *= 3) {\n    System.out.print(i);\n}\n```",
                "139", "13", "147", "369",
                "A", 2, 1056));

// Boolean Expression Evaluation
        unit2Questions.add(new Question(
                "What is printed when a = false, b = true?\n```java\nSystem.out.print(!(a || b) && (b || a));\n```",
                "true", "false", "Error", "null",
                "B", 2, 1057));

// Complex Loop Control
        unit2Questions.add(new Question(
                "What is printed?\n```java\nint count = 0;\nouter:\nfor (int i = 0; i < 3; i++) {\n    for (int j = 0; j < 3; j++) {\n        if (i == j) continue outer;\n        count++;\n    }\n}\nSystem.out.print(count);\n```",
                "6", "9", "3", "0",
                "A", 2, 1058));

        numUnit2Questions = unit2Questions.size();
        System.out.printf("There are %d questions in unit 2%n", numUnit2Questions);
    }



}
