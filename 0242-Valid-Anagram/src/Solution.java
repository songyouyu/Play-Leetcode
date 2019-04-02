import java.util.HashMap;

/**
 * @author youyu.song
 * @date 2019/3/22
 */
public class Solution {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //
        //HashMap<Character, Integer> hashMap = new HashMap<>();
        //for (int i = 0; i < s.length(); i ++) {
        //    char c = s.charAt(i);
        //    if (hashMap.containsKey(c)) {
        //        hashMap.put(c, hashMap.get(c) + 1);
        //    } else {
        //        hashMap.put(c, 1);
        //    }
        //}
        //
        //for (int i = 0; i < t.length(); i ++) {
        //    char c = t.charAt(i);
        //    if (hashMap.containsKey(c) && hashMap.get(c) > 0) {
        //        hashMap.put(c, hashMap.get(c) - 1);
        //    } else {
        //        return false;
        //    }
        //}
        //
        //return true;

        int[] num = new int[26];

        for (int i = 0; i < s.length(); i ++) {
            num[s.charAt(i) - 'a'] ++;
            num[t.charAt(i) - 'a'] --;
        }

        for (int n : num) {
            if (n != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ab";
        String t = "a";
        boolean b = solution.isAnagram(s, t);
        System.out.println(b);
    }

}