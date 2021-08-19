/**
 * @author songyouyu
 * @date 2021/8/19
 */
public class Solution {

    /**
     * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
     * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
     *
     * 链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length;
        StringBuilder sb = new StringBuilder();

        while (l < r) {
            char c = chars[l];
            if (c == ' ' && l + 1 < r && chars[l + 1] != ' ') {
                // c 的下一个字符不是空格
                if (sb.length() != 0) {
                    sb.append(c);
                }
            } else if (c != ' '){
                // c 本身不是空格
                sb.append(c);
            }
            l ++;
        }

        int len = sb.length();
        char[] result = new char[len];
        int k = 0;
        char[] sbChar = sb.toString().toCharArray();
        int i = len - 1, j;

        while (i >= 0) {
            while (i >= 0 && sbChar[i] != ' ') {
                i --;
            }
            j = i + 1;
            for (; j < len && sbChar[j] != ' '; j ++) {
                result[k] = sbChar[j];
                k ++;
            }
            if (k != len) {
                result[k] = ' ';
                k ++;
            }
            i --;
        }

        return new String(result);
    }

}
