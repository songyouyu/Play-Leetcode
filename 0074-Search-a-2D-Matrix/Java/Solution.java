public class Solution {
    
    /**
     * https://leetcode.cn/problems/search-a-2d-matrix/
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] arr = new int[m * n];
        int k = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                arr[k] = matrix[i][j];
                k ++;
            }
        }

        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }

        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int midValue = matrix[mid / n][mid % n];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(new Solution().searchMatrix(arr, 60));
    }


}
