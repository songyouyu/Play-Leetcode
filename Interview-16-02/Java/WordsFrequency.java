import java.util.Map;

public class WordsFrequency {
    
    Map<String, Integer> map = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (String word : book) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }
    
    public int get(String word) {
        return map.getOrDefault(word, 0);
    }

}
