import java.util.Arrays;

public class Solution {
    
    /**
     * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        if (len == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }

        int l = 0;
        int r = len - 1;
        int lIndex = -1;
        int rIndex = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                while (mid - 1 >= 0 && nums[mid - 1] == target) {
                    mid = mid - 1;
                }
                lIndex = mid;

                mid = l + (r - l) / 2;
                while (mid + 1 < len && nums[mid + 1] == target) {
                    mid = mid + 1;
                }
                rIndex = mid;
                break;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return new int[]{lIndex, rIndex};
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] searchRange = new Solution().searchRange(nums, 10);
        System.out.println(Arrays.toString(searchRange));
    }

}
