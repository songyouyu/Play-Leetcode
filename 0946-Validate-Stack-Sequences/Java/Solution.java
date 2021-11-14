import java.util.Stack;

/**
 * @author songyouyu
 * @date 2021/11/14
 */
public class Solution {

    /**
     * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
     * 只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；
     * 否则，返回 false。
     *
     * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
     * 输出：true
     * 解释：我们可以按以下顺序执行：
     * push(1), push(2), push(3), push(4), pop() -> 4,
     * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
     *
     * 链接：https://leetcode-cn.com/problems/validate-stack-sequences
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack();

        while (i < pushed.length) {
            if (pushed[i] == popped[j]) {
                i ++;
                j ++;
            } else {
                if (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j ++;
                } else {
                    stack.push(pushed[i]);
                    i ++;
                }
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != popped[j]) {
                return false;
            }
            j ++;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};

        System.out.println(new Solution().validateStackSequences(pushed, popped));
    }

}
