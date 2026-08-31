import java.util.Scanner;

public class VowelConsonantCharacterType {

    public static String checkVowelOrConsonant(char ch) {
        char lower = ch;
        if (ch >= 'A' && ch <= 'Z') {
            lower = (char) (ch + 32);
        }
        if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
            return "Vowel";
        } else if (lower >= 'a' && lower <= 'z') {
            return "Consonant";
        } else {
            return "Not a Letter";
        }
    }

    public static String[][] findVowelsAndConsonants(String text) {
        String[][] result = new String[text.length()][2];
        for (int i = 0; i < text.length(); i++) {
            result[i][0] = String.valueOf(text.charAt(i));
            result[i][1] = checkVowelOrConsonant(text.charAt(i));
        }
        return result;
    }

    public static void displayTable(String[][] data) {
        System.out.println("Character\tType");
        for (String[] row : data) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        String[][] characterTypes = findVowelsAndConsonants(text);
        displayTable(characterTypes);

        scanner.close();
    }
}
