/**
 * @author youyu.song
 * @date 2020/6/14 9:35
 */
public class Solution {

    /**
     * 在 MATLAB 中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
     * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
     * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     * 输入:
     * nums =
     * [[1,2],
     *  [3,4]]
     * r = 1, c = 4
     * 输出:
     * [[1,2,3,4]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
     *
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0) {
            return nums;
        }
        int row = nums.length;
        int column = nums[0].length;

        if (row * column != r * c) {
            return nums;
        }

        //int[] res = new int[row * column];
        //int k = 0;
        //for (int i = 0; i < row; i ++) {
        //    for (int j = 0; j < column; j ++) {
        //        res[k] = nums[i][j];
        //        k ++;
        //    }
        //}
        //
        //int[][] newNums = new int[r][c];
        //int m = 0;
        //for (int i = 0; i < r; i ++) {
        //    for (int j = 0; j < c; j ++) {
        //        newNums[i][j] = res[m];
        //        m ++;
        //    }
        //}
        //
        //return newNums;

        int[][] newNums = new int[r][c];
        int rIndex = 0;
        int cIndex = 0;
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < column; j ++) {
                newNums[rIndex][cIndex] = nums[i][j];
                cIndex ++;
                if (cIndex == c) {
                    rIndex ++;
                    cIndex = 0;
                }
            }
        }

        return newNums;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;
        int[][] res = new Solution().matrixReshape(nums, r, c);
        int i = 0;
    }

}
