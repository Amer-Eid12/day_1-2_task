public class App {

    public static void main(String[] args) {
        System.out.println("Custom Split:");
        String[] parts = customSplit("apple,banana,cherry", ',');
        for (String part : parts) {
            System.out.println(part);
        }

        String input = "Hello hHeLLo";
        System.out.println("\nCount 'h' ignore case: " + countCharIgnoreCase(input, 'h'));
        System.out.println("Count 'H' with case: " + countCharWithCase(input, 'H'));

        System.out.println("\nReversed sentence:");
        String reversed = reverseWords("Hello world this is Java");
        System.out.println(reversed);
    }

    // Task 1: Split a string by a delimiter (without using split())
    public static String[] customSplit(String input, char delimiter) {
        if (input == null || input.isEmpty()) return new String[0];

        int count = 1;
        for (char c : input.toCharArray()) {
            if (c == delimiter) count++;
        }

        String[] result = new String[count];
        StringBuilder temp = new StringBuilder();
        int index = 0;

        for (char c : input.toCharArray()) {
            if (c == delimiter) {
                result[index++] = temp.toString();
                temp.setLength(0); 
            } else {
                temp.append(c);
            }
        }

        result[index] = temp.toString(); 
        return result;
    }

    // Task 2a: Count characters ignoring case
    public static int countCharIgnoreCase(String input, char target) {
        if (input == null) return 0;
        int count = 0;
        char targetLower = Character.toLowerCase(target);
        for (char c : input.toCharArray()) {
            if (Character.toLowerCase(c) == targetLower) {
                count++;
            }
        }
        return count;
    }

    // Task 2b: Count characters with case sensitivity
    public static int countCharWithCase(String input, char target) {
        if (input == null) return 0;
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == target) {
                count++;
            }
        }
        return count;
    }

    // Task 3: Reverse word order in a sentence (without using built-in reverse/split)
    public static String reverseWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) return "";

        int wordCount = 0;
        boolean inWord = false;
        for (char c : sentence.toCharArray()) {
            if (c != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (c == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        StringBuilder word = new StringBuilder();
        int index = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c != ' ') {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    words[index++] = word.toString();
                    word.setLength(0);
                }
            }
        }

        if (word.length() > 0) {
            words[index] = word.toString();
        }

        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) result.append(' ');
        }

        return result.toString();
    }

    
}
