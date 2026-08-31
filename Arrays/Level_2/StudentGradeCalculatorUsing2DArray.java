import java.util.Scanner;

public class StudentGradeCalculatorUsing2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        final int NUMBER_OF_SUBJECTS = 3;
        final int PHYSICS_COLUMN = 0;
        final int CHEMISTRY_COLUMN = 1;
        final int MATHS_COLUMN = 2;

        double[][] marks = new double[numberOfStudents][NUMBER_OF_SUBJECTS];

        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];

        final double MAX_MARKS_PER_SUBJECT = 100.0;

        for (int i = 0; i < marks.length; i++) {
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

            marks[i][PHYSICS_COLUMN] = physics;
            marks[i][CHEMISTRY_COLUMN] = chemistry;
            marks[i][MATHS_COLUMN] = maths;
        }

        for (int i = 0; i < marks.length; i++) {
            double totalMarks = 0.0;
            for (int j = 0; j < marks[i].length; j++) {
                totalMarks += marks[i][j];
            }

            percentages[i] = (totalMarks / (MAX_MARKS_PER_SUBJECT * NUMBER_OF_SUBJECTS)) * 100;

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
        for (int i = 0; i < marks.length; i++) {
            System.out.println((i + 1) + "\t" + marks[i][PHYSICS_COLUMN] + "\t"
                    + marks[i][CHEMISTRY_COLUMN] + "\t\t" + marks[i][MATHS_COLUMN] + "\t"
                    + String.format("%.2f", percentages[i]) + "\t\t" + grades[i]);
        }

        input.close();
    }
}

