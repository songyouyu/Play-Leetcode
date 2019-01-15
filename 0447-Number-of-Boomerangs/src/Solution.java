import java.util.HashMap;

/**
 * @author youyusong
 * @date 2019/1/14
 */
public class Solution {

    /**
     * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，
     * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
     *
     * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
     *
     * 输入:
     * [[0,0],[1,0],[2,0]]
     * 输出:
     * 2
     * 解释:
     * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
     *
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;

        for (int i = 0; i < points.length; i ++) {
            HashMap<Integer, Integer> map = new HashMap<>(16);
            for (int j = 0; j < points.length; j ++) {
                if (j != i) {
                    int dis = dis(points[i], points[j]);
                    if (! map.containsKey(dis)) {
                        map.put(dis, 1);
                    } else {
                        // 只有 value = 2 时，才可能会有答案
                        map.put(dis, map.get(dis) + 1);
                    }
                }
            }

            for (Integer item : map.keySet()) {
                // 若只出现 1 次，则 1 - 1 = 0，所以不用判断 value 是否大于等于 2
                res += map.get(item) * (map.get(item) - 1);
            }
        }

        return res;
    }

    private int dis(int[] pa, int[] pb) {
        // x^2 + y^2, 不开根号，这样不会有浮点值
        return (pa[0] - pb[0]) * (pa[0] - pb[0]) + (pa[1] - pb[1]) * (pa[1] - pb[1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{0,0},{1,0},{2,0}};
        int i = solution.numberOfBoomerangs(points);
        System.out.println(i);
    }
}
