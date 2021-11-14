import java.util.Stack;

/**
 * @author songyouyu
 * @date 2021/11/6
 */
public class Solution {

    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *
     * 输入："abbaca"
     * 输出："ca"
     *
     * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        Stack<Character> result = new Stack<>();
        int len = s.length();

        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            if (result.isEmpty() || c != result.peek()) {
                result.push(c);
            } else {
                result.pop();
            }
        }

        if (result.isEmpty()) {
            return "";
        } else {
            Stack<Character> stack = new Stack<>();
            while (!result.isEmpty()) {
                stack.push(result.pop());
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String s = "aabaca";
        System.out.println(new Solution().removeDuplicates(s));

    }

}
