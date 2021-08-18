/**
 * @author youyusong
 * @date 2018/12/11
 */
public class Solution {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     *
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     *
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     *
     * 要求使用空间复杂度为 O(1) 的原地算法。
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (k == 0) {
            return;
        }
        int len = nums.length;
        k = k % len;
        int i = len - k;
        for (int j = 0; j < k; j ++) {
            int tmp = nums[i];
            for (int l = i; l > j; l --) {
                nums[l] = nums[l - 1];
            }
            nums[j] = tmp;
            i ++;
        }
    }

    /**
     * 翻转
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate_2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }


    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        //int[] nums = {1,2,3,4,5,6,7};
        int[] nums = {-1, -100, 3, 99};
        new Solution().rotate(nums, 2);
        for (int i = 0; i < nums.length; i ++) {
            System.out.print(nums[i] + " ");
        }
    }

}
