import java.util.Scanner;

public class StringIndexOutOfBoundsExceptionDemo {

    public static void generateException(String text) {
        System.out.println(text.charAt(text.length() + 5));
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length() + 5));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.next();

        handleException(text);

        scanner.close();
    }
}
