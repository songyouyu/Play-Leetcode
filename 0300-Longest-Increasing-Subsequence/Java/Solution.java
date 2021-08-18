import java.util.Arrays;

/**
 * @author youyusong
 * @date 2019/1/18
 */
public class Solution {

    /**
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);

        for (int i = 1; i < nums.length; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], 1 + memo[j]);
                }
            }
        }

        int res = 1;
        for (int i = 0; i < memo.length; i ++) {
            res = Math.max(res, memo[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10,9,2,5,3,7,101,18};
        int length = solution.lengthOfLIS(nums);
        System.out.println(length);
    }
}
