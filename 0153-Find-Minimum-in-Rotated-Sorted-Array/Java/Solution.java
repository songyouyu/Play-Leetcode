public class Solution {
    
    /**
     * https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/
     * 
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int value = nums[mid];
            if  ((mid - 1 < 0 && nums[mid + 1] > value) || 
                    (mid + 1 >= len && nums[mid - 1] > value)  ||                    
                    (mid - 1 >= 0 && nums[mid - 1] > value && mid + 1 < len && nums[mid + 1] > value)) {
                return value;
            } 
            if (value < nums[len - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        System.out.println(new Solution().findMin(nums));
    }

}
