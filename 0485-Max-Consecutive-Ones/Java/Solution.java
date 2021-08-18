/**
 * @author youyusong
 * @date 2018/11/23
 */
public class Solution {

    /**
     * 给定一个二进制数组， 计算其中最大连续 1 的个数。
     * 输入的数组只包含 0 和 1。
     * 输入数组的长度是正整数，且不超过 10,000。
     *
     * 输入: [1, 1, 0, 1, 1, 1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int one = 0;
        for (int i : nums) {
            if ( i == 1) {
                one ++;
            } else {
                one = 0;
            }
            max = Math.max(max, one);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,0,1,1, 0, 1};
        int n = solution.findMaxConsecutiveOnes(nums);
        System.out.println(n);
    }

}
