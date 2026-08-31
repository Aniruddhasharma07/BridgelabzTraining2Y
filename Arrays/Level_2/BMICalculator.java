import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numberOfPersons = input.nextInt();

        double[] weights = new double[numberOfPersons];
        double[] heights = new double[numberOfPersons];
        double[] bmiValues = new double[numberOfPersons];
        String[] weightStatuses = new String[numberOfPersons];

        for (int i = 0; i < weights.length; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            weights[i] = input.nextDouble();

            System.out.print("Enter height (m) for person " + (i + 1) + ": ");
            heights[i] = input.nextDouble();

            if (weights[i] <= 0 || heights[i] <= 0) {
                System.out.println("Invalid input. Please enter positive values again.");
                i--;
            }
        }

        for (int i = 0; i < weights.length; i++) {
            bmiValues[i] = weights[i] / (heights[i] * heights[i]);

            if (bmiValues[i] <= 18.4) {
                weightStatuses[i] = "Underweight";
            } else if (bmiValues[i] <= 24.9) {
                weightStatuses[i] = "Normal";
            } else if (bmiValues[i] <= 39.9) {
                weightStatuses[i] = "Overweight";
            } else {
                weightStatuses[i] = "Obese";
            }
        }

        System.out.println("\nPerson\tHeight(m)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < weights.length; i++) {
            System.out.println((i + 1) + "\t" + heights[i] + "\t\t" + weights[i]
                    + "\t\t" + String.format("%.2f", bmiValues[i]) + "\t" + weightStatuses[i]);
        }

        input.close();
    }
}

