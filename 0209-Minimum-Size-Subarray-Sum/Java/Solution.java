/**
 * @author youyusong
 * @date 2019/1/14
 */
public class Solution {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
     * 如果不存在符合条件的连续子数组，返回 0
     *
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        // 初始化时，滑动窗口不包含任何元素
        int r = -1;
        int sum = 0;
        int n = nums.length;
        int res = n + 1;

        while (l < n) {
            if (r + 1 < n && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }

        // 没有找到连续的最小子数组
        if (res == n + 1) {
            return 0;
        } else {
            return res;
        }
    }

}
