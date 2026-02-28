package Student_Management_System;

public class Student {
    private static int counter = 1000;

    private String registerNumber;
    private String name;
    private int marks;

    public Student(String name, int marks) {
        counter++;
        this.registerNumber = "SCI" + counter;
        this.name = name;
        this.marks = marks;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return registerNumber + " | " + name + " | " + marks;
    }
}