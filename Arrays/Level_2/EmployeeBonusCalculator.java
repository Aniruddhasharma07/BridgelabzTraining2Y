import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int NUMBER_OF_EMPLOYEES = 10;

        final double HIGH_BONUS_PERCENTAGE = 0.05;
        final double LOW_BONUS_PERCENTAGE = 0.02;
        final int YEARS_OF_SERVICE_THRESHOLD = 5;

        double[] salaries = new double[NUMBER_OF_EMPLOYEES];
        double[] yearsOfService = new double[NUMBER_OF_EMPLOYEES];

        double[] bonusAmounts = new double[NUMBER_OF_EMPLOYEES];
        double[] newSalaries = new double[NUMBER_OF_EMPLOYEES];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        for (int i = 0; i < salaries.length; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double salary = input.nextDouble();

            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            double serviceYears = input.nextDouble();

            if (salary < 0 || serviceYears < 0) {
                System.out.println("Invalid input. Please enter valid values again.");
                i--;
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = serviceYears;
        }

        for (int i = 0; i < salaries.length; i++) {
            double bonusPercentage;

            if (yearsOfService[i] > YEARS_OF_SERVICE_THRESHOLD) {
                bonusPercentage = HIGH_BONUS_PERCENTAGE;
            } else {
                bonusPercentage = LOW_BONUS_PERCENTAGE;
            }

            bonusAmounts[i] = salaries[i] * bonusPercentage;
            newSalaries[i] = salaries[i] + bonusAmounts[i];

            totalBonus += bonusAmounts[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("\nTotal Bonus Payout: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);

        input.close();
    }
}

