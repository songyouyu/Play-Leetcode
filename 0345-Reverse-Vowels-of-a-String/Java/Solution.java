import java.util.HashSet;

/**
 * @author youyusong
 * @date 2019/2/19
 */
public class Solution {

    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
     *
     * 输入: "hello"
     * 输出: "holle"
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        char[] in = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        char temp;

        while (i < j) {
            if (! isVowel(in[i])) {
                i ++;
            } else if (! isVowel(in[j])) {
                j --;
            } else {
                temp = in[i];
                in[i] = in[j];
                in[j] = temp;
                i ++;
                j --;
            }
        }

        return new String(in);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A'
                || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "leetcode";
        String vowels = solution.reverseVowels(s);
        System.out.println(vowels);
    }

}
