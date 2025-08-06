package com.Discord.DiscordBot.Units;

import static com.Discord.DiscordBot.Units.QuestionBank.unit3Questions;

public class Unit3 {

    public static int numUnit3Questions;

    public static void initializeUnit3Questions() {

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Dog {\n    private String name;\n    public Dog(String n) {\n        name = n;\n    }\n    public void bark() {\n        System.out.println(name + \" says woof\");\n    }\n}\n\nDog d = new Dog(\"Max\");\nd.bark();\n```",
                "says woof", "Max says woof", "null says woof", "Dog says woof",
                "B", 3, 2000));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Student {\n    private int grade;\n    public Student(int g) {\n        grade = g;\n    }\n    public int getGrade() {\n        return grade;\n    }\n}\n\nStudent s = new Student(90);\nSystem.out.println(s.getGrade());\n```",
                "0", "null", "90", "Error",
                "C", 3, 2001));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Counter {\n    private int count = 0;\n    public void increment() {\n        count++;\n    }\n    public int getCount() {\n        return count;\n    }\n}\n\nCounter c = new Counter();\nc.increment();\nc.increment();\nSystem.out.println(c.getCount());\n```",
                "0", "1", "2", "Error",
                "C", 3, 2002));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Box {\n    private int size;\n    public Box(int s) {\n        size = s;\n    }\n    public void printSize() {\n        System.out.print(size);\n    }\n}\n\nBox b1 = new Box(3);\nBox b2 = new Box(7);\nb1.printSize();\nb2.printSize();\n```",
                "37", "73", "3 7", "Error",
                "A", 3, 2003));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Book {\n    private String title;\n    public Book() {\n        title = \"Unknown\";\n    }\n    public void printTitle() {\n        System.out.println(title);\n    }\n}\n\nBook b = new Book();\nb.printTitle();\n```",
                "null", "title", "Unknown", "Error",
                "C", 3, 2004));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Car {\n    private String model;\n    public Car(String model) {\n        this.model = model;\n    }\n    public String getModel() {\n        return model;\n    }\n}\n\nCar c = new Car(\"Tesla\");\nSystem.out.println(c.getModel());\n```",
                "model", "null", "Tesla", "Error",
                "C", 3, 2005));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Thing {\n    public static int x = 5;\n    public int y = 10;\n}\n\nThing a = new Thing();\nThing b = new Thing();\na.x = 20;\nSystem.out.print(b.x);\n```",
                "5", "10", "20", "Error",
                "C", 3, 2006));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class MathStuff {\n    public int square(int x) {\n        return x * x;\n    }\n    public void printSquare(int x) {\n        System.out.print(square(x));\n    }\n}\n\nMathStuff m = new MathStuff();\nm.printSquare(4);\n```",
                "8", "16", "4", "Error",
                "B", 3, 2007));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Message {\n    private String msg;\n    public Message(String m) {\n        msg = m;\n    }\n    public String shout() {\n        return msg.toUpperCase();\n    }\n}\n\nMessage m = new Message(\"hello\");\nSystem.out.println(m.shout());\n```",
                "hello", "HELLO", "msg", "Error",
                "B", 3, 2008));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Counter {\n    public int value = 0;\n}\n\nCounter a = new Counter();\nCounter b = a;\nb.value++;\nSystem.out.println(a.value);\n```",
                "0", "1", "2", "Error",
                "B", 3, 2009));

        unit3Questions.add(new Question(
                "Which keyword is used to refer to the current object?",
                "that", "this", "self", "super",
                "B", 3, 2010));

        unit3Questions.add(new Question(
                "What is the output?\n```java\npublic class Person {\n    private String name;\n    public Person(String n) {\n        name = n;\n    }\n    public void rename(String newName) {\n        name = newName;\n    }\n    public String getName() {\n        return name;\n    }\n}\n\nPerson p = new Person(\"Amy\");\np.rename(\"Bob\");\nSystem.out.println(p.getName());\n```",
                "Amy", "Bob", "null", "Error",
                "B", 3, 2011));

        unit3Questions.add(new Question(
                "What is the default value of an uninitialized instance variable of type int?",
                "null", "0", "undefined", "Error",
                "B", 3, 2012));

        unit3Questions.add(new Question(
                "Which method is used to provide the current state of an object to outside classes?",
                "Mutator", "Constructor", "Accessor", "Instantiator",
                "C", 3, 2013));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Example {\n    public Example() {\n        System.out.print(\"Default\");\n    }\n}\n\nExample e = new Example();\n```",
                "null", "Error", "Default", "example",
                "C", 3, 2014));

        unit3Questions.add(new Question(
                "Which of the following is true about constructors?",
                "They return a value", "They must be private", "They have the same name as the class", "They can be static",
                "C", 3, 2015));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class A {\n    private static int count = 0;\n    public A() {\n        count++;\n    }\n    public static int getCount() {\n        return count;\n    }\n}\n\nA a1 = new A();\nA a2 = new A();\nSystem.out.print(A.getCount());\n```",
                "1", "2", "0", "Error",
                "B", 3, 2016));

        unit3Questions.add(new Question(
                "What is encapsulation?",
                "Hiding data using private fields and public methods", "Inheriting properties", "Using arrays to store data", "Compiling multiple classes together",
                "A", 3, 2017));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Alpha {\n    public int x = 10;\n}\n\nAlpha a1 = new Alpha();\na1.x = 20;\nSystem.out.println(new Alpha().x);\n```",
                "10", "20", "0", "Error",
                "A", 3, 2018));

        unit3Questions.add(new Question(
                "What is the purpose of private instance variables?",
                "They can't be used", "To enforce encapsulation", "They're faster", "They are static",
                "B", 3, 2019));

// Continue questions 2020–2029 similarly...

        unit3Questions.add(new Question(
                "Which of the following best describes a mutator method?",
                "Returns a value", "Changes field values", "Constructs a new object", "Accesses a constant",
                "B", 3, 2020));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Example {\n    private int num;\n    public Example() {\n        num = 42;\n    }\n    public int getNum() {\n        return num;\n    }\n}\n\nExample e = new Example();\nSystem.out.println(e.getNum());\n```",
                "0", "42", "Error", "null",
                "B", 3, 2021));

        unit3Questions.add(new Question(
                "Which of the following can access private fields directly?",
                "Only methods in the same class", "All classes", "Constructors only", "Static methods only",
                "A", 3, 2022));

        unit3Questions.add(new Question(
                "What does this code do?\n```java\npublic class Cat {\n    private String name;\n    public Cat(String name) {\n        this.name = name;\n    }\n}\n```",
                "Creates a static field", "Assigns a parameter to a field", "Causes an error", "Creates multiple constructors",
                "B", 3, 2023));

        unit3Questions.add(new Question(
                "How many constructors can a class have?",
                "Only one", "One per field", "As many as needed", "Only if static",
                "C", 3, 2024));

        numUnit3Questions = unit3Questions.size();
        System.out.printf("There are %d questions in unit 2%n", numUnit3Questions);
    }

}
