/**
 * @author youyusong
 * @date 2018/12/25
 */
public class Solution {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。
     * @param s
     * @return
     */
    public String reverseString(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }

        char[] in = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        char temp;
        while (i < j) {
            temp = in[i];
            in[i] = in[j];
            in[j] = temp;
            i ++;
            j --;
        }

        return new String(in);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "hello";
        String result = solution.reverseString(s);
        System.out.println(result);
    }
}
