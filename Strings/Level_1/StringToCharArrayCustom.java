import java.util.Scanner;

public class StringToCharArrayCustom {

    public static char[] getCharacters(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();

        char[] customChars = getCharacters(text);
        char[] builtInChars = text.toCharArray();

        boolean isSame = compareCharArrays(customChars, builtInChars);

        System.out.print("Custom method characters: ");
        for (char c : customChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.print("toCharArray() characters: ");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("Both arrays match: " + isSame);

        scanner.close();
    }
}
