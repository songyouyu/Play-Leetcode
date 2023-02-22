import java.util.Arrays;

/**
 * @author songyouyu
 * @date 2023/2/22 21:05
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return nums;
        }
        int i = 0;
        int j = len -1;
        while (i < j) {
            while (i < j && nums[i] % 2 != 0) {
                i ++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j --;
            }
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        System.out.println(Arrays.toString(new Solution().exchange(nums)));
    }

}
