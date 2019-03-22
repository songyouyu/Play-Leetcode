/**
 * @author youyusong
 * @date 2019/2/20
 */
public class Solution {

    /**
     * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
     *
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     *
     * 说明：
     * 如果 S 中不存在这样的子串，则返回空字符串 ""。
     * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        if ((s == null && t == null) || s.length() < t.length()) {
            return "";
        }



        return "";
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution solution = new Solution();
        String window = solution.minWindow(s, t);
        System.out.println(window);
    }
}
