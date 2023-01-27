import java.util.Arrays;
import java.util.HashMap;

/**
 * @author songyouyu
 * @date 2023/1/27 10:48
 */
public class Solution {

    /**
     * 给你一个数字数组 arr 。
     *
     * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
     *
     * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
     *
     * 链接：https://leetcode.cn/problems/can-make-arithmetic-progression-from-sequence
     *
     * @param arr
     * @return
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length <= 2) {
            return true;
        }
        Arrays.sort(arr);

        int m = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i ++) {
            if (arr[i] - arr[i - 1] != m) {
                return false;
            }
        }
        return true;
    }

    public boolean canMakeArithmeticProgression2(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            if (a < min) {
                min = a;
            }
            if (a > max) {
                max = a;
            }
            map.merge(a, 1, Integer::sum);
        }
        if (min == max) {
            return true;
        }

        int len = arr.length;
        if ((max - min) % (len - 1) != 0 ) {
            return false;
        }
        // 公差
        int m = (max - min) / (len - 1);
        for (int i = min; i <= max; i += m) {
            if (map.get(i) == null || map.get(i) != 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,1, 2,2};
        System.out.println(new Solution().canMakeArithmeticProgression2(arr));
    }

}
