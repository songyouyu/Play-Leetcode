import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author youyu.song
 * @date 2019/12/10 15:30
 */
public class Solution {

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *
     * 示例 2:
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     * 说明：
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Integer key : hashMap.keySet()) {
            arrayList.add(key);
        }
        Collections.sort(arrayList, (a, b) -> {
            if (hashMap.get(a) != hashMap.get(b)) {
                return hashMap.get(b) - hashMap.get(a);
            }
            return a - b;

        });

        return arrayList.subList(0, k);
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,1,2,2};
        int k = 2;
        System.out.println(new Solution().topKFrequent(nums, k));
    }

}
