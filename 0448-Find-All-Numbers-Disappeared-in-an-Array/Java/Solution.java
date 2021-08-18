import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author youyusong
 * @date 2018/11/21
 */
public class Solution {

    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            int index = num > 0 ? num : -num;
            index --;
            if (nums[index] > 0) {
                nums[index] = - nums[index];
            }
        }

        for (int i = 0; i < n; i ++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 2, 2, 3, 4, 5, 8};
        List<Integer> list = solution.findDisappearedNumbers(nums);
        System.out.println(list);
    }

}
