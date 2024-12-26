import java.io.*;

public class WordCounter {

    public static void main(String[] args) {
        String filename = "C:\\Users\\Danga\\Desktop\\унік\\ОП лаби\\Laba14\\file.txt";

        try {
            long wordCount = numberOfWords(filename);
            System.out.println("Кількість слів у файлі: " + wordCount);
        } catch (IOException e) {
            System.err.println("Помилка обробки файлу: " + e.getMessage());
        }
    }
    public static long numberOfWords(String filename) throws IOException {
        if (filename == null) {
            throw new NullPointerException("Ім'я файлу не може бути null.");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            long wordCount = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                wordCount += countWordsInLine(line);
            }

            return wordCount;
        }
    }

    private static long countWordsInLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            return 0;
        }
        
        String[] words = line.trim().split("\\s+");
        return words.length;
    }
}
