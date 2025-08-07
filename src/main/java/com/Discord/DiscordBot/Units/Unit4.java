package com.Discord.DiscordBot.Units;

import static com.Discord.DiscordBot.Units.QuestionBank.unit3Questions;
import static com.Discord.DiscordBot.Units.QuestionBank.unit4Questions;

public class Unit4 {

    public static int numUnit4Questions;

    public static void initializeUnit4Questions() {

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] nums = {1, 2, 3, 4};\nSystem.out.println(nums[2]);\n```",
                "1", "2", "3", "4",
                "C", 4, 3000, "easy"));

        unit4Questions.add(new Question(
                "What is the output?\n```java\nArrayList<String> list = new ArrayList<>();\nlist.add(\"A\");\nlist.add(\"B\");\nSystem.out.println(list.size());\n```",
                "0", "1", "2", "Error",
                "C", 4, 3001, "easy"));

        unit4Questions.add(new Question(
                "Which enhanced for-loop correctly sums values of an array called `arr`?",
                "`for (int x : arr) sum += x;`", "`for (x in arr) sum += x;`", "`foreach (x in arr) sum += x;`", "`for (int i = 0; i <= arr.length; i++) sum += i;`",
                "A", 4, 3002, "easy"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] grid = {{1,2},{3,4}};\nSystem.out.println(grid[1][0]);\n```",
                "1", "2", "3", "4",
                "C", 4, 3003, "easy"));

        unit4Questions.add(new Question(
                "Which method is used to remove an item from an ArrayList called `list`?",
                "`delete(i)`", "`remove(i)`", "`pop(i)`", "`erase(i)`",
                "B", 4, 3004, "easy"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nString[] arr = new String[3];\nSystem.out.println(arr[1]);\n```",
                "null", "\"\"", "Error", "undefined",
                "A", 4, 3005, "easy"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<Integer> list = new ArrayList<>();\nlist.add(10);\nlist.add(20);\nlist.set(0, 99);\nSystem.out.println(list);\n```",
                "[10, 20]", "[99, 20]", "[10, 99]", "[20, 99]",
                "B", 4, 3006, "medium"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] data = {5, 10, 15};\nfor (int i = 0; i < data.length; i++) {\n    data[i]++;\n}\nSystem.out.println(data[2]);\n```",
                "15", "16", "10", "5",
                "B", 4, 3007, "easy"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<String> list = new ArrayList<>();\nlist.add(\"cat\");\nlist.add(\"dog\");\nSystem.out.println(list.get(0));\n```",
                "cat", "dog", "0", "null",
                "A", 4, 3008, "easy"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] arr = new int[4];\nSystem.out.println(arr.length);\n```",
                "3", "4", "0", "Error",
                "B", 4, 3009, "easy"));

        unit4Questions.add(new Question(
                "What does this return?\n```java\nint[] a = {3, 5, 2};\nArrays.sort(a);\nSystem.out.println(Arrays.toString(a));\n```",
                "[3, 5, 2]", "[2, 3, 5]", "[5, 3, 2]", "[2 3 5]",
                "B", 4, 3010, "easy"));

        unit4Questions.add(new Question(
                "Which loop correctly prints all elements in a 2D array `grid`?",
                "`for (int[] row : grid) for (int val : row) System.out.print(val);`", "`foreach val in grid print(val);`", "`for (int i : grid) print(i);`", "`grid.foreach(print);`",
                "A", 4, 3011, "medium"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] mat = new int[3][2];\nSystem.out.println(mat.length);\n```",
                "2", "3", "5", "0",
                "B", 4, 3012, "easy"));

        unit4Questions.add(new Question(
                "Which statement creates an ArrayList of Strings?",
                "`ArrayList list = new ArrayList<String>();`", "`ArrayList<String> list = new ArrayList<>();`", "`List<String> = new ArrayList();`", "`String list = new ArrayList<String>();`",
                "B", 4, 3013, "easy"));

        unit4Questions.add(new Question(
                "What is a benefit of using enhanced for-loops?",
                "They can skip nulls", "They simplify element traversal", "They modify indexes", "They support backward iteration",
                "B", 4, 3014, "easy"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<Integer> nums = new ArrayList<>();\nnums.add(1);\nnums.add(2);\nnums.remove(1);\nSystem.out.println(nums);\n```",
                "[1, 2]", "[2]", "[1]", "[]",
                "C", 4, 3015, "medium"));

        unit4Questions.add(new Question(
                "Which sorting algorithm is easiest to implement for small datasets?",
                "Bubble sort", "Quick sort", "Merge sort", "Heap sort",
                "A", 4, 3016, "easy"));

        unit4Questions.add(new Question(
                "What is the result?\n```java\nint[] data = {1, 2, 3};\nint sum = 0;\nfor (int x : data) sum += x;\nSystem.out.println(sum);\n```",
                "3", "6", "0", "Error",
                "B", 4, 3017, "easy"));

        unit4Questions.add(new Question(
                "How do you check if an ArrayList is empty?",
                "`list.size() == 0`", "`list.isEmpty()`", "`list == null`", "Both A and B",
                "D", 4, 3018, "easy"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] nums = new int[5];\nSystem.out.println(nums[4]);\n```",
                "0", "4", "5", "null",
                "A", 4, 3019, "easy"));

        unit4Questions.add(new Question(
                "What causes an IndexOutOfBoundsException?",
                "Accessing an index < 0", "Accessing index >= size", "Accessing an empty ArrayList", "Both A and B",
                "D", 4, 3020, "easy"));

        unit4Questions.add(new Question(
                "Which method adds an item to an ArrayList at index 2?",
                "`add(2, item)`", "`insert(2, item)`", "`put(2, item)`", "`append(item, 2)`",
                "A", 4, 3021, "easy"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] nums = {10, 20, 30};\nSystem.out.println(Arrays.binarySearch(nums, 20));\n```",
                "1", "2", "20", "Error",
                "A", 4, 3022, "medium"));

        unit4Questions.add(new Question(
                "How do you declare a 2D int array with 3 rows and 4 columns?",
                "`int[][] arr = new int[3][4];`", "`int arr[3][4];`", "`int arr = [3][4];`", "`int arr[][] = 3, 4;`",
                "A", 4, 3023, "easy"));

        unit4Questions.add(new Question(
                "Which loop prints only even numbers in `nums`?\n```java\nfor (int n : nums) {\n    // ?\n}\n```",
                "`if (n % 2 == 0) System.out.print(n);`", "`if (n % 2 != 0) continue; System.out.print(n);`", "Both A and B", "Neither",
                "C", 4, 3024, "medium"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<String> words = new ArrayList<>();\nSystem.out.println(words.get(0));\n```",
                "null", "\"\"", "Error", "0",
                "C", 4, 3025, "easy"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] table = new int[2][2];\ntable[0][0] = 7;\nSystem.out.println(table[0][0]);\n```",
                "0", "1", "7", "Error",
                "C", 4, 3026, "easy"));

        unit4Questions.add(new Question(
                "Which loop properly traverses an array backwards?",
                "`for (int i = arr.length - 1; i >= 0; i--)`", "`for (int i = 0; i < arr.length; i++)`", "`foreach reverse(arr)`", "`for i from end to start`",
                "A", 4, 3027, "easy"));

        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] nums = {1, 2, 3};\nSystem.out.println(nums[3]);\n```",
                "3", "Error", "0", "null",
                "B", 4, 3028, "easy"));

        unit4Questions.add(new Question(
                "What does `list.contains(\"apple\")` return?",
                "True if \"apple\" is in the list", "Always false", "Number of times \"apple\" appears", "Its index",
                "A", 4, 3029, "easy"));
