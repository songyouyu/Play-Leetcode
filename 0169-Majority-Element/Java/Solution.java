import java.util.HashMap;
import java.util.Map;

/**
 * @author youyusong
 * @date 2018/12/11
 */
public class Solution {

    /**
     * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在众数。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            if (! map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for (Integer num : map.keySet()) {
            if (map.get(num) > n) {
                return num;
            }
        }

        throw new IllegalArgumentException("此数组中没有众数");


//        int majority = 0;
//        int count = 0;
//        for (int num : nums) {
//            if (count == 0) {
//                majority = num;
//            }
//            if (majority == num) {
//                count++;
//            } else {
//                count--;
//            }
//        }
//        return majority;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 2, 3};
        int result = solution.majorityElement(nums);
        System.out.println(result);
    }

}
