import java.util.*;

/**
 * @author youyusong
 * @date 2018/11/19
 */
public class Solution {

    /**
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     *
     * 输入: [2, 2, 3, 1]
     * 输出: 1
     * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
     * 存在两个值为2的数，它们都排第二。
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        // 排序去重
        int k = nums.length;
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            arr[i] = nums[k - 1];
            k --;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i ++) {
            if (! list.contains(arr[i])) {
                list.add(arr[i]);
            }
        }

        int n = list.size();

        if (n < 3) {
            if (n == 1) {
                return arr[0];
            } else {
                if (arr[0] > arr[1]) {
                    return arr[0];
                } else {
                    return arr[1];
                }
            }
        } else {
            return list.get(2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 3, 2, 3};
        int m = solution.thirdMax(nums);
        System.out.println(m);
    }
}
