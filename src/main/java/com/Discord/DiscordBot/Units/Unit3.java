package com.Discord.DiscordBot.Units;

import static com.Discord.DiscordBot.Units.QuestionBank.unit3Questions;

public class Unit3 {

    public static int numUnit3Questions;

    public static void initializeUnit3Questions() {

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Dog {\n    private String name;\n    public Dog(String n) {\n        name = n;\n    }\n    public void bark() {\n        System.out.println(name + \" says woof\");\n    }\n}\n\nDog d = new Dog(\"Max\");\nd.bark();\n```",
                "says woof", "Max says woof", "null says woof", "Dog says woof",
                "B", 3, 2000, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Student {\n    private int grade;\n    public Student(int g) {\n        grade = g;\n    }\n    public int getGrade() {\n        return grade;\n    }\n}\n\nStudent s = new Student(90);\nSystem.out.println(s.getGrade());\n```",
                "0", "null", "90", "Error",
                "C", 3, 2001, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Counter {\n    private int count = 0;\n    public void increment() {\n        count++;\n    }\n    public int getCount() {\n        return count;\n    }\n}\n\nCounter c = new Counter();\nc.increment();\nc.increment();\nSystem.out.println(c.getCount());\n```",
                "0", "1", "2", "Error",
                "C", 3, 2002, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Box {\n    private int size;\n    public Box(int s) {\n        size = s;\n    }\n    public void printSize() {\n        System.out.print(size);\n    }\n}\n\nBox b1 = new Box(3);\nBox b2 = new Box(7);\nb1.printSize();\nb2.printSize();\n```",
                "37", "73", "3 7", "Error",
                "A", 3, 2003, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Book {\n    private String title;\n    public Book() {\n        title = \"Unknown\";\n    }\n    public void printTitle() {\n        System.out.println(title);\n    }\n}\n\nBook b = new Book();\nb.printTitle();\n```",
                "null", "title", "Unknown", "Error",
                "C", 3, 2004, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Car {\n    private String model;\n    public Car(String model) {\n        this.model = model;\n    }\n    public String getModel() {\n        return model;\n    }\n}\n\nCar c = new Car(\"Tesla\");\nSystem.out.println(c.getModel());\n```",
                "model", "null", "Tesla", "Error",
                "C", 3, 2005, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Thing {\n    public static int x = 5;\n    public int y = 10;\n}\n\nThing a = new Thing();\nThing b = new Thing();\na.x = 20;\nSystem.out.print(b.x);\n```",
                "5", "10", "20", "Error",
                "C", 3, 2006, "medium"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class MathStuff {\n    public int square(int x) {\n        return x * x;\n    }\n    public void printSquare(int x) {\n        System.out.print(square(x));\n    }\n}\n\nMathStuff m = new MathStuff();\nm.printSquare(4);\n```",
                "8", "16", "4", "Error",
                "B", 3, 2007, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Message {\n    private String msg;\n    public Message(String m) {\n        msg = m;\n    }\n    public String shout() {\n        return msg.toUpperCase();\n    }\n}\n\nMessage m = new Message(\"hello\");\nSystem.out.println(m.shout());\n```",
                "hello", "HELLO", "msg", "Error",
                "B", 3, 2008, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Counter {\n    public int value = 0;\n}\n\nCounter a = new Counter();\nCounter b = a;\nb.value++;\nSystem.out.println(a.value);\n```",
                "0", "1", "2", "Error",
                "B", 3, 2009, "hard"));

        unit3Questions.add(new Question(
                "Which keyword is used to refer to the current object?",
                "that", "this", "self", "super",
                "B", 3, 2010, "easy"));

        unit3Questions.add(new Question(
                "What is the output?\n```java\npublic class Person {\n    private String name;\n    public Person(String n) {\n        name = n;\n    }\n    public void rename(String newName) {\n        name = newName;\n    }\n    public String getName() {\n        return name;\n    }\n}\n\nPerson p = new Person(\"Amy\");\np.rename(\"Bob\");\nSystem.out.println(p.getName());\n```",
                "Amy", "Bob", "null", "Error",
                "B", 3, 2011, "easy"));

        unit3Questions.add(new Question(
                "What is the default value of an uninitialized instance variable of type int?",
                "null", "0", "undefined", "Error",
                "B", 3, 2012, "easy"));

        unit3Questions.add(new Question(
                "Which method is used to provide the current state of an object to outside classes?",
                "Mutator", "Constructor", "Accessor", "Instantiator",
                "C", 3, 2013, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Example {\n    public Example() {\n        System.out.print(\"Default\");\n    }\n}\n\nExample e = new Example();\n```",
                "null", "Error", "Default", "example",
                "C", 3, 2014, "easy"));

        unit3Questions.add(new Question(
                "Which of the following is true about constructors?",
                "They return a value", "They must be private", "They have the same name as the class", "They can be static",
                "C", 3, 2015, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class A {\n    private static int count = 0;\n    public A() {\n        count++;\n    }\n    public static int getCount() {\n        return count;\n    }\n}\n\nA a1 = new A();\nA a2 = new A();\nSystem.out.print(A.getCount());\n```",
                "1", "2", "0", "Error",
                "B", 3, 2016, "medium"));

        unit3Questions.add(new Question(
                "What is encapsulation?",
                "Hiding data using private fields and public methods", "Inheriting properties", "Using arrays to store data", "Compiling multiple classes together",
                "A", 3, 2017, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Alpha {\n    public int x = 10;\n}\n\nAlpha a1 = new Alpha();\na1.x = 20;\nSystem.out.println(new Alpha().x);\n```",
                "10", "20", "0", "Error",
                "A", 3, 2018, "medium"));

        unit3Questions.add(new Question(
                "What is the purpose of private instance variables?",
                "They can't be used", "To enforce encapsulation", "They're faster", "They are static",
                "B", 3, 2019, "easy"));

// Continue questions 2020–2029 similarly...

        unit3Questions.add(new Question(
                "Which of the following best describes a mutator method?",
                "Returns a value", "Changes field values", "Constructs a new object", "Accesses a constant",
                "B", 3, 2020, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Example {\n    private int num;\n    public Example() {\n        num = 42;\n    }\n    public int getNum() {\n        return num;\n    }\n}\n\nExample e = new Example();\nSystem.out.println(e.getNum());\n```",
                "0", "42", "Error", "null",
                "B", 3, 2021, "easy"));

        unit3Questions.add(new Question(
                "Which of the following can access private fields directly?",
                "Only methods in the same class", "All classes", "Constructors only", "Static methods only",
                "A", 3, 2022, "easy"));

        unit3Questions.add(new Question(
                "What does this code do?\n```java\npublic class Cat {\n    private String name;\n    public Cat(String name) {\n        this.name = name;\n    }\n}\n```",
                "Creates a static field", "Assigns a parameter to a field", "Causes an error", "Creates multiple constructors",
                "B", 3, 2023, "easy"));

        unit3Questions.add(new Question(
                "How many constructors can a class have?",
                "Only one", "One per field", "As many as needed", "Only if static",
                "C", 3, 2024, "easy"));
        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Circle {\n    private double radius;\n    public Circle(double r) {\n        radius = r;\n    }\n    public double getArea() {\n        return Math.PI * radius * radius;\n    }\n}\n\nCircle c = new Circle(2.0);\nSystem.out.println(c.getArea());\n```",
                "3.141592653589793", "12.566370614359172", "6.283185307179586", "Error",
                "B", 3, 2030, "medium"));

        unit3Questions.add(new Question(
                "Which of the following correctly declares a private String field and public accessor method?",
                "```java\nprivate String name;\npublic String getName() { return name; }\n```",
                "```java\npublic String name;\nprivate String getName() { return name; }\n```",
                "```java\nprivate String name;\nprivate String getName() { return name; }\n```",
                "```java\npublic String name;\npublic String getName() { return name; }\n```",
                "A", 3, 2031, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Test {\n    private int value;\n    public Test(int v) {\n        value = v + 5;\n    }\n    public int getValue() {\n        return value;\n    }\n}\n\nTest t = new Test(10);\nSystem.out.println(t.getValue());\n```",
                "10", "15", "5", "0",
                "B", 3, 2032, "easy"));

        unit3Questions.add(new Question(
                "Which of these is NOT a proper class declaration?",
                "```java\npublic class MyClass {}\n```",
                "```java\nclass MyClass {}\n```",
                "```java\nprivate class MyClass {}\n```",
                "```java\npublic final class MyClass {}\n```",
                "C", 3, 2033, "hard"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class BankAccount {\n    private double balance;\n    public BankAccount() {\n        balance = 100.0;\n    }\n    public void deposit(double amount) {\n        balance += amount;\n    }\n    public double getBalance() {\n        return balance;\n    }\n}\n\nBankAccount b = new BankAccount();\nb.deposit(50.0);\nSystem.out.println(b.getBalance());\n```",
                "0.0", "50.0", "100.0", "150.0",
                "D", 3, 2034, "easy"));

        unit3Questions.add(new Question(
                "Which keyword allows a parameter name to match an instance variable name?",
                "static", "this", "super", "final",
                "B", 3, 2035, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Rectangle {\n    private int width, height;\n    public Rectangle(int w, int h) {\n        width = w;\n        height = h;\n    }\n    public int getPerimeter() {\n        return 2 * (width + height);\n    }\n}\n\nRectangle r = new Rectangle(3, 4);\nSystem.out.println(r.getPerimeter());\n```",
                "12", "14", "24", "7",
                "B", 3, 2036, "easy"));

        unit3Questions.add(new Question(
                "Which of the following is true about instance variables?",
                "They must be declared static", "They are shared among all objects of a class",
                "Each object has its own copy", "They can only be primitive types",
                "C", 3, 2037, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Mystery {\n    private String s;\n    public Mystery() {\n        s = \"Hello\";\n    }\n    public void change(String s) {\n        this.s = s;\n    }\n    public String getS() {\n        return s;\n    }\n}\n\nMystery m = new Mystery();\nm.change(\"World\");\nSystem.out.println(m.getS());\n```",
                "Hello", "World", "null", "Error",
                "B", 3, 2038, "medium"));

        unit3Questions.add(new Question(
                "Which of these correctly creates an object of class Car with parameter \"Sedan\"?",
                "```java\nCar c = Car(\"Sedan\");\n```",
                "```java\nCar c = new Car(\"Sedan\");\n```",
                "```java\nCar c = new Car();\n```",
                "```java\nCar c = Car.new(\"Sedan\");\n```",
                "B", 3, 2039, "easy"));
        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Temperature {\n    private double celsius;\n    public Temperature(double c) {\n        celsius = c;\n    }\n    public double getFahrenheit() {\n        return celsius * 9/5 + 32;\n    }\n}\n\nTemperature t = new Temperature(25.0);\nSystem.out.println(t.getFahrenheit());\n```",
                "25.0", "77.0", "32.0", "Error",
                "B", 3, 2040, "medium"));

        unit3Questions.add(new Question(
                "Which of these is a proper mutator method for a field 'speed'?",
                "```java\npublic int getSpeed() { return speed; }\n```",
                "```java\npublic void setSpeed(int s) { speed = s; }\n```",
                "```java\npublic int speed() { return this.speed; }\n```",
                "```java\npublic void changeSpeed() { System.out.println(speed); }\n```",
                "B", 3, 2041, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Counter {\n    private int count;\n    public Counter() { count = 0; }\n    public void click() { count++; }\n    public void reset() { count = 0; }\n    public int getValue() { return count; }\n}\n\nCounter c = new Counter();\nc.click();\nc.click();\nc.reset();\nSystem.out.println(c.getValue());\n```",
                "0", "1", "2", "3",
                "A", 3, 2042, "medium"));

        unit3Questions.add(new Question(
                "What is wrong with this class definition?\n```java\npublic class Student {\n    private String name;\n    public Student(String n) {\n        name = n;\n    }\n    public String getName() {\n        return name;\n    }\n    public void setName(String name) {\n        name = name;\n    }\n}\n```",
                "Missing constructor", "Setter method doesn't work properly", "Getter should be private", "No errors",
                "B", 3, 2043, "medium"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Point {\n    private int x, y;\n    public Point(int x, int y) {\n        this.x = x;\n        this.y = y;\n    }\n    public String toString() {\n        return \"(\" + x + \", \" + y + \")\";\n    }\n}\n\nPoint p = new Point(3, 4);\nSystem.out.println(p);\n```",
                "Point@memoryaddress", "(3, 4)", "3 4", "Error",
                "B", 3, 2044, "hard"));

        unit3Questions.add(new Question(
                "Which of these declares a properly encapsulated class with one field?",
                "```java\npublic class A { public int num; }\n```",
                "```java\npublic class B { private int num; public int getNum() { return num; } }\n```",
                "```java\npublic class C { private int num; private int getNum() { return num; } }\n```",
                "```java\npublic class D { int num; }\n```",
                "B", 3, 2045, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Light {\n    private boolean on;\n    public Light() { on = false; }\n    public void flip() { on = !on; }\n    public boolean isOn() { return on; }\n}\n\nLight l = new Light();\nl.flip();\nl.flip();\nSystem.out.println(l.isOn());\n```",
                "true", "false", "null", "Error",
                "B", 3, 2046, "easy"));

        unit3Questions.add(new Question(
                "Which constructor correctly initializes all fields?\n```java\npublic class Book {\n    private String title;\n    private int pages;\n    // Constructors here\n}\n```",
                "```java\npublic Book() {}\n```",
                "```java\npublic Book(String t) { title = t; }\n```",
                "```java\npublic Book(String t, int p) { title = t; pages = p; }\n```",
                "```java\npublic Book(int p) { pages = p; }\n```",
                "C", 3, 2047, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Adder {\n    private int sum;\n    public Adder() { sum = 0; }\n    public void add(int x) { sum += x; }\n    public int getSum() { return sum; }\n}\n\nAdder a = new Adder();\na.add(5);\na.add(3);\nSystem.out.println(a.getSum());\n```",
                "0", "5", "8", "15",
                "C", 3, 2048, "easy"));

        unit3Questions.add(new Question(
                "Which of these demonstrates proper encapsulation?",
                "```java\npublic class Dog { public String name; }\n```",
                "```java\npublic class Cat { private String name; public String getName() { return name; } }\n```",
                "```java\npublic class Bird { String name; String getName() { return name; } }\n```",
                "```java\npublic class Fish { private String name; private String getName() { return name; } }\n```",
                "B", 3, 2049, "easy"));
        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Fraction {\n    private int numerator, denominator;\n    public Fraction(int n, int d) {\n        numerator = n;\n        denominator = d;\n    }\n    public double getValue() {\n        return (double)numerator / denominator;\n    }\n}\n\nFraction f = new Fraction(3, 4);\nSystem.out.println(f.getValue());\n```",
                "0", "0.75", "1.33", "3/4",
                "B", 3, 2050, "medium"));

        unit3Questions.add(new Question(
                "Which method signature correctly overloads the method:\n`public void process(int x)`?",
                "`public void process(int y)`",
                "`public int process(int x)`",
                "`public void process(double x)`",
                "`private void process(int x)`",
                "C", 3, 2051, "medium"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Wallet {\n    private double balance;\n    public Wallet() { balance = 0; }\n    public void addMoney(double amt) { balance += amt; }\n    public void spendMoney(double amt) { balance -= amt; }\n    public double getBalance() {\n        return balance;\n    }\n}\n\nWallet w = new Wallet();\nw.addMoney(20.0);\nw.spendMoney(15.5);\nSystem.out.println(w.getBalance());\n```",
                "0.0", "4.5", "15.5", "20.0",
                "B", 3, 2052, "easy"));

        unit3Questions.add(new Question(
                "What is wrong with this class definition?\n```java\npublic class Circle {\n    private double radius;\n    public Circle(double r) {\n        radius = r;\n    }\n    public double getArea() {\n        return 3.14 * radius * radius;\n    }\n    public double getRadius() {\n        return radius;\n    }\n}\n```",
                "Missing setter method", "Should use Math.PI instead of 3.14", "Fields should be public", "No errors",
                "B", 3, 2053, "hard"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Pair {\n    private int first, second;\n    public Pair(int a, int b) {\n        first = a;\n        second = b;\n    }\n    public void swap() {\n        int temp = first;\n        first = second;\n        second = temp;\n    }\n    public String toString() {\n        return first + \" \" + second;\n    }\n}\n\nPair p = new Pair(5, 10);\np.swap();\nSystem.out.println(p);\n```",
                "5 10", "10 5", "0 0", "Error",
                "B", 3, 2054, "medium"));

        unit3Questions.add(new Question(
                "Which of these is NOT a benefit of encapsulation?",
                "Prevents unauthorized access to data", "Makes code easier to maintain",
                "Allows direct access to all fields", "Provides control over data validation",
                "C", 3, 2055, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Score {\n    private int value;\n    public Score() { value = 100; }\n    public void deduct(int points) { value -= points; }\n    public void bonus() { value += 50; }\n    public int getValue() { return value; }\n}\n\nScore s = new Score();\ns.deduct(30);\ns.bonus();\nSystem.out.println(s.getValue());\n```",
                "100", "120", "150", "180",
                "B", 3, 2056, "easy"));

        unit3Questions.add(new Question(
                "Which constructor properly initializes all fields?\n```java\npublic class Car {\n    private String make;\n    private int year;\n    // Constructor here\n}\n```",
                "```java\npublic Car() {}\n```",
                "```java\npublic Car(String m) { make = m; }\n```",
                "```java\npublic Car(String m, int y) { make = m; year = y; }\n```",
                "```java\npublic Car(int y) { year = y; }\n```",
                "C", 3, 2057, "easy"));

        unit3Questions.add(new Question(
                "What is printed?\n```java\npublic class Mystery {\n    private static int count = 0;\n    public Mystery() { count++; }\n    public static int getCount() { return count; }\n}\n\nnew Mystery();\nnew Mystery();\nSystem.out.println(Mystery.getCount());\n```",
                "0", "1", "2", "Error",
                "C", 3, 2058, "medium"));

        unit3Questions.add(new Question(
                "Which of these demonstrates proper method overloading?",
                "```java\npublic int calculate(int x)\npublic double calculate(int x)\n```",
                "```java\npublic void draw(String shape)\npublic void draw(int size)\n```",
                "```java\nprivate String getName()\npublic String getName()\n```",
                "```java\npublic void move()\npublic static void move()\n```",
                "B", 3, 2059, "medium"));

        numUnit3Questions = unit3Questions.size();
        System.out.printf("There are %d questions in unit 3%n", numUnit3Questions);
    }

}
