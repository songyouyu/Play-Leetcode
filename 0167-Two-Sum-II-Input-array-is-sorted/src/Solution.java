/**
 * @author youyusong
 * @date 2018/12/11
 */
public class Solution {

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if (target == sum) {
                break;
            }
            if (sum < target) {
                i ++;
            }
            if (sum > target) {
                j --;
            }
        }

        return new int[]{i + 1, j + 1};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

}
