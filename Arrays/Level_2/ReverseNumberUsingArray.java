import java.util.Scanner;

public class ReverseNumberUsingArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number < 0) {
            System.err.println("Invalid Number.");
            System.exit(0);
        }

        int count = 0;
        int temp = number;
        while (temp > 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        for (int i = 0; i < count; i++) {
            digits[i] = number % 10;
            number /= 10;
        }

        int[] reversedDigits = new int[count];
        for (int i = 0; i < digits.length; i++) {
            reversedDigits[i] = digits[digits.length - 1 - i];
        }

        System.out.print("Reversed Number: ");
        for (int i = 0; i < reversedDigits.length; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();

        input.close();
    }
}

