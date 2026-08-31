import java.util.Scanner;

public class CharacterFrequency {

    // Method to find frequency of characters
    public static String[][] findFrequency(String str) {

        int[] frequency = new int[256];  // ASCII array

        // Step 1: Count frequency of each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            frequency[ch]++;
        }

        // Step 2: Count unique characters
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                uniqueCount++;
            }
        }

        // Step 3: Create 2D array for result
        String[][] result = new String[uniqueCount][2];

        int index = 0;

        // Step 4: Store character and its frequency
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (frequency[ch] != 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(frequency[ch]);

                frequency[ch] = 0; // Avoid duplicate storing
                index++;
            }
        }

        return result;
    }

    // Method to display result
    public static void displayResult(String[][] data) {

        System.out.println("\nCharacter\tFrequency");
        System.out.println("---------------------------");

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