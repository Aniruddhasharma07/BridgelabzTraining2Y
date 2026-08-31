import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicatesUsingStringBuilder {

    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String result = removeDuplicates(input);
        System.out.println("String without duplicates: " + result);
        sc.close();
    }
}
