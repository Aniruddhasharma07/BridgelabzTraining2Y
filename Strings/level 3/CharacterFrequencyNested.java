import java.util.Scanner;

public class CharacterFrequencyNested {

    public static String[] findFrequency(String str) {

        char[] chars = str.toCharArray();      // Store characters
        int[] frequency = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '0') {
                continue;   // Skip already counted characters
            }

            frequency[i] = 1;

            for (int j = i + 1; j < chars.length; j++) {

                if (chars[i] == chars[j]) {
                    frequency[i]++;
                    chars[j] = '0';  // Mark duplicate as '0'
                }
            }
        }

        int uniqueCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }

        String[] result = new String[uniqueCount];

        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '0') {
                result[index] = chars[i] + " = " + frequency[i];
                index++;
            }
        }

        return result;
    }

    public static void displayResult(String[] data) {

        System.out.println("\nCharacter Frequencies:");
        System.out.println("----------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[] result = findFrequency(input);

        displayResult(result);

        sc.close();
    }
}