import java.util.Scanner;

public class StudentGradeCalculator {

    public static int[][] generateScores(int numberOfStudents) {
        int[][] scores = new int[numberOfStudents][3];
        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10;
            scores[i][1] = (int) (Math.random() * 90) + 10;
            scores[i][2] = (int) (Math.random() * 90) + 10;
        }
        return scores;
    }

    public static double[][] calculateTotalAveragePercentage(int[][] scores) {
        double[][] result = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }

    public static String[] calculateGrade(double[][] totalAveragePercentage) {
        String[] grades = new String[totalAveragePercentage.length];
        for (int i = 0; i < totalAveragePercentage.length; i++) {
            double percentage = totalAveragePercentage[i][2];
            if (percentage >= 80) {
                grades[i] = "A";
            } else if (percentage >= 70) {
                grades[i] = "B";
            } else if (percentage >= 60) {
                grades[i] = "C";
            } else if (percentage >= 50) {
                grades[i] = "D";
            } else if (percentage >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] totalAveragePercentage, String[] grades) {
        System.out.println("Physics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2] + "\t"
                    + totalAveragePercentage[i][0] + "\t" + totalAveragePercentage[i][1] + "\t"
                    + totalAveragePercentage[i][2] + "\t\t" + grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[][] scores = generateScores(numberOfStudents);
        double[][] totalAveragePercentage = calculateTotalAveragePercentage(scores);
        String[] grades = calculateGrade(totalAveragePercentage);

        displayScorecard(scores, totalAveragePercentage, grades);

        scanner.close();
    }
}
