/**
 * @author songyouyu
 * @date 2021/8/23
 */
public class Solution {

    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 链接：https://leetcode-cn.com/problems/rotate-image
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        // 上下旋转 + 以左上、右下对角线的对角旋转
        int m = matrix.length;

        for (int i = 0; i < m / 2; i ++) {
            for (int j = 0; j < m; j ++) {
                swap(matrix, i, j, m - 1 - i, j);
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < i; j ++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j, int p, int q) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = tmp;
    }

    public void rotate1(int[][] matrix) {
        // 原地旋转，先旋转最外圈，再旋转次外圈，以此类推
        int m = matrix.length;
        int s1_i = 0;
        int s1_j = 0;
        while (m > 1) {
            int s2_i = s1_i;
            int s2_j = s1_j + m - 1;
            int s3_i = s1_i + m - 1;
            int s3_j = s1_j + m - 1;
            int s4_i = s1_i + m - 1;
            int s4_j = s1_j;

            for (int n = 0; n < m - 1; n ++) {
                int p1_i = s1_i;
                int p1_j = s1_j + n;
                int p2_i = s2_i + n;
                int p2_j = s2_j;
                int p3_i = s3_i;
                int p3_j = s3_j - n;
                int p4_i = s4_i - n;
                int p4_j = s4_j;
                swap(matrix, p1_i, p1_j, p2_i, p2_j, p3_i, p3_j, p4_i, p4_j);
            }

            s1_i ++;
            s1_j ++;
            m = m - 2;
        }
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2, int i3, int j3, int i4, int j4) {
        int tmp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i4][j4];
        matrix[i4][j4] = matrix[i3][j3];
        matrix[i3][j3] = matrix[i2][j2];
        matrix[i2][j2] = tmp;
    }

}
