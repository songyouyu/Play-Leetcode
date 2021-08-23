/**
 * @author songyouyu
 * @date 2021/8/22
 */
public class Solution {

    /**
     * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
     * 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
     *
     * 输入:
     * first = "pale"
     * second = "ple"
     * 输出: True
     *
     * 输入:
     * first = "pales"
     * second = "pal"
     * 输出: False
     *
     * 链接：https://leetcode-cn.com/problems/one-away-lcci
     *
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        first = first.trim();
        second = second.trim();
        int firstLen = first.length();
        int secondLen = second.length();

        if ("".equals(first)) {
            return secondLen <= 1;
        }
        if ("".equals(second)) {
            return firstLen <= 1;
        }
        if (Math.abs(secondLen - firstLen) >= 2) {
            return false;
        }


        if (firstLen == secondLen) {
            int i = 0;
            int j = 0;
            char[] firstChars = first.toCharArray();
            char[] secondChars = second.toCharArray();
            while (i < firstLen) {
                char firstChar = firstChars[i];
                char secondChar = secondChars[i];
                if (firstChar != secondChar) {
                    j ++;
                }
                if (j >= 2) {
                    return false;
                }
                i ++;
            }
            return true;
        }

        if (firstLen > secondLen) {
            String tmp = first;
            first = second;
            second = tmp;
        }
        firstLen = first.length();
        secondLen = second.length();

        int i = 0;
        int j = 0;
        int k = 0;
        char[] firstChars = first.toCharArray();
        char[] secondChars = second.toCharArray();
        while (i < firstLen) {
            char firstChar = firstChars[i];
            char secondChar = secondChars[j];
            if (firstChar != secondChar) {
                if (j + 1 < secondLen && firstChar == secondChars[j + 1]) {
                    j ++;
                    k ++;
                    if (k >= 2) {
                        return false;
                    }
                } else {
                    return false;
                }

            }

            i ++;
            j ++;
        }

        return true;
    }

    public static void main(String[] args) {
        String first = "teacher";
        String second = "taches";
        System.out.println(new Solution().oneEditAway(first, second));
    }

}
