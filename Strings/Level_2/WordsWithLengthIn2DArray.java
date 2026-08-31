import java.util.Scanner;

public class WordsWithLengthIn2DArray {

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

    public static String[][] getWordsWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLengthUsingCharAt(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        String[] words = splitIntoWords(text);
        String[][] wordsWithLength = getWordsWithLength(words);

        System.out.println("Word\t\tLength");
        for (String[] row : wordsWithLength) {
            int length = Integer.parseInt(row[1]);
            System.out.println(row[0] + "\t\t" + length);
        }

        scanner.close();
    }
}
