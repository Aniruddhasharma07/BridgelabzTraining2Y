import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class StringIOPerformanceComparisonChallenge {

    public static void compareStringBuilderAndStringBuffer(int iterations) {
        long startBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }
        long endBuilder = System.nanoTime();

        long startBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }
        long endBuffer = System.nanoTime();

        System.out.println("StringBuilder time (ns): " + (endBuilder - startBuilder));
        System.out.println("StringBuffer time (ns): " + (endBuffer - startBuffer));
    }

    public static long countWordsUsingFileReader(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        long wordCount = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                wordCount += line.trim().split("\\s+").length;
            }
        }

        bufferedReader.close();
        fileReader.close();
        return wordCount;
    }

    public static long countWordsUsingInputStreamReader(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        long wordCount = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                wordCount += line.trim().split("\\s+").length;
            }
        }

        bufferedReader.close();
        inputStreamReader.close();
        fileInputStream.close();
        return wordCount;
    }

    public static void main(String[] args) {
        compareStringBuilderAndStringBuffer(1000000);

        String filePath = "largefile.txt";

        try {
            long startFileReader = System.nanoTime();
            long fileReaderWordCount = countWordsUsingFileReader(filePath);
            long endFileReader = System.nanoTime();

            long startInputStreamReader = System.nanoTime();
            long inputStreamReaderWordCount = countWordsUsingInputStreamReader(filePath);
            long endInputStreamReader = System.nanoTime();

            System.out.println("FileReader word count: " + fileReaderWordCount);
            System.out.println("FileReader time (ns): " + (endFileReader - startFileReader));

            System.out.println("InputStreamReader word count: " + inputStreamReaderWordCount);
            System.out.println("InputStreamReader time (ns): " + (endInputStreamReader - startInputStreamReader));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
