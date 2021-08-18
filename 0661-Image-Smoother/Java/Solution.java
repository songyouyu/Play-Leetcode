/**
 * @author youyu.song
 * @date 6/28/2020 09:29
 */
public class Solution {

    /**
     * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
     * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
     *
     * 示例 1:
     * 输入:
     * [[1,1,1],
     *  [1,0,1],
     *  [1,1,1]]
     * 输出:
     * [[0, 0, 0],
     *  [0, 0, 0],
     *  [0, 0, 0]]
     * 解释:
     * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
     * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
     * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
     *
     * 注意:
     * 给定矩阵中的整数范围为 [0, 255]。
     * 矩阵的长和宽的范围均为 [1, 150]。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/image-smoother
     * @param M
     * @return
     */
    public int[][] imageSmoother(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return M;
        }

        int m = M.length;
        int n = M[0].length;
        int[][] res = new int[m][n];
        int[][] d = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

        for (int x = 0; x < m; x ++) {
            for (int y = 0; y < n; y ++) {
                int sum = M[x][y];
                int all = 1;
                for (int i = 0; i < 8; i ++) {
                    int newX = x + d[i][0];
                    int newY = y + d[i][1];
                    if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                        continue;
                    }
                    all ++;
                    sum += M[newX][newY];
                }
                res[x][y] = sum / all;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        new Solution().imageSmoother(nums);
        int i = 1;
    }

}
