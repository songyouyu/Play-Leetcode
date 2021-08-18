import java.util.HashSet;

/**
 * @author youyu.song
 * @date 2019/3/23
 */
public class Solution {

    /**
     * 编写一个算法来判断一个数是不是“快乐数”。
     *
     * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
     * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
     * 如果可以变为 1，那么这个数就是快乐数。
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }

        HashSet<Integer> set = new HashSet<>();
        int tmp;
        int newN;

        // 避免出现死循环
        while (n > 0 && ! set.contains(n)) {
            set.add(n);
            newN = 0;
            while (n > 0) {
                // 从个位依次取数
                tmp = n % 10;
                n /= 10;
                newN += tmp * tmp;
            }

            n = newN;
        }

        return n == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 19;
        boolean b = solution.isHappy(n);
        System.out.println(b);
    }
}
