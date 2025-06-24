import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;
    private float percentage;
    private char grade;

    // Constructor
    public Student(String name) {
        this.name = name;
        this.marks = new int[5]; // 5 subjects
    }

    // Method to input marks
    public void inputMarks(Scanner sc) {
        System.out.println("Enter marks for " + name + ":");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    // Method to calculate percentage and grade
    public void calculateResult() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }

        percentage = (float) total / 5;

        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 75) {
            grade = 'B';
        } else if (percentage >= 60) {
            grade = 'C';
        } else if (percentage >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    // Method to display results
    public void displayResult() {
        System.out.println("\n--- Result ---");
        System.out.println("Name       : " + name);
        System.out.printf("Percentage : %.2f%%\n", percentage);
        System.out.println("Grade      : " + grade);
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // try-with-resources to handle scanner closing automatically
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter student name: ");
            String studentName = sc.nextLine();

            Student student = new Student(studentName);
            student.inputMarks(sc);
            student.calculateResult();
            student.displayResult();
        }
    }
}
