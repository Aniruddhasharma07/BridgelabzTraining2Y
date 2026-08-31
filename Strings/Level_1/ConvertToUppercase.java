import java.util.Scanner;

public class ConvertToUppercase {

    public static String toUpperCaseUsingCharAt(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            result.append(ch);
        }
        return result.toString();
    }

    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String customUpper = toUpperCaseUsingCharAt(text);
        String builtInUpper = text.toUpperCase();

        boolean isSame = compareUsingCharAt(customUpper, builtInUpper);

        System.out.println("Custom uppercase: " + customUpper);
        System.out.println("toUpperCase(): " + builtInUpper);
        System.out.println("Both results match: " + isSame);

        scanner.close();
    }
}
