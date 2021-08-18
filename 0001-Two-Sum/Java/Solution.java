/**
 * @author youyusong
 * @date 2018/12/12
 */
public class Solution {

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //int i = 0;
        //int j = 1;
        //int n = nums.length;
        //int[] result = new int[2];
        //
        //while (i < n) {
        //    for (; j < n; j ++) {
        //        if (nums[j] == target - nums[i]) {
        //            result[0] = i;
        //            result[1] = j;
        //            break;
        //        }
        //    }
        //
        //    if (result[0] != 0) {
        //        break;
        //    }
        //
        //    i ++;
        //    j = i + 1;
        //}
        //
        //return result;

        for (int i = 0; i < nums.length; i ++) {
            int tmp = target - nums[i];
            for (int j = i + 1; j < nums.length; j ++) {
                if (tmp == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
