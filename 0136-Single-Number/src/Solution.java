import java.util.HashMap;

/**
 * @author youyusong
 * @date 2018/12/26
 */
public class Solution {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     *
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (! map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }

        throw new IllegalArgumentException("此数组中没有只出现一次的元素");
    }

}
