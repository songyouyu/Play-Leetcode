public class Solution {
    
    /**
     * https://leetcode.cn/problems/peak-index-in-a-mountain-array/
     * 
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        int l = 0; 
        int r = len - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == 0 ) {
                return mid + 1;
            }
            if (mid == len - 1) {
                return mid - 1;
            }

            int num = arr[mid];
            if (arr[mid - 1] < num && arr[mid + 1] < num) {
                return mid;
            } else if (arr[mid - 1] > num && num > arr[mid + 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 6, 8, 4};
        System.out.println(new Solution().peakIndexInMountainArray(arr));
    }

}
