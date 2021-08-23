/**
 * @author songyouyu
 * @date 2021/8/23
 */
public class Solution {

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j --;
                continue;
            }
            if (matrix[i][j] < target) {
                i ++;
            }
        }

        return false;
    }

}
