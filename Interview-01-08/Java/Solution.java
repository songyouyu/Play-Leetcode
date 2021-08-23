/**
 * @author songyouyu
 * @date 2021/8/22
 */
public class Solution {

    /**
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
     *
     * 输入：
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出：
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     *
     * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int column = matrix.length;
        int row = matrix[0].length;

        int[][] newMatrix = new int[column][row];
        for (int i = 0; i < column; i ++) {
            for (int j = 0; j < row; j ++) {
                newMatrix[i][j] = 1;
            }
        }

        for (int i = 0; i < column; i ++) {
            for (int j = 0; j < row; j ++) {
                if (matrix[i][j] == 0) {
                    newMatrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < column; i ++) {
            for (int j = 0; j < row; j ++) {
                if (newMatrix[i][j] == 0) {
                    for (int k = 0; k < row; k ++) {
                        matrix[i][k] = 0;
                    }
                    for (int m = 0; m < column; m ++) {
                        matrix[m][j] = 0;
                    }
                }
            }
        }
    }

}
