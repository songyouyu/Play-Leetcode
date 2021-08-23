import java.util.ArrayList;
import java.util.List;

/**
 * @author songyouyu
 * @date 2021/8/23
 */
public class Solution {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *
     * 链接：https://leetcode-cn.com/problems/spiral-matrix
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;

        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j ++) {
                result.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= bottom; i ++) {
                result.add(matrix[i][right]);
            }
            // 当 top == bottom 且只有最后一行元素时，会重复打印
            if (top != bottom) {
                for (int j = right - 1; j >= left; j --) {
                    result.add(matrix[bottom][j]);
                }
            }
            // 当 left == right 且只有最后一列元素时，会重复打印
            if (left != right) {
                for (int i = bottom - 1; i > top; i --) {
                    result.add(matrix[i][left]);
                }
            }

            left ++;
            right --;
            top ++;
            bottom --;
        }

        return result;
    }

}
