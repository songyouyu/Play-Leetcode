/**
 * @author songyouyu
 * @date 2022/12/18
 */
public class Solution {

    /**
     * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。
     * 可以使用加号、减号、位移，但要吝啬一些。
     *
     * 链接：https://leetcode.cn/problems/recursive-mulitply-lcci/
     *
     * @param A
     * @param B
     * @return
     */
    public int multiply(int A, int B) {
        int a = Math.min(A, B);
        int b = Math.max(A, B);
        if (a == 1) {
            return b;
        }

        return sMultiply(a, b);
    }

    private int sMultiply(int a, int b) {
        if (a == 1) {
            return b;
        }
        int c = sMultiply(a / 2, b);
        if (a % 2 == 1) {
            return c + c + b;
        } else {
            return c + c;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply(3, 4));
    }

}