// ArrayList element swapping
        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<Integer> list = new ArrayList<>();\nlist.add(10);\nlist.add(20);\nlist.add(30);\nint temp = list.get(0);\nlist.set(0, list.get(2));\nlist.set(2, temp);\nSystem.out.println(list);\n```",
                "[10, 20, 30]", "[30, 20, 10]", "[20, 10, 30]", "[10, 30, 20]",
                "B", 4, 3030, "medium"));

// Array traversal with condition
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] arr = {5, 3, 7, 2};\nint count = 0;\nfor (int num : arr) {\n    if (num > 4) count++;\n}\nSystem.out.println(count);\n```",
                "1", "2", "3", "4",
                "B", 4, 3031, "easy"));

// 2D array row length
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] grid = new int[3][4];\nSystem.out.println(grid[0].length);\n```",
                "3", "4", "0", "12",
                "B", 4, 3032, "easy"));

// ArrayList remove by value
        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<String> words = new ArrayList<>();\nwords.add(\"apple\");\nwords.add(\"banana\");\nwords.remove(\"apple\");\nSystem.out.println(words.size());\n```",
                "0", "1", "2", "Error",
                "B", 4, 3033, "medium"));

// Array initialization
        unit4Questions.add(new Question(
                "Which correctly initializes an array of 5 zeros?",
                "`int[] arr = {0, 0, 0, 0, 0};`", "`int[] arr = new int[5];`", "Both A and B", "Neither",
                "C", 4, 3034, "easy"));

