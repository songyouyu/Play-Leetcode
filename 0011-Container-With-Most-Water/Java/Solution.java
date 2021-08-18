/**
 * @author youyusong
 * @date 2019/2/19
 */
public class Solution {

    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 说明：你不能倾斜容器，且 n 的值至少为 2
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int l = 0, r = height.length - 1;
        int area = 0;

        while (l < r) {
            area = Math.max(area , Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l ++;
            } else {
                r --;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num = {1,8,6,2,5,4,8,3,7};
        int maxArea = solution.maxArea(num);
        System.out.println(maxArea);
    }

}
