import java.util.Scanner;

public class StringLengthWithoutLengthMethod {

    public static int findLengthUsingCharAt(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.next();

        int customLength = findLengthUsingCharAt(text);
        int builtInLength = text.length();

        System.out.println("Length using charAt(): " + customLength);
        System.out.println("Length using length(): " + builtInLength);
        System.out.println("Both lengths match: " + (customLength == builtInLength));

        scanner.close();
    }
}
