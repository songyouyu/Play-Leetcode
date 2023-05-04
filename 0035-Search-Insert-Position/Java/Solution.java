/**
 * @author youyusong
 * @date 2018/11/14
 */
public class Solution {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == target) {
                return i;
            }
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        } else if (target < nums[0]) {
            return 0;
        } else {
            for (int j = 0; j < nums.length; j ++) {
                if (nums[j] > target) {
                    return j;
                }
            }

            return 0;
        }
    }

    public int searchInsert2(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if ((mid + 1 < len && nums[mid + 1] > target) || (mid + 1 >= len && nums[len - 1] < target)) {
                    return mid + 1;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int n = solution.searchInsert2(nums, -1);
        System.out.println(n);
    }

}
