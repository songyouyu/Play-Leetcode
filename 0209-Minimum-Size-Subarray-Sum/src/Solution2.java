/**
 * @author youyusong
 * @date 2019/1/14
 */
public class Solution2 {

    /**
     * 滑动窗口的另一种实现
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int n = nums.length;
        int sum = 0;
        int res = n + 1;

        while (r + 1 < n) {
            while (r + 1 < n && sum < s) {
                r ++;
                sum += nums[r];
            }

            if (sum > s) {
                res = Math.min(res, r - l + 1);
            }

            while (l < n && sum <= s) {
                sum -= nums[l];
                l ++;
                if (sum >= s) {
                    res = Math.min(res, r - l + 1);
                }
            }

        }

        if (res == n + 1) {
            return  0;
        } else {
            return res;
        }
    }

}
