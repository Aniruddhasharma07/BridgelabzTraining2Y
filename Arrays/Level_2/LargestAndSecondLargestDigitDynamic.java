import java.util.Scanner;

public class LargestAndSecondLargestDigitDynamic {
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
            if (index == maxDigit) {
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
            }

            digits[index] = number % 10;
            number /= 10;
            index++;
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

