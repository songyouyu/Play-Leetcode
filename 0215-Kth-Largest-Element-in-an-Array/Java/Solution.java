import java.util.Arrays;

/**
 * @author youyusong
 * @date 2019/2/19
 */
public class Solution {

    /**
     * 在未排序的数组中找到第 k 个最大的元素。
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        int result = nums[nums.length - 1];

        if (k == 1) {
            return result;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            result = nums[i];
            k--;
            if (k == 0) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 1};
        int k = 3;
        int i = solution.findKthLargest(nums, k);
        System.out.println(i);
    }

}
