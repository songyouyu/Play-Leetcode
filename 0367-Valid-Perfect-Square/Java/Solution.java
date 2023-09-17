public class Solution {
    
    /**
     * https://leetcode.cn/problems/valid-perfect-square/
     * 
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int l = 0;
        int r = num;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            int tmp = num / mid;
            // mid 和 tmp 此消彼长
            if (tmp == mid) {
                if (tmp * mid == num) {
                    return true;
                }
                l = mid + 1;
            } else if (tmp < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(2147483647));
    }

}