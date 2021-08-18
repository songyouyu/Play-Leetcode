/**
 * @author youyu.song
 * @date 2020/6/6 10:34
 */
public class Solution {

    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     *
     * 输入: [3,0,1]
     * 输出: 2
     *
     * 算法应具有线性时间复杂度
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }

        return nums.length * (nums.length + 1) / 2 - sum;

        //int sum = 0;
        //int i;
        //for(i = 0; i < nums.length; i++){
        //    sum += nums[i] - i;
        //}
        //sum -= i;
        //return Math.abs(sum);
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(new Solution().missingNumber(nums));
    }

}
