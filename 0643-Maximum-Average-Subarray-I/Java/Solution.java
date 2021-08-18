/**
 * @author youyusong
 * @date 2018/11/27
 */
public class Solution {

    /**
     * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
     *
     * 输入: [1,12,-5,-6,50,3], k = 4
     * 输出: 12.75
     * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int sum = 0;
        long maxSum = Long.MIN_VALUE;

        for (int j = 0; j < nums.length; j ++) {
            sum += nums[j];
            if (j - i == k - 1) {
                maxSum = Math.max(sum, maxSum);
                sum -= nums[i];
                i ++;
            }
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,12,-5,-6,50,3};
        double solutionMaxAverage = solution.findMaxAverage(nums, 4);
        System.out.println(solutionMaxAverage);
    }

}
