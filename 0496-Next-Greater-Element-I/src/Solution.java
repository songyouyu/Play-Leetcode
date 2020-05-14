import java.util.ArrayList;
import java.util.List;

/**
 * @author youyu.song
 * @date 2020/5/14 10:02
 */
public class Solution {

    /**
     * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     * 找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     *
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     *
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-greater-element-i
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int nums2Len = nums2.length;

        for (int i = 0; i < nums1.length; i ++) {
            int pop = nums1[i];
            int j = 0;
            while (j < nums2Len) {
                if (nums2[j] == pop) {
                    break;
                }
                j ++;
            }
            if (j + 1 == nums2Len) {
                result.add(-1);
                continue;
            }
            while (j + 1 < nums2Len) {
                if (nums2[j + 1] > pop) {
                    result.add(nums2[j + 1]);
                    break;
                }
                j ++;
                if (j + 1 == nums2Len) {
                    result.add(-1);
                }
            }
        }

        int[] res = new int[result.size()];
        for (int k = 0; k < res.length; k ++) {
            res[k] = result.get(k);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] res = new Solution().nextGreaterElement(nums1, nums2);
        for (int i = 0; i < res.length; i ++) {
            System.out.print(res[i] + " ");
        }
    }

}
