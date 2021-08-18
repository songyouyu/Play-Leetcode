import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author youyu.song
 * @date 2019/4/2
 */
public class Solution {

    /**
     * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
     *
     * 输入:
     * "tree"
     * 输出:
     * "eert"
     * 解释:
     * 'e'出现两次，'r'和't'都只出现一次。
     * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
     *
     * 注意'A'和'a'被认为是两种不同的字符。
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        // https://github.com/zhantong/leetcode/blob/master/451.%20Sort%20Characters%20By%20Frequency/Java/Solution.java
        Map<Character, Integer> freqDict = new HashMap<>();
        int maxFreq = -1;
        for (char letter : s.toCharArray()) {
            if (!freqDict.containsKey(letter)) {
                freqDict.put(letter, 0);
            }
            int freq = freqDict.get(letter) + 1;
            freqDict.put(letter, freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        List<Character>[] freqList = new List[maxFreq + 1];
        for (Map.Entry<Character, Integer> entry : freqDict.entrySet()) {
            if (freqList[entry.getValue()] == null) {
                freqList[entry.getValue()] = new ArrayList<>();
            }
            freqList[entry.getValue()].add(entry.getKey());
        }
        StringBuilder builder = new StringBuilder();
        for (int i = freqList.length - 1; i > 0; i--) {
            if (freqList[i] != null) {
                for (Character letter : freqList[i]) {
                    for (int j = 0; j < i; j++) {
                        builder.append(letter);
                    }
                }
            }
        }

        return builder.toString();
    }

}
