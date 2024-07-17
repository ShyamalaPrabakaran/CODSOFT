import java.util.*;
public class TaskGrade {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Get number of subjects
        System.out.println("Enter the number of subjects: ");
        int num = s.nextInt();

        // Initialize variables
        int total = 0;

        // Loop to get marks for each subject
        for (int i = 1; i <= num; i++) {
            System.out.println("Enter marks for subject " + i + ": ");
            int marks = s.nextInt();

            // Validate marks (0 to 100)
            while (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter a value between 0 and 100: ");
                marks = s.nextInt();
            }

            total += marks;
        }

        // Calculate average percentage
        double average = (double) total / num;

        // Calculate grade
        String grade;
        if (average >= 90) {
            grade = "A";
        } else if (average >= 80) {
            grade = "B";
        } else if (average >= 70) {
            grade = "C";
        } else if (average >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);

        s.close();
    }
}
