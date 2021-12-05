/**
 * @author songyouyu
 * @date 2021/12/5
 */
public class Solution {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
     */
    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i < n + 1; i ++) {
            num[i] = (num[i - 1] + num[i - 2]) % 1000000007;
        }

        return num[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numWays(7));
    }

}
