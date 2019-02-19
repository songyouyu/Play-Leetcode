/**
 * @author youyusong
 * @date 2019/1/14
 */
public class Solution {

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 给定 nums = [1,1,1,2,2,3],
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        int count = 1;

        for (int j = 1; j < nums.length; j ++) {
            if (nums[j] == nums[j - 1] && count < 2) {
                i ++;
                nums[i] = nums[j];
                count ++;
            } else if (nums[j] != nums[j - 1]) {
                i ++;
                nums[i] = nums[j];
                count = 1;
            }
        }

        return i + 1;

//        int k = 0;
//        for (int i = 0; i < nums.length; i ++) {
//            if (k < 2 || nums[i] != nums[k - 2]) {
//                nums[k] = nums[i];
//                k ++;
//            }
//        }
//        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        Solution solution = new Solution();
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
    }

}
