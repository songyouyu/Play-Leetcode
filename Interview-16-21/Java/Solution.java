import java.util.HashSet;

public class Solution {
    
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0;
        for (int i = 0; i < array1.length; i ++) {
            sum1 += array1[i];
        }
        int sum2 = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < array2.length; i ++) {
            sum2 += array2[i];
            hashSet.add(array2[i]);
        }
        if ((sum1 + sum2) % 2 == 1) {
            return new int[]{};
        }
        int sum = (sum1 + sum2) / 2;
        int diff = sum - sum1;
        for (int i = 0; i < array1.length; i ++) {
            int target = array1[i] + diff;
            if (hashSet.contains(target)) {
                return new int[]{array1[i], target};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] array1 = {4, 1, 2, 1, 1, 2};
        int[] array2 = {3,6,3,3};
        new Solution().findSwapValues(array1, array2);
    }
    
}
