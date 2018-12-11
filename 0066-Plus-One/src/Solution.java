import java.util.Arrays;

/**
 * @author youyusong
 * @date 2018/11/16
 */
public class Solution {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1] ++;
        for (int i = n - 1; i >= 1; i --) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1] ++;
            }
        }

        if (digits[0] == 10) {
            digits[0] = 0;
            digits = Arrays.copyOf(digits, n + 1);
            for (int i = 0; i < digits.length - 1; i ++) {
                digits[i + 1] = 0;
            }
            digits[0] = 1;
        }

        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {9, 9, 1};
        int[] num = solution.plusOne(nums);
        for (int i = 0; i < num.length; i ++) {
            System.out.print(num[i] + " ");
        }
    }

}