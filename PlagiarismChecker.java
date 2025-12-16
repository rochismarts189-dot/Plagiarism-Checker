import java.io.*;
import java.util.*;

public class PlagiarismChecker {

    public static void main(String[] args) throws Exception {

        DocumentReader reader = new DocumentReader();
        TextProcessor processor = new TextProcessor();
        SimilarityChecker checker = new SimilarityChecker();

        String text1 = reader.readFile("file1.txt");
        String text2 = reader.readFile("file2.txt");

        Map<String, Integer> map1 = processor.getWordFrequency(text1);
        Map<String, Integer> map2 = processor.getWordFrequency(text2);

        double similarity = checker.cosineSimilarity(map1, map2) * 100;

        System.out.printf("Plagiarism Similarity: %.2f%%\n", similarity);
    }
}
