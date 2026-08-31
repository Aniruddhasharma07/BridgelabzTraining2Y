public class ConcatenateStringsUsingStringBuffer {

    public static String concatenateStrings(String[] words) {
        StringBuffer sb = new StringBuffer();

        for (String word : words) {
            sb.append(word);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!", " Welcome", " to", " Java."};

        String result = concatenateStrings(words);
        System.out.println("Concatenated string: " + result);
    }
}
