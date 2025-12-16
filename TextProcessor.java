import java.util.*;
import java.io.*;

public class TextProcessor {

    public Map<String, Integer> getWordFrequency(String text) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = text.split("\\W+");

        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        return map;
    }
}