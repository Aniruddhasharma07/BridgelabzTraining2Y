import java.util.Scanner;

public class VowelConsonantCount {

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

    public static int[] countVowelsAndConsonants(String text) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < text.length(); i++) {
            String type = checkVowelOrConsonant(text.charAt(i));
            if (type.equals("Vowel")) {
                vowelCount++;
            } else if (type.equals("Consonant")) {
                consonantCount++;
            }
        }
        return new int[]{vowelCount, consonantCount};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        int[] counts = countVowelsAndConsonants(text);

        System.out.println("Number of Vowels: " + counts[0]);
        System.out.println("Number of Consonants: " + counts[1]);

        scanner.close();
    }
}
