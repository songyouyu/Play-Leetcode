/**
 * @author songyouyu
 * @date 2023/4/9 19:08:14
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/binary-search/
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(new Solution().search(nums, 9));
    }

}
