import java.util.Stack;

/**
 * @author youyusong
 * @date 2018/12/24
 */
public class Solution {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * ()[]{}
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }

        if (s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character cur;
                char a = stack.pop();

                if (c == ')') {
                    cur = '(';
                } else if (c == ']') {
                    cur = '[';
                } else {
                    cur = '{';
                }

                if (cur != a) {
                    return false;
                }
            }
        }

        if (! stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "){";
        boolean b = solution.isValid(s);
        System.out.println(b);
    }

}
