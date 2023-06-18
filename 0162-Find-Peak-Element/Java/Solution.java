public class Solution {

    /**
     * https://leetcode.cn/problems/find-peak-element/
     * 
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }

        int l = 0;
        int r = len - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid - 1 < 0) {
                if (nums[mid] < nums[mid + 1]) {
                    return mid + 1;
                } else {
                    return mid;
                }
            }
            if (mid + 1 >= len) {
                if (nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    return mid - 1;
                }
            }

            int num = nums[mid];
            if (nums[mid - 1] < num && nums[mid + 1] < num) {
                return mid;
            } else if (nums[mid - 1] < num && nums[mid + 1] > num) {
                l = mid + 1;
            } else if (nums[mid - 1] > num && nums[mid + 1] < num) {
                r = mid - 1;
            } else {
                // 两个峰值之间, 随便找一个位置
                l = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        System.out.println(new Solution().findPeakElement(nums));
    }

}