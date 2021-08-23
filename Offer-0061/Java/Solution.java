/**
 * @author songyouyu
 * @date 2021/8/22
 */
public class Solution {

    /**
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
     * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        int[] exist = new int[14];
        int max = -1;
        int min = 14;

        for (int i = 0; i < 5; i ++) {
            if (nums[i] != 0) {
                if (exist[nums[i]] != 0) {
                    return false;
                } else {
                    exist[nums[i]] = 1;
                }
                if (nums[i] < min) {
                    min = nums[i];
                }
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }

        return max - min < 5;
    }

}
