import java.util.Arrays;

/**
 * @author youyu.song
 * @date 2019/11/12 9:32
 */
public class Solution {

    /**
     * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
     *
     * 示例 1:
     * 输入: n = 12
     * 输出: 3
     * 解释: 12 = 4 + 4 + 4.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/perfect-squares
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] num = new int[n + 1];
        Arrays.fill(num, n);
        num[0] = 0;

        for (int i = 1; i <= n; i ++) {
            for (int j = 1; i - j * j >= 0; j ++) {
                num[i] = Math.min(num[i], num[i - j * j] + 1);
            }
        }

        return num[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
        System.out.println(new Solution().numSquares(24));
    }

}
