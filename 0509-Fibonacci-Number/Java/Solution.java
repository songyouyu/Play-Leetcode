import java.util.Arrays;

/**
 * @author youyu.song
 * @date 2020/6/7 9:52
 */
public class Solution {

    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 给定 N，计算 F(N)。
     *
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fibonacci-number
     *
     * @param N
     * @return
     */
    public int fib(int N) {
        // 1.递归
        //if (N == 0) {
        //    return 0;
        //}
        //
        //if (N == 1) {
        //    return 1;
        //}
        //
        //return fib(N - 1) + fib(N - 2);

        // 2.记忆化搜索
        //int[] memo = new int[N + 1];
        //Arrays.fill(memo, -1);
        //
        //return fib(memo, N);

        // 3.动态规划(自底向上)
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }

        int[] memo = new int[N + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= N; i ++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[N];
    }

    private int fib(int[] memo, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (memo[n] == -1) {
            memo[n] = fib(memo, n - 1) + fib(memo, n - 2);
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(2));
    }


}
