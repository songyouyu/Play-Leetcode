import java.util.*;

/**
 * @author youyu.song
 * @date 2020/6/11 9:16
 */
public class Solution {

    /**
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
     * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     *
     * 输入: [3, 1, 4, 1, 5], k = 2
     * 输出: 2
     * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     *
     * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
     * 数组的长度不超过10,000。
     * 所有输入的整数的范围在 [-1e7, 1e7]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/k-diff-pairs-in-an-array
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if (k < 0 || nums.length == 0) {
            return 0;
        }

        //HashSet<Integer> set = new HashSet<>();
        //for (int i = 0; i < nums.length; i ++) {
        //    for (int j = i + 1; j < nums.length; j ++) {
        //        if (Math.abs(nums[i] - nums[j]) == k) {
        //            set.add(nums[i] + nums[j]);
        //        }
        //    }
        //}
        //
        //return set.size();

        Arrays.sort(nums);
        int res = 0;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            int num = nums[right] - nums[left];
            if (num < k) {
                right ++;
            } else if (num > k) {
                left ++;
            } else {
                res ++;
                left ++;
                right ++;
            }
            while (left > 0 && left < nums.length && nums[left] == nums[left - 1]) {
                left ++;
            }
            while (right > 0 && right < nums.length && nums[right] == nums[right - 1]) {
                right ++;
            }
            if (right <= left) {
                right = left + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 1};
        System.out.println(new Solution().findPairs(nums, 1));
    }

}
