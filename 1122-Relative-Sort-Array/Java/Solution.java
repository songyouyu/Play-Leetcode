public class Solution {

    /**
     * https://leetcode.cn/problems/relative-sort-array/
     * 
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length];
        // 位图, 记录 arr1 中各个元素的个数
        int[] arr = new int[1000 + 1];
        for (int i : arr1) {
            arr[i]++;
        }
        int k = 0;
        // 遍历 arr2, 在 arr 中查找元素，依次添加到 res 中
        for (int i : arr2) {
            int count = arr[i];
            for (int j = 0; j < count; j++) {
                res[j + k] = i;
            }
            k = k + count;
            arr[i] = -1;
        }
        // 处理在 arr1 中且不在 arr2 中的元素
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] != -1 && arr[i] != 0) {
                int count = arr[i];
                for (int j = 0; j < count; j++) {
                    res[j + k] = i;
                }
                k = k + count;
            }
        }

        return res;
    }
    
}
