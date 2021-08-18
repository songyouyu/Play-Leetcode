import java.util.PriorityQueue;

/**
 * @author youyu.song
 * @date 2020/5/17 12:12
 */
public class Solution {

    /**
     * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
     * （这里，平面上两点之间的距离是欧几里德距离。）
     * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
     *
     * 输入：points = [[1,3],[-2,2]], K = 1
     * 输出：[[-2,2]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
     *
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
                (o1, o2) -> {
                    return sqrt2(o1) - sqrt2(o2);
                }
        );

        for (int i = 0; i < points.length; i ++) {
            queue.offer(points[i]);
        }

        int[][] res = new int[K][2];
        for (int i = 0; i < K; i ++) {
            res[i] = queue.poll();
        }

        return res;
    }

    private int sqrt2(int[] t) {
        return t[0] * t[0] + t[1] * t[1];
    }

}
