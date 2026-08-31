import java.util.Scanner;

public class TrimStringUsingCharAt {

    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < text.length() && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && text.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end + 1};
    }

    public static String getSubstringUsingCharAt(String text, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end; i++) {
            result.append(text.charAt(i));
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
        System.out.print("Enter a string with leading/trailing spaces: ");
        String text = scanner.nextLine();

        int[] indexes = findTrimIndexes(text);
        String customTrimmed = getSubstringUsingCharAt(text, indexes[0], indexes[1]);
        String builtInTrimmed = text.trim();

        boolean isSame = compareUsingCharAt(customTrimmed, builtInTrimmed);

        System.out.println("Trimmed using charAt(): [" + customTrimmed + "]");
        System.out.println("Trimmed using trim(): [" + builtInTrimmed + "]");
        System.out.println("Both results match: " + isSame);

        scanner.close();
    }
}
