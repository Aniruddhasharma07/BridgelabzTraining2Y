import java.util.Scanner;

public class BMICalculatorUsing2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of persons: ");
        int numberOfPersons = input.nextInt();

        final int WEIGHT_COLUMN = 0;
        final int HEIGHT_COLUMN = 1;
        final int BMI_COLUMN = 2;

        double[][] personData = new double[numberOfPersons][3];

        String[] weightStatus = new String[numberOfPersons];

        for (int i = 0; i < personData.length; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            double weight = input.nextDouble();

            System.out.print("Enter height (m) for person " + (i + 1) + ": ");
            double height = input.nextDouble();

            if (weight <= 0 || height <= 0) {
                System.out.println("Invalid input. Please enter positive values again.");
                i--;
                continue;
            }

            personData[i][WEIGHT_COLUMN] = weight;
            personData[i][HEIGHT_COLUMN] = height;
        }

        for (int i = 0; i < personData.length; i++) {
            double weight = personData[i][WEIGHT_COLUMN];
            double height = personData[i][HEIGHT_COLUMN];

            double bmi = weight / (height * height);
            personData[i][BMI_COLUMN] = bmi;

            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nPerson\tHeight(m)\tWeight(kg)\tBMI\tStatus");
        for (int i = 0; i < personData.length; i++) {
            System.out.println((i + 1) + "\t" + personData[i][HEIGHT_COLUMN] + "\t\t"
                    + personData[i][WEIGHT_COLUMN] + "\t\t"
                    + String.format("%.2f", personData[i][BMI_COLUMN]) + "\t" + weightStatus[i]);
        }

        input.close();
    }
}

