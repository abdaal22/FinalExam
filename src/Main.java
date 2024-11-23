import java.util.Scanner;

class InputReader {
    private TextStatistics stats = new TextStatistics();

    public void readInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input text (end with 'stop'):");
        while (true) {
            String input = scanner.nextLine();
            if (stats.isStop(input)) break;
            stats.addLine(input);
        }
        scanner.close();
        printResult();
    }

    private void printResult() {
        System.out.println("Number of lines: " + stats.getLineCount());
        System.out.println("Number of characters: " + stats.getCharacterCount());
        System.out.println("Number of words: " + stats.getWordCount());
        System.out.println("Longest word: " + stats.getLongestWord());
    }
}

class TextStatistics {
    private int lineCount = 0;
    private int characterCount = 0;
    private int wordCount = 0;
    private String longestWord = "";

    public boolean isStop(String input) {
        return input.equalsIgnoreCase("stop");
    }

    public void addLine(String line) {
        lineCount++;
        String Sentences = line.replace(" ", "");
        characterCount += Sentences.length();
        String[] words = line.split("\\s+");
        wordCount += words.length;
        for (String word : words) {
            if (word.length() >= longestWord.length()) {
                longestWord = word;
            }
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String getLongestWord() {
        return longestWord;
    }

}



