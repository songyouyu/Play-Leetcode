/**
 * @author youyusong
 * @date 2019/2/19
 */
public class Solution {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     *
     * 输入: "A man, a plan, a canal: Panama"
     * 输出: true
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (! Character.isLetterOrDigit(s.charAt(i))) {
                i ++;
            } else if (! Character.isLetterOrDigit(s.charAt(j))) {
                j --;
            } else {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                    return false;
                }

                i ++;
                j --;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "A man, a plan, a canal: Panama";

        boolean b = solution.isPalindrome(s);
        System.out.println(b);
    }

}
