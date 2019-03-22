import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author youyusong
 * @date 2019/2/20
 */
public class Solution {

    /**
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     *
     * 说明：
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     *
     * 输入:
     * s: "cbaebabacd" p: "abc"
     * 输出:
     * [0, 6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();

        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }

        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            if (hash[s.charAt(right)] >= 1) {
                count --;
            }
            hash[s.charAt(right)] --;
            right ++;
            if (count == 0) {
                list.add(left);
            }
            if (right - left == p.length()) {
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }

                hash[s.charAt(left)] ++;
                left++;
            }
        }

        return list;
    }

    // 耗时 2.8s 左右
//    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> list = new ArrayList<Integer>();
//        int i = 0;
//
//        while (i + p.length() <= s.length()) {
//            if (compare(s.substring(i, i + p.length()), p)) {
//                list.add(i);
//                i ++;
//            } else {
//                i ++;
//            }
//        }
//
//        return list;
//    }

    private static boolean compare(String s1, String s2) {
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        Arrays.sort(b1);
        Arrays.sort(b2);
        s1 = new String(b1);
        s2 = new String(b2);

        if(s1.equals(s2)){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";

        Solution solution = new Solution();
        List<Integer> list = solution.findAnagrams(s, p);
        System.out.println(list);
    }
}
