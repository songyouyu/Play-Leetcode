import java.util.Arrays;

/**
 * @author youyusong
 * @date 2019/1/17
 */
public class Solution2 {

    private int[] memo;

    /**
     * 记忆化搜索
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }

        if (memo[n] != -1) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i < n; i ++) {
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }

        memo[n] = res;

        return res;
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }


}
