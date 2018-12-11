import java.util.Arrays;

/**
 * @author youyusong
 * @date 2018/12/11
 */
public class Solution {

    /**
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
     * 使得从1 到 n 的 min(ai, bi) 总和最大
     *
     * 输入: [1,4,3,2]
     * 输出: 4
     * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
     *
     * n 是正整数,范围在 [1, 10000].
     * 数组中的元素范围在 [-10000, 10000].
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i = i + 2) {
            sum += nums[i];
        }

        return sum;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,12,-5,-6,50,3};
        int result = solution.arrayPairSum(nums);
        System.out.println(result);
    }

}
