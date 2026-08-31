import java.util.Scanner;

public class SplitTextIntoWordsUsingCharAt {

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

    public static String[] splitIntoWords(String text) {
        int length = findLengthUsingCharAt(text);
        int wordCount = 0;
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ' && i > 0 && text.charAt(i - 1) != ' ') {
                wordCount++;
            }
        }
        if (length > 0 && text.charAt(length - 1) != ' ') {
            wordCount++;
        }

        String[] words = new String[wordCount];
        StringBuilder currentWord = new StringBuilder();
        int wordIndex = 0;
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                if (currentWord.length() > 0) {
                    words[wordIndex] = currentWord.toString();
                    wordIndex++;
                    currentWord = new StringBuilder();
                }
            } else {
                currentWord.append(ch);
            }
        }
        if (currentWord.length() > 0) {
            words[wordIndex] = currentWord.toString();
        }
        return words;
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        String[] customWords = splitIntoWords(text);
        String[] builtInWords = text.trim().split("\\s+");

        boolean isSame = compareStringArrays(customWords, builtInWords);

        System.out.print("Words using charAt(): ");
        for (String word : customWords) {
            System.out.print(word + " | ");
        }
        System.out.println();

        System.out.print("Words using split(): ");
        for (String word : builtInWords) {
            System.out.print(word + " | ");
        }
        System.out.println();

        System.out.println("Both arrays match: " + isSame);

        scanner.close();
    }
}
