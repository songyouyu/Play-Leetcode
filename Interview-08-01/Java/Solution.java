/**
 * @author songyouyu
 * @date 2022/2/12
 */
public class Solution {

    /**
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
     * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     *
     * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
     *
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < n + 1; i ++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i -3];
            dp[i] = dp[i] % 1000000007;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().waysToStep(n));
    }

}
