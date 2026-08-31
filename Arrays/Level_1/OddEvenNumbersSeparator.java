import java.util.Scanner;

public class OddEvenNumbersSeparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Error: Please enter a natural number.");
            scanner.close();
            return;
        }

        int[] evenNumbers = new int[number / 2 + 1];
        int[] oddNumbers = new int[number / 2 + 1];
        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        System.out.println("Odd numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.println(oddNumbers[i]);
        }

        System.out.println("Even numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.println(evenNumbers[i]);
        }

        scanner.close();
    }
}
