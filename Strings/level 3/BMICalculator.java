import java.util.Scanner;

public class BMICalculator {

    public static String[] calculateBMI(double weight, double heightCm) {

        double heightMeter = heightCm / 100.0;
        double bmi = weight / (heightMeter * heightMeter);

        bmi = Math.round(bmi * 100.0) / 100.0;

        String status;

        if (bmi < 18.5)
            status = "Underweight";
        else if (bmi < 25)
            status = "Normal";
        else if (bmi < 30)
            status = "Overweight";
        else
            status = "Obese";

        return new String[]{String.valueOf(bmi), status};
    }

    // Method to process all persons
    public static String[][] processBMI(double[][] data) {

        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double height = data[i][1];

            String[] bmiData = calculateBMI(weight, height);

            result[i][0] = String.valueOf(height);   // Height
            result[i][1] = String.valueOf(weight);   // Weight
            result[i][2] = bmiData[0];               // BMI
            result[i][3] = bmiData[1];               // Status
        }

        return result;
    }

    // Method to display in tabular format
    public static void displayResult(String[][] data) {

        System.out.println("\n------------------------------------------------------------");
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\tStatus");
        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println((i + 1) + "\t" +
                    data[i][0] + "\t\t" +
                    data[i][1] + "\t\t" +
                    data[i][2] + "\t" +
                    data[i][3]);
        }

        System.out.println("------------------------------------------------------------");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] persons = new double[10][2]; // [weight][height]

        // Taking input
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));
            System.out.print("Weight (kg): ");
            persons[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            persons[i][1] = sc.nextDouble();
        }

        String[][] result = processBMI(persons);

        displayResult(result);

        sc.close();
    }
}