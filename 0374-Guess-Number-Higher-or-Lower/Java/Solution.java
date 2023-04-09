/**
 * @author songyouyu
 * @date 2023/4/9 19:19:19
 */
public class Solution extends GuessGame {

    /**
     * https://leetcode.cn/problems/guess-number-higher-or-lower/
     * @param n
     * @return
     */
    public int guessNumber(int n) {
        int l = 0;
        int r = n;
        int mid = l + (r - l) / 2;

        while (guess(mid) != 0) {
            mid = l + (r - l) / 2;
            if (guess(mid) == 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return mid;
    }

}
