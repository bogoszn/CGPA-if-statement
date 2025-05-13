import java.util.Scanner;

public class CGPACalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of courses: ");
        int numberOfCourses = input.nextInt();

        double totalGradePoints = 0;
        int totalUnits = 0;

        for (int i = 1; i <= numberOfCourses; i++) {
            input.nextLine(); // Clear newline
            System.out.print("\nEnter course code for course " + i + ": ");
            String courseCode = input.nextLine();

            System.out.print("Enter unit load for " + courseCode + ": ");
            int unit = input.nextInt();

            input.nextLine(); // Clear newline
            System.out.print("Enter grade for " + courseCode + " (A-F): ");
            String grade = input.nextLine().toUpperCase();

            int gradePoint = getGradePoint(grade);

            if (gradePoint == -1) {
                System.out.println("Invalid grade entered. Please use A, B, C, D, E or F.");
                i--; // Repeat the course input
                continue;
            }

            totalGradePoints += gradePoint * unit;
            totalUnits += unit;
        }

        if (totalUnits == 0) {
            System.out.println("No course units entered. CGPA cannot be calculated.");
        } else {
            double cgpa = totalGradePoints / totalUnits;
            System.out.printf("\nYour CGPA is: %.2f\n", cgpa);

            // Classification
            if (cgpa >= 4.5) {
                System.out.println("Class: First Class");
            } else if (cgpa >= 3.5) {
                System.out.println("Class: Second Class Upper");
            } else if (cgpa >= 2.5) {
                System.out.println("Class: Second Class Lower");
            } else if (cgpa >= 1.5) {
                System.out.println("Class: Third Class");
            } else {
                System.out.println("Class: Fail");
            }
        }

        input.close();
    }

    // Converts letter grade to grade point
    public static int getGradePoint(String grade) {
        switch (grade) {
            case "A": return 5;
            case "B": return 4;
            case "C": return 3;
            case "D": return 2;
            case "E": return 1;
            case "F": return 0;
            default: return -1;
        }
    }
}
