import sun.java2d.opengl.CGLSurfaceData;

/**
 * @author songyouyu
 * @date 2021/8/18
 */
public class Solution {

    /**
     * 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
     *
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     *
     * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
     *
     * 说明：
     *
     * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
     * 翻转后单词间应当仅用一个空格分隔。
     * 翻转后的字符串中不应包含额外的空格。
     *
     * 注意:
     * 1 <= s.length <= 10的4次方
     * s 包含英文大小写字母、数字和空格 ' '
     * s 中 至少存在一个 单词
     *
     * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
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

    public static void main(String[] args) {
        String s = "   hello   dd  world  ";
        System.out.println(new Solution().reverseWords(s));
        System.out.println(new Solution().reverseWords(s).length());
    }


}
