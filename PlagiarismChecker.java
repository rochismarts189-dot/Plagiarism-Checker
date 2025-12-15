// University ID: 2500032118
import java.io.*;
import java.util.*;

public class PlagiarismChecker {

    static String readFile(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append(" ");
        }

        br.close();
        return sb.toString().toLowerCase();
    }

    static Map<String, Integer> getWordFrequency(String text) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.split("\\W+");

        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        return map;
    }

    static double cosineSimilarity(Map<String, Integer> map1,
                                   Map<String, Integer> map2) {

        Set<String> allWords = new HashSet<>();
        allWords.addAll(map1.keySet());
        allWords.addAll(map2.keySet());

        int dotProduct = 0;
        double mag1 = 0, mag2 = 0;

        for (String word : allWords) {
            int v1 = map1.getOrDefault(word, 0);
            int v2 = map2.getOrDefault(word, 0);

            dotProduct += v1 * v2;
            mag1 += v1 * v1;
            mag2 += v2 * v2;
        }

        return dotProduct / (Math.sqrt(mag1) * Math.sqrt(mag2));
    }

    public static void main(String[] args) throws Exception {
        String text1 = readFile("file1.txt");
        String text2 = readFile("file2.txt");

        Map<String, Integer> map1 = getWordFrequency(text1);
        Map<String, Integer> map2 = getWordFrequency(text2);

        double similarity = cosineSimilarity(map1, map2) * 100;

        System.out.printf("Plagiarism Similarity: %.2f%%\n", similarity);
    }
}
