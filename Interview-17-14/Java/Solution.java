import java.util.Arrays;

/**
 * @author songyouyu
 * @date 2023/3/1 21:27
 */
public class Solution {

    /**
     * https://leetcode.cn/problems/smallest-k-lcci/
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] smallestK(int[] arr, int k) {
        int len = arr.length;
        if (k == 0) {
            return new int[]{};
        }
        if (len <= k) {
            return arr;
        }

        // len > k
        quickSort(arr, 0, len - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i ++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void quickSort(int[] arr, int l , int r, int k) {
        int p = partition(arr, l, r);
        if (p == k -1) {
            return;
        } else if (p < k - 1) {
            quickSort(arr, p + 1, r, k);
        } else {
            quickSort(arr, l , p - 1, k);
        }
    }

    private int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i ++) {
            if (arr[i] < v) {
                swap(arr, ++j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        System.out.println(Arrays.toString(new Solution().smallestK(arr, 4)));
    }

}
