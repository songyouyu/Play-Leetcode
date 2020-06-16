/**
 * @author youyu.song
 * @date 2020/6/16 9:17
 */
public class Solution {

    /**
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * 你找到的子数组应是最短的，请输出它的长度。
     *
     * 示例 1:
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     *
     * 说明 :
     * 输入的数组长度范围在 [1, 10,000]。
     * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        /*
        从左到右找出最后一个破坏递增的数
        从右到左找出最后一个破坏递减的数
         */
        int len = nums.length;
        if (len == 0 || len == 1) {
            return 0;
        }

        int l = -1, r = len;
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        for (int i = 0; i < len; i ++) {
            if (nums[i] >= min) {
                min = nums[i];
            } else {
                l = i;
            }

            if (nums[len - i - 1] <= max) {
                max = nums[len - i - 1];
            } else {
                r = len - i - 1;
            }
        }

        if (l > r) {
            return l - r + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 6, 10, 9, 15};
        System.out.println(new Solution().findUnsortedSubarray(nums));
    }


}
