import java.util.Arrays;

/**
 * @author songyouyu
 * @date 2023/1/27 10:25
 */
public class Solution {

    /**
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
     *
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     *
     * 链接：https://leetcode.cn/problems/sorted-merge-lcci
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (B[j] >= A[i]) {
                A[k] = B[j];
                k --;
                j --;
            } else {
                A[k] = A[i];
                k --;
                i --;
            }
        }
        // B 可能仍有数据，B 中有元素小于 A 中最小值
        while (j >= 0) {
            A[k] = B[j];
            k --;
            j --;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 7, 8, 0, 0, 0};
        int[] b = {2, 5, 6};
        new Solution().merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }

}
