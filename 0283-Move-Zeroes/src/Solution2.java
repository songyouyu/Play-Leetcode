/**
 * @author youyusong
 * @date 2019/1/21
 */
public class Solution2 {

    public void moveZeroes(int[] nums) {
        int k = 0;

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != 0) {
                if (i != k) {
                    swap(nums, k, i);
                    k ++;
                } else {
                    k ++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
