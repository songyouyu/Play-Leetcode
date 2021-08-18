import java.util.Arrays;

/**
 * @author youyu.song
 * @date 2019/4/3
 */
public class Solution {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
     * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
     * 假定每组输入只存在唯一答案。
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i ++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                // 只存在唯一答案
                int cur = nums[i] + nums[j] + nums[k];
                if (cur == target) {
                    return target;
                }
                if (Math.abs(cur - target) < Math.abs(result - target)) {
                    result = cur;
                }

                if (cur > target) {
                    k --;
                } else {
                    j ++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int i = solution.threeSumClosest(nums, target);
        System.out.println(i);
    }

}
