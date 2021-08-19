/**
 * @author songyouyu
 * @date 2021/8/19
 */
public class Solution {

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     *
     * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        n = n % s.length();

        int i = 0;
        int j = 0;
        int k = s.length() - 1;
        char[] chars = s.toCharArray();

        while (j < n) {
            j ++;
        }
        while (j > 0) {
            char tmp = chars[i];
            while (i + 1 <= k) {
                chars[i] = chars[i + 1];
                i ++;
            }
            chars[k] = tmp;
            i = 0;
            j --;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        System.out.println(new Solution().reverseLeftWords(s, n));
    }

}
