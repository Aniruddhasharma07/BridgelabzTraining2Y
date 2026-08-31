import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadUserInputWriteToFileUsingInputStreamReader {

    public static void main(String[] args) {
        String filePath = "output.txt";

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter(filePath);

            String line;
            System.out.println("Enter text (type 'exit' to stop):");
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(line);
                fileWriter.write(System.lineSeparator());
            }

            fileWriter.close();
            bufferedReader.close();
            inputStreamReader.close();

            System.out.println("Input written to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
