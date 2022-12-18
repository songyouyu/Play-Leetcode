/**
 * @author songyouyu
 * @date 2022/12/18
 */
public class Solution {

    /**
     * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数。
     *
     * 链接：https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            return sPow(x, n);
        } else {
            return 1 / (sPow(x, -1 * (n + 1)) * x);
        }
    }

    private double sPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double d = sPow(x, n / 2);
        if (n % 2 == 0) {
            return d * d;
        } else {
            return d * d * x;
        }
    }


}
