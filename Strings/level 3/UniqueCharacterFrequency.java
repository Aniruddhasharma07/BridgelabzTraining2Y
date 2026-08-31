import java.util.Scanner;

public class UniqueCharacterFrequency {

    public static char[] uniqueCharacters(String str) {

        char[] temp = new char[str.length()];
        int uniqueCount = 0;

        for (int i = 0; i < str.length(); i++) {

            char current = str.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (current == str.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static String[][] findFrequency(String str) {

        int[] frequency = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            frequency[ch]++;
        }

        char[] uniqueChars = uniqueCharacters(str);

        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }

        return result;
    }

    // Method 3: Display result
    public static void displayResult(String[][] data) {

        System.out.println("\nCharacter\tFrequency");
        System.out.println("----------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = findFrequency(input);

        displayResult(result);

        sc.close();
    }
}