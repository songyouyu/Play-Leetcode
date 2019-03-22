import java.util.HashMap;

/**
 * @author youyu.song
 * @date 2019/3/16
 */
public class Solution {

    /**
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
     * 使得 A[i] + B[j] + C[k] + D[l] = 0。
     *
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
     * 所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
     *
     * 输入:
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     * 输出:
     * 2
     * 解释:
     * 两个元组如下:
     * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     *
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len1 = A.length;
        int len2 = B.length;
        int len3 = C.length;
        int len4 = D.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len1; i ++) {
            for (int j = 0; j < len2; j ++) {
                int sum = A[i] + B[j];
                if (hashMap.containsKey(sum)) {
                    hashMap.put(sum, hashMap.get(sum) + 1);
                } else {
                    hashMap.put(sum, 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len3; i ++) {
            for (int j = 0; j < len4; j ++) {
                if (hashMap.containsKey(-C[i] - D[j])) {
                    res += hashMap.get(-C[i] - D[j]);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};
        int count = solution.fourSumCount(A, B, C, D);
        System.out.println(count);
    }

}
