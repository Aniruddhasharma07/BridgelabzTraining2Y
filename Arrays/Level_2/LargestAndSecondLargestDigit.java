import java.util.Scanner;

public class LargestAndSecondLargestDigit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number < 0) {
            System.err.println("Invalid Number.");
            System.exit(0);
        }

        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        int index = 0;

        while (number != 0) {
            digits[index] = number % 10;
            number /= 10;
            index++;

            if (index == maxDigit) {
                break;
            }
        }

        int largestDigit = 0;
        int secondLargestDigit = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largestDigit) {
                secondLargestDigit = largestDigit;
                largestDigit = digits[i];
            } else if (digits[i] > secondLargestDigit && digits[i] != largestDigit) {
                secondLargestDigit = digits[i];
            }
        }

        System.out.println("Largest Digit: " + largestDigit);
        System.out.println("Second Largest Digit: " + secondLargestDigit);

        input.close();
    }
}

