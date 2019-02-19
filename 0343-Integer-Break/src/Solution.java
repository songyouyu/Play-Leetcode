/**
 * @author youyusong
 * @date 2019/1/17
 */
public class Solution {

    /**
     * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。
     * 返回你可以获得的最大乘积。
     *
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1。
     *
     * 动态规划
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("exception");
        }

        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j <= i - 1; j ++) {
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }

        return memo[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

}
