import java.util.Scanner;

public class ShortestAndLongestWord {

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

    public static int[] findShortestAndLongestIndex(String[][] wordsWithLength) {
        int shortestIndex = 0;
        int longestIndex = 0;
        for (int i = 1; i < wordsWithLength.length; i++) {
            int currentLength = Integer.parseInt(wordsWithLength[i][1]);
            int shortestLength = Integer.parseInt(wordsWithLength[shortestIndex][1]);
            int longestLength = Integer.parseInt(wordsWithLength[longestIndex][1]);
            if (currentLength < shortestLength) {
                shortestIndex = i;
            }
            if (currentLength > longestLength) {
                longestIndex = i;
            }
        }
        return new int[]{shortestIndex, longestIndex};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        String[] words = splitIntoWords(text);
        String[][] wordsWithLength = getWordsWithLength(words);
        int[] indexes = findShortestAndLongestIndex(wordsWithLength);

        System.out.println("Shortest word: " + wordsWithLength[indexes[0]][0]);
        System.out.println("Longest word: " + wordsWithLength[indexes[1]][0]);

        scanner.close();
    }
}
