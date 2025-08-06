package com.Discord.DiscordBot.Units;

import static com.Discord.DiscordBot.Units.QuestionBank.unit3Questions;
import static com.Discord.DiscordBot.Units.QuestionBank.unit4Questions;

public class Unit4 {

    public static int numUnit4Questions;

    public static void initializeUnit4Questions() {

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] nums = {1, 2, 3, 4};\nSystem.out.println(nums[2]);\n```",
                "1", "2", "3", "4",
                "C", 4, 3000));

        unit4Questions.add(new Question(
                "What is the output?\n```java\nArrayList<String> list = new ArrayList<>();\nlist.add(\"A\");\nlist.add(\"B\");\nSystem.out.println(list.size());\n```",
                "0", "1", "2", "Error",
                "C", 4, 3001));

        unit4Questions.add(new Question(
                "Which enhanced for-loop correctly sums values of an array called `arr`?",
                "`for (int x : arr) sum += x;`", "`for (x in arr) sum += x;`", "`foreach (x in arr) sum += x;`", "`for (int i = 0; i <= arr.length; i++) sum += i;`",
                "A", 4, 3002));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] grid = {{1,2},{3,4}};\nSystem.out.println(grid[1][0]);\n```",
                "1", "2", "3", "4",
                "C", 4, 3003));

        unit4Questions.add(new Question(
                "Which method is used to remove an item from an ArrayList called `list`?",
                "`delete(i)`", "`remove(i)`", "`pop(i)`", "`erase(i)`",
                "B", 4, 3004));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nString[] arr = new String[3];\nSystem.out.println(arr[1]);\n```",
                "null", "\"\"", "Error", "undefined",
                "A", 4, 3005));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<Integer> list = new ArrayList<>();\nlist.add(10);\nlist.add(20);\nlist.set(0, 99);\nSystem.out.println(list);\n```",
                "[10, 20]", "[99, 20]", "[10, 99]", "[20, 99]",
                "B", 4, 3006));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] data = {5, 10, 15};\nfor (int i = 0; i < data.length; i++) {\n    data[i]++;\n}\nSystem.out.println(data[2]);\n```",
                "15", "16", "10", "5",
                "B", 4, 3007));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<String> list = new ArrayList<>();\nlist.add(\"cat\");\nlist.add(\"dog\");\nSystem.out.println(list.get(0));\n```",
                "cat", "dog", "0", "null",
                "A", 4, 3008));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] arr = new int[4];\nSystem.out.println(arr.length);\n```",
                "3", "4", "0", "Error",
                "B", 4, 3009));

        unit4Questions.add(new Question(
                "What does this return?\n```java\nint[] a = {3, 5, 2};\nArrays.sort(a);\nSystem.out.println(Arrays.toString(a));\n```",
                "[3, 5, 2]", "[2, 3, 5]", "[5, 3, 2]", "[2 3 5]",
                "B", 4, 3010));

        unit4Questions.add(new Question(
                "Which loop correctly prints all elements in a 2D array `grid`?",
                "`for (int[] row : grid) for (int val : row) System.out.print(val);`", "`foreach val in grid print(val);`", "`for (int i : grid) print(i);`", "`grid.foreach(print);`",
                "A", 4, 3011));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] mat = new int[3][2];\nSystem.out.println(mat.length);\n```",
                "2", "3", "5", "0",
                "B", 4, 3012));

        unit4Questions.add(new Question(
                "Which statement creates an ArrayList of Strings?",
                "`ArrayList list = new ArrayList<String>();`", "`ArrayList<String> list = new ArrayList<>();`", "`List<String> = new ArrayList();`", "`String list = new ArrayList<String>();`",
                "B", 4, 3013));

        unit4Questions.add(new Question(
                "What is a benefit of using enhanced for-loops?",
                "They can skip nulls", "They simplify element traversal", "They modify indexes", "They support backward iteration",
                "B", 4, 3014));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<Integer> nums = new ArrayList<>();\nnums.add(1);\nnums.add(2);\nnums.remove(1);\nSystem.out.println(nums);\n```",
                "[1, 2]", "[2]", "[1]", "[]",
                "C", 4, 3015));

        unit4Questions.add(new Question(
                "Which sorting algorithm is easiest to implement for small datasets?",
                "Bubble sort", "Quick sort", "Merge sort", "Heap sort",
                "A", 4, 3016));

        unit4Questions.add(new Question(
                "What is the result?\n```java\nint[] data = {1, 2, 3};\nint sum = 0;\nfor (int x : data) sum += x;\nSystem.out.println(sum);\n```",
                "3", "6", "0", "Error",
                "B", 4, 3017));

        unit4Questions.add(new Question(
                "How do you check if an ArrayList is empty?",
                "`list.size() == 0`", "`list.isEmpty()`", "`list == null`", "Both A and B",
                "D", 4, 3018));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] nums = new int[5];\nSystem.out.println(nums[4]);\n```",
                "0", "4", "5", "null",
                "A", 4, 3019));

        unit4Questions.add(new Question(
                "What causes an IndexOutOfBoundsException?",
                "Accessing an index < 0", "Accessing index >= size", "Accessing an empty ArrayList", "Both A and B",
                "D", 4, 3020));

        unit4Questions.add(new Question(
                "Which method adds an item to an ArrayList at index 2?",
                "`add(2, item)`", "`insert(2, item)`", "`put(2, item)`", "`append(item, 2)`",
                "A", 4, 3021));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] nums = {10, 20, 30};\nSystem.out.println(Arrays.binarySearch(nums, 20));\n```",
                "1", "2", "20", "Error",
                "A", 4, 3022));

        unit4Questions.add(new Question(
                "How do you declare a 2D int array with 3 rows and 4 columns?",
                "`int[][] arr = new int[3][4];`", "`int arr[3][4];`", "`int arr = [3][4];`", "`int arr[][] = 3, 4;`",
                "A", 4, 3023));

        unit4Questions.add(new Question(
                "Which loop prints only even numbers in `nums`?\n```java\nfor (int n : nums) {\n    // ?\n}\n```",
                "`if (n % 2 == 0) System.out.print(n);`", "`if (n % 2 != 0) continue; System.out.print(n);`", "Both A and B", "Neither",
                "C", 4, 3024));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<String> words = new ArrayList<>();\nSystem.out.println(words.get(0));\n```",
                "null", "\"\"", "Error", "0",
                "C", 4, 3025));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] table = new int[2][2];\ntable[0][0] = 7;\nSystem.out.println(table[0][0]);\n```",
                "0", "1", "7", "Error",
                "C", 4, 3026));

        unit4Questions.add(new Question(
                "Which loop properly traverses an array backwards?",
                "`for (int i = arr.length - 1; i >= 0; i--)`", "`for (int i = 0; i < arr.length; i++)`", "`foreach reverse(arr)`", "`for i from end to start`",
                "A", 4, 3027));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] nums = {1, 2, 3};\nSystem.out.println(nums[3]);\n```",
                "3", "Error", "0", "null",
                "B", 4, 3028));

        unit4Questions.add(new Question(
                "What does `list.contains(\"apple\")` return?",
                "True if \"apple\" is in the list", "Always false", "Number of times \"apple\" appears", "Its index",
                "A", 4, 3029));

        numUnit4Questions = unit3Questions.size();
        System.out.printf("There are %d questions in unit 2%n", numUnit4Questions);
    }

}