// Enhanced for-loop modification
        unit4Questions.add(new Question(
                "What happens when this runs?\n```java\nint[] nums = {1, 2, 3};\nfor (int num : nums) {\n    num += 5;\n}\n```",
                "nums becomes [6,7,8]", "nums stays [1,2,3]", "Error", "Infinite loop",
                "B", 4, 3035, "medium"));

// ArrayList vs array size
        unit4Questions.add(new Question(
                "What is the difference between array.length and list.size()?",
                "array.length is a method", "list.size() is a field", "No difference", "array.length is a field, list.size() is a method",
                "D", 4, 3036, "easy"));

// Binary search requirement
        unit4Questions.add(new Question(
                "What is required for Arrays.binarySearch() to work correctly?",
                "Array must be sorted", "Array must be full", "Array must be 2D", "Array must be odd length",
                "A", 4, 3037, "easy"));

// 2D array initialization
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] mat = {{1}, {2, 3}, {4, 5, 6}};\nSystem.out.println(mat[2][1]);\n```",
                "3", "5", "6", "Error",
                "B", 4, 3038, "medium"));

// ArrayList type safety
        unit4Questions.add(new Question(
                "Why use ArrayList<Integer> instead of ArrayList?",
                "Better performance", "Compile-time type checking", "Smaller memory footprint", "Allows mixed types",
                "B", 4, 3039, "easy"));
// ArrayList add at specific index
        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<String> colors = new ArrayList<>();\ncolors.add(\"red\");\ncolors.add(0, \"blue\");\nSystem.out.println(colors.get(1));\n```",
                "blue", "red", "Error", "null",
                "B", 4, 3040, "medium"));

// Array reference assignment
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] a = {1, 2, 3};\nint[] b = a;\nb[1] = 5;\nSystem.out.println(a[1]);\n```",
                "1", "2", "5", "Error",
                "C", 4, 3041, "hard"));

// 2D array row traversal
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] grid = {{1, 2}, {3, 4}};\nint sum = 0;\nfor (int num : grid[0]) {\n    sum += num;\n}\nSystem.out.println(sum);\n```",
                "1", "3", "6", "10",
                "B", 4, 3042, "easy"));

// ArrayList contains with objects
        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<Integer> nums = new ArrayList<>();\nnums.add(5);\nnums.add(10);\nSystem.out.println(nums.contains(10));\n```",
                "true", "false", "Error", "null",
                "A", 4, 3043, "easy"));

// Array initialization with loop
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] arr = new int[4];\nfor (int i = 1; i < arr.length; i++) {\n    arr[i] = i * 2;\n}\nSystem.out.println(arr[3]);\n```",
                "0", "4", "6", "Error",
                "C", 4, 3044, "medium"));

// ArrayList remove vs set
        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<String> list = new ArrayList<>();\nlist.add(\"A\");\nlist.add(\"B\");\nlist.set(0, \"C\");\nlist.remove(1);\nSystem.out.println(list);\n```",
                "[A]", "[B]", "[C]", "[]",
                "C", 4, 3045, "hard"));

