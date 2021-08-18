/**
 * @author youyusong
 * @date 2019/1/21
 */
public class Solution {

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
     * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * 注意:
     * 不能使用代码库中的排序函数来解决这道题。
     *
     * 输入: [2,0,2,1,1,0]
     * 输出: [0,0,1,1,2,2]
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] count = {0, 0, 0};

        for (int i = 0; i < nums.length; i ++) {
            count[nums[i]] ++;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i ++) {
            nums[index] = 0;
            index ++;
        }

        for (int i = 0; i < count[1]; i ++) {
            nums[index] = 1;
            index ++;
        }

        for (int i = 0; i < count[2]; i ++) {
            nums[index] = 2;
            index ++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,0,2,1,1,0};
        solution.sortColors(nums);

        for (int i = 0; i < nums.length; i ++) {
            System.out.print(nums[i] + " ");
        }

    }

}
