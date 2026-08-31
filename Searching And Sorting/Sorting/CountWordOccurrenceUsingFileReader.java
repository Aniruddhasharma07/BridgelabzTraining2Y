import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordOccurrenceUsingFileReader {

    public static int countWordOccurrence(String filePath, String targetWord) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int count = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equalsIgnoreCase(targetWord)) {
                    count++;
                }
            }
        }

        bufferedReader.close();
        fileReader.close();
        return count;
    }

    public static void main(String[] args) {
        String filePath = "input.txt";
        String targetWord = "java";

        try {
            int count = countWordOccurrence(filePath, targetWord);
            System.out.println("Occurrences of \"" + targetWord + "\": " + count);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
