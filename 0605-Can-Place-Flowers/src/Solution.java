/**
 * @author youyu.song
 * @date 2020/6/20 9:34
 */
public class Solution {

    /**
     * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
     * 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
     *
     * 输入: flowerbed = [1,0,0,0,1], n = 2
     * 输出: False
     *
     * 注意:
     * 数组内已种好的花不会违反种植规则。
     * 输入的数组长度范围为 [1, 20000]。
     * n 是非负整数，且不会超过输入数组的大小。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/can-place-flowers
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // https://leetcode-cn.com/problems/can-place-flowers/comments/444537
        int len = flowerbed.length;
        if (n == 0) {
            return true;
        }

        int l = 0;
        while (l < len) {
            if (flowerbed[l] == 1) {
                // 1 0 x
                l += 2;
            } else if ((l == len - 1) || (flowerbed[l + 1] == 0)) {
                // 1 0 0 || 1 0 0 0 x
                n --;
                l += 2;
            } else {
                // 0 1 x x
                l += 3;
            }
        }

        return n <= 0;
    }

}
