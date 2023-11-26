public class Solution {
    
    /**
     * https://leetcode.cn/problems/sqrtx/
     * 
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 0; 
        int r = x;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (x / mid < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147483647));
    }

}
