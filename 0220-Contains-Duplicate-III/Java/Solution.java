import java.util.TreeSet;

/**
 * @author youyusong
 * @date 2019/1/15
 */
public class Solution {

    /**
     * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，
     * 使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
     *
     * 输入: nums = [1,2,3,1], k = 3, t = 0
     * 输出: true
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i ++) {
            if (treeSet.ceiling((long)nums[i] - (long)t) != null &&
                    treeSet.ceiling((long)nums[i] - (long)t) <= (long)nums[i] + (long)t) {
                return true;
            }

            treeSet.add((long)nums[i]);

            if (treeSet.size() == k + 1) {
                treeSet.remove((long)nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,1};
        int k = 3;
        int t = 0;
        boolean b = solution.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(b);
    }

}
