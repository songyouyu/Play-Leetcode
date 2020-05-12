import java.util.Stack;

/**
 * @author youyu.song
 * @date 2020/5/12 9:54
 */
public class Solution {

    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
     *
     * 输入: "(1+(4+5+2)-3)+(6+8)"
     * 输出: 23
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int len = s.length();
        // 加法代表 1, 减法代表 -1
        int flag = 1;

        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int cur = c - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(i + 1) - '0';
                    i ++;
                }
                result += flag * cur;
            } else if (c == '+') {
                flag = 1;
            } else if (c == '-') {
                flag = -1;
            } else if (c == '(') {
                // 将以前的结果压入栈
                stack.push(result);
                // 保存此括号内的计算结果
                result = 0;
                // 记录 ( 前是加法或减法
                stack.push(flag);
                flag = 1;
            } else if (c == ')') {
                // 第一次 stack.pop() 代表右括号对应的左括号前是 加法或减法
                int tmp = result * stack.pop();
                result = tmp + stack.pop();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new Solution().calculate(s));
    }

}
