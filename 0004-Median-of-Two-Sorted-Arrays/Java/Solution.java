/**
 * @author youyu.song
 * @date 2020/5/23 11:22
 */
public class Solution {

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空。
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * 则中位数是 (2 + 3)/2 = 2.5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //int nums1Len = nums1.length;
        //int nums2Len = nums2.length;
        //int resultLen = nums1Len + nums2Len;
        //int[] result = new int[resultLen];
        //
        //int i = 0, j = 0, k = 0;
        //while (i < nums1Len && j < nums2Len) {
        //    if (nums1[i] <= nums2[j]) {
        //        result[k] = nums1[i];
        //        k ++;
        //        i ++;
        //    } else {
        //        result[k] = nums2[j];
        //        k ++;
        //        j ++;
        //    }
        //}
        //
        //while (i < nums1Len) {
        //    result[k] = nums1[i];
        //    k ++;
        //    i ++;
        //}
        //while (j < nums2Len) {
        //    result[k] = nums2[j];
        //    k ++;
        //    j ++;
        //}
        //
        //return (double) (result[(resultLen - 1) / 2] + result[resultLen / 2]) / 2;


        // https://blog.csdn.net/chen_xinjia/article/details/69258706
        int nums1Len = nums1.length;
        int nums2Len = nums2.length;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        // 保证 nums1 是较短的数组
        if (nums1Len > nums2Len) {
            return findMedianSortedArrays(nums2, nums1);
        }
        // 其中一个数组为空, 则直接计算另一个数组中的值.
        if (nums1Len == 0) {
            return (double) (nums2[(nums2Len - 1) / 2] + nums2[nums2Len / 2]) / 2;
        }
        int cutL = 0, cutR = nums1Len;
        // cutNums1, cutNums2 分别是数组1 数组2左边的元素的个数。
        int cutNums1 = nums1Len / 2;
        int cutNums2;
        while (cutNums1 <= nums1Len) {
            cutNums1 = (cutR - cutL) / 2 + cutL;
            cutNums2 = (nums1Len + nums2Len) / 2 - cutNums1;

            double L1 = (cutNums1 == 0) ? min : nums1[cutNums1 - 1];
            double L2 = (cutNums2 == 0) ? min : nums2[cutNums2 - 1];
            double R1 = (cutNums1 == nums1Len) ? max : nums1[cutNums1];
            double R2 = (cutNums2 == nums2Len) ? max : nums2[cutNums2];

            if (L1 > R2) {
                cutR = cutNums1 - 1;
            } else if (L2 > R1) {
                cutL = cutNums1 + 1;
            } else {
                if ((nums1Len + nums2Len) % 2 == 0) {
                    double a = Math.max(L1, L2);
                    double b = Math.min(R1, R2);
                    return (a + b) / 2;
                } else {
                    return Math.min(R1, R2);
                }

            }

        }

        return  -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }

}
