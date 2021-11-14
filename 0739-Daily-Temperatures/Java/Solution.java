import java.util.Arrays;
import java.util.Stack;

/**
 * @author songyouyu
 * @date 2021/11/14
 */
public class Solution {

    /**
     * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     *
     * 链接：https://leetcode-cn.com/problems/daily-temperatures/
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < len; i ++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(num)));
    }

}
