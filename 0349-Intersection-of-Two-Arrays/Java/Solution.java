import java.util.*;

/**
 * @author youyu.song
 * @date 2019/3/16
 */
public class Solution {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i ++;
            } else if (nums1[i] > nums2[j]) {
                j ++;
            } else {
                if (! map.containsKey(nums1[i])) {
                    list.add(nums1[i]);
                    map.put(nums1[i], 1);
                }
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
        int[] result = solution.intersection(nums1, nums2);
        for (int i = 0; i < result.length; i ++) {
            System.out.println(result[i]);
        }
    }

}
