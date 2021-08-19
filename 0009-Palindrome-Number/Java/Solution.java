/**
 * @author songyouyu
 * @date 2021/8/19
 */
public class Solution {

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     *
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int i = 0, j = chars.length - 1;

        while (i <= j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i ++;
            j --;
        }

        return true;
    }

    public static void main(String[] args) {
        int x = -121;
        System.out.println(new Solution().isPalindrome(x));
    }


}
