import java.util.Stack;

/**
 * @author youyu.song
 * @date 2019/8/27 14:55
 */
public class Solution {

	/**
	 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
	 *
	 * 说明：
	 * 整数除法只保留整数部分。
	 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
	 *
	 * 示例 1：
	 * 输入: ["2", "1", "+", "3", "*"]
	 * 输出: 9
	 * 解释: ((2 + 1) * 3) = 9
	 *
	 * 示例 2：
	 * 输入: ["4", "13", "5", "/", "+"]
	 * 输出: 6
	 * 解释: (4 + (13 / 5)) = 6
	 *
	 * 示例 3：
	 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
	 * 输出: 22
	 * 解释:
	 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
	 * = ((10 * (6 / (12 * -11))) + 17) + 5
	 * = ((10 * (6 / -132)) + 17) + 5
	 * = ((10 * 0) + 17) + 5
	 * = (0 + 17) + 5
	 * = 17 + 5
	 * = 22
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
	 * @param tokens
	 * @return
	 */
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack();
		String s = null;
		for (int i = 0; i < tokens.length; i ++) {
			s = tokens[i];
			if (Character.isDigit(s.charAt(0))) {
				stack.push(s);
			} else if (s.length() > 1 && Character.isDigit(s.charAt(1))) {
				stack.push(s);
			} else {
				int j = Integer.parseInt(stack.pop());
				int k = Integer.parseInt(stack.pop());
				if ("+".equals(s)) {
					stack.push(String.valueOf(k + j));
				} else if ("-".equals(s)) {
					stack.push(String.valueOf(k - j));
				} else if ("*".equals(s)) {
					stack.push(String.valueOf(k * j));
				} else {
					stack.push(String.valueOf(k / j));
				}
			}

		}

		return Integer.parseInt(stack.pop());
	}

	public static void main(String[] args) {
		String[] arr = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
		Solution solution = new Solution();
		int result = solution.evalRPN(arr);
		System.out.println(result);
	}

}
