import java.util.*;

/**
 * @author youyu.song
 * @date 2019/3/16
 */
public class Solution {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2,2]
     *
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
     * 我们可以不考虑输出结果的顺序。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i ++;
            } else if (nums1[i] > nums2[j]) {
                j ++;
            } else {
                list.add(nums1[i]);
                i ++;
                j ++;
            }
        }

        int[] result = new int[list.size()];
        for (int k = 0; k < list.size(); k ++) {
            result[k] = list.get(k);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2,2};
        int[] result = solution.intersect(nums1, nums2);
        for (int i = 0; i < result.length; i ++) {
            System.out.print(result[i] + " ");
        }
    }

}