// Array bounds checking
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] data = {10, 20, 30};\nSystem.out.println(data[data.length - 1]);\n```",
                "10", "20", "30", "Error",
                "C", 4, 3046, "easy"));

// Enhanced for-loop with ArrayList
        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<Integer> values = new ArrayList<>();\nvalues.add(1);\nvalues.add(2);\nvalues.add(3);\nint total = 0;\nfor (int val : values) {\n    total += val;\n}\nSystem.out.println(total);\n```",
                "0", "3", "5", "6",
                "D", 4, 3047, "easy"));

// 2D array column access
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] table = {{1, 2}, {3, 4}, {5, 6}};\nSystem.out.println(table[2][0]);\n```",
                "3", "4", "5", "6",
                "C", 4, 3048, "easy"));

// ArrayList clear method
        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<Double> temps = new ArrayList<>();\ntemps.add(98.6);\ntemps.clear();\nSystem.out.println(temps.size());\n```",
                "0", "1", "98.6", "Error",
                "A", 4, 3049, "easy"));

        // Array element swapping
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] arr = {5, 10, 15};\nint temp = arr[0];\narr[0] = arr[2];\narr[2] = temp;\nSystem.out.println(Arrays.toString(arr));\n```",
                "[5, 10, 15]", "[15, 10, 5]", "[10, 5, 15]", "[5, 15, 10]",
                "B", 4, 3050, "easy"));

// ArrayList indexOf
        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<String> fruits = new ArrayList<>();\nfruits.add(\"apple\");\nfruits.add(\"banana\");\nfruits.add(\"apple\");\nSystem.out.println(fruits.indexOf(\"banana\"));\n```",
                "0", "1", "2", "-1",
                "B", 4, 3051, "easy"));

// 2D array column sum
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] grid = {{1,2,3},{4,5,6}};\nint sum = 0;\nfor (int[] row : grid) {\n    sum += row[1];\n}\nSystem.out.println(sum);\n```",
                "5", "7", "15", "21",
                "B", 4, 3052, "medium"));

// Array copy behavior
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] original = {1, 2, 3};\nint[] copy = original;\ncopy[1] = 5;\nSystem.out.println(original[1]);\n```",
                "1", "2", "5", "Error",
                "C", 4, 3053, "hard"));

// ArrayList lastIndexOf
        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<Integer> nums = new ArrayList<>();\nnums.add(5);\nnums.add(2);\nnums.add(5);\nSystem.out.println(nums.lastIndexOf(5));\n```",
                "0", "1", "2", "-1",
                "C", 4, 3054, "easy"));

// Array algorithm (find max)
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] values = {3, 9, 4, 1};\nint max = values[0];\nfor (int i = 1; i < values.length; i++) {\n    if (values[i] > max) max = values[i];\n}\nSystem.out.println(max);\n```",
                "1", "3", "4", "9",
                "D", 4, 3055, "medium"));

// 2D array ragged rows
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[][] mat = new int[3][];\nmat[0] = new int[2];\nmat[1] = new int[3];\nSystem.out.println(mat[2]);\n```",
                "0", "null", "[]", "Error",
                "B", 4, 3056, "hard"));

// ArrayList to Array conversion
        unit4Questions.add(new Question(
                "What is printed?\n```java\nArrayList<String> list = new ArrayList<>();\nlist.add(\"A\");\nlist.add(\"B\");\nString[] arr = list.toArray(new String[0]);\nSystem.out.println(arr[1]);\n```",
                "A", "B", "0", "Error",
                "B", 4, 3057, "medium"));

// Array algorithm (count condition)
        unit4Questions.add(new Question(
                "What is printed?\n```java\nint[] data = {4, 7, 2, 8, 5};\nint count = 0;\nfor (int num : data) {\n    if (num > 5) count++;\n}\nSystem.out.println(count);\n```",
                "1", "2", "3", "5",
                "B", 4, 3058, "easy"));

// ArrayList vs array initialization
        unit4Questions.add(new Question(
                "Which is a valid difference between arrays and ArrayLists?",
                "Arrays have fixed size, ArrayLists can grow", "ArrayLists are faster for access", "Arrays can only hold primitives", "ArrayLists use [] syntax",
                "A", 4, 3059, "easy"));

        numUnit4Questions = unit4Questions.size();
        System.out.printf("There are %d questions in unit 4%n", numUnit4Questions);
    }

}
