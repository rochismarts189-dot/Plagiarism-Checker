import java.util.*;
import java.io.*;


public class SimilarityChecker {

    public double cosineSimilarity(Map<String, Integer> map1,
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
}

