/**
 * @author songyouyu
 * @date 2021/12/5
 */
public class Solution {

    /**
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        int[] num = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (num[n] != 0) {
            return num[n];
        }
        num[n] = (fib(n - 1) + fib(n - 2)) % 1000000007;
        return num[n];
    }

    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }

        int[] num = new int[n + 1];
        num[1] = 1;

        for (int i = 2; i < n + 1; i ++) {
            num[i] = (num[i - 1] + num[i - 2]) % 1000000007;
        }

        return num[n];
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(new Solution().fib1(7));
    }

}
