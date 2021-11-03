import java.util.Stack;

/**
 * @author songyouyu
 * @date 2021/10/10
 */
public class Solution {

    /**
     * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
     *
     * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格。 整数除法仅保留整数部分。
     *
     * 链接：https://leetcode-cn.com/problems/calculator-lcci
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<Character> character = new Stack<>();

        int len = s.length();
        int i = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (c == ' ') {
                i ++;
            } else if (Character.isDigit(c)) {
                int number = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    number = number * 10 + (s.charAt(i) - '0');
                    i ++;
                }
                num.push(number);
            } else {
                // + - * /
                while (!character.isEmpty() && !prior(c, character.peek())) {
                    cal(num, character);
                }
                character.push(c);
                i ++;
            }
        }

        while (!character.isEmpty()) {
            cal(num, character);
        }

        return num.pop();
    }

    private boolean prior(char a, char b) {
        return (a == '*' || a == '/') && (b == '+' || b == '-');
    }

    private void cal(Stack<Integer> num, Stack<Character> character) {
        int a = num.pop();
        int b = num.pop();
        char c = character.pop();

        int res = 0;
        switch (c) {
            case '+':
                res = b + a;
                break;
            case '-':
                res = b - a;
                break;
            case '*':
                res = b * a;
                break;
            case '/':
                res = b / a;
                break;
        }
        num.push(res);
    }

    public static void main(String[] args) {
        String s = "13+5/2-3*5-2+1 ";
        System.out.println(new Solution().calculate(s));
    }

}
