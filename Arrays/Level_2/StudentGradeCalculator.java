import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        double[] physicsMarks = new double[numberOfStudents];
        double[] chemistryMarks = new double[numberOfStudents];
        double[] mathsMarks = new double[numberOfStudents];

        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];

        final double MAX_MARKS_PER_SUBJECT = 100.0;

        for (int i = 0; i < physicsMarks.length; i++) {
            System.out.print("Enter physics marks for student " + (i + 1) + ": ");
            double physics = input.nextDouble();

            System.out.print("Enter chemistry marks for student " + (i + 1) + ": ");
            double chemistry = input.nextDouble();

            System.out.print("Enter maths marks for student " + (i + 1) + ": ");
            double maths = input.nextDouble();

            if (physics < 0 || chemistry < 0 || maths < 0) {
                System.out.println("Invalid input. Please enter positive values again.");
                i--;
                continue;
            }

            physicsMarks[i] = physics;
            chemistryMarks[i] = chemistry;
            mathsMarks[i] = maths;
        }

        for (int i = 0; i < physicsMarks.length; i++) {
            double totalMarks = physicsMarks[i] + chemistryMarks[i] + mathsMarks[i];
            percentages[i] = (totalMarks / (MAX_MARKS_PER_SUBJECT * 3)) * 100;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < physicsMarks.length; i++) {
            System.out.println((i + 1) + "\t" + physicsMarks[i] + "\t" + chemistryMarks[i]
                    + "\t\t" + mathsMarks[i] + "\t" + String.format("%.2f", percentages[i])
                    + "\t\t" + grades[i]);
        }

        input.close();
    }
}

