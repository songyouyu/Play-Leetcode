/**
 * @author songyouyu
 * @date 2021/11/14
 */
public class Solution {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water/
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;

        int[] leftMax = new int[len];
        int max = 0;
        for (int i = 0; i < len; i ++) {
            leftMax[i] = Math.max(max, height[i]);
            max = leftMax[i];
        }

        int[] rightMax = new int[len];
        max = 0;
        for (int i = len - 1; i >= 0; i --) {
            rightMax[i] = Math.max(max, height[i]);
            max = rightMax[i];
        }

        int result = 0;
        for (int i = 1; i < len - 1; i ++) {
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] num = {4,2,0,3,2,5};
        System.out.println(new Solution().trap(num));
    }

}
