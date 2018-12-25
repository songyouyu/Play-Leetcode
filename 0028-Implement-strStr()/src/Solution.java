/**
 * @author youyusong
 * @date 2018/12/24
 */
public class Solution {

    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     * 如果不存在，则返回  -1。
     *
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
     *
     * hello          ll
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i ++) {
            int j = 0;
            for (; j < needle.length(); j ++) {
                if (needle.charAt(j) != haystack.charAt(j + i)) {
                    break;
                }
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "bbbbba";
        String needle = "";
        int i = solution.strStr(haystack, needle);
        System.out.println(i);
    }

}
