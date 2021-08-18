import java.util.HashMap;
import java.util.Map;

/**
 * @author youyusong
 * @date 2018/12/25
 */
public class Solution {

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     *
     * 案例:
     * s = "leetcode"
     * 返回 0.
     * s = "loveleetcode",
     * 返回 2.
     *
     * 注意事项：您可以假定该字符串只包含小写字母。
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }


        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++) {
            if (! map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        Map<Character, Integer> hashMap = new HashMap<>();
        for (Character key : map.keySet()) {
            if (map.get(key) == 1) {
               hashMap.put(key, map.get(key));
            }
        }

        if (hashMap.isEmpty()) {
            return -1;
        }

        int min = s.length();
        for (Character key : hashMap.keySet()) {
            int a =  s.indexOf(String.valueOf(key));
            min = Math.min(min, s.indexOf(String.valueOf(key)));
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "loveleetcode";
        int result = solution.firstUniqChar(s);
        System.out.println(result);
    }


}
