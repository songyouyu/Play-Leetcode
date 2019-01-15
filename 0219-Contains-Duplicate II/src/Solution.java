import java.util.HashMap;
import java.util.Map;

/**
 * @author youyusong
 * @date 2018/12/11
 */
public class Solution {

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，
     * 并且 i 和 j 的差的绝对值最大为 k。
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        boolean flag = false;

        for (int i = 0; i < nums.length; i ++) {
            if (! map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    flag = true;
                }
                map.put(nums[i], i);
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 0, 1, 1};
        boolean result = solution.containsNearbyDuplicate(nums, 1);
        System.out.println(result);
    }

}




