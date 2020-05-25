import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author youyu.song
 * @date 2020/5/25 14:39
 */
public class Solution {


    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 输入: 3
     * 输出: [1,3,3,1]
     *
     *            [1],
     *           [1,1],
     *          [1,2,1],
     *         [1,3,3,1],
     *        [1,4,6,4,1]
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        //List<List<Integer>> res = new ArrayList<>();
        //
        //for (int i = 0; i < rowIndex + 1; i ++) {
        //    List<Integer> list = new ArrayList<>();
        //    list.add(1);
        //    for (int j = 0; j < i - 1; j ++) {
        //        list.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
        //    }
        //    if (i != 0) {
        //        list.add(1);
        //    }
        //
        //    res.add(list);
        //}
        //
        //return res.get(rowIndex);

        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp,1);
        for (int i = 2; i < dp.length; i ++) {
            for (int j = i - 1; j > 0; j --)
                dp[j] = dp[j] + dp[j - 1];
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(0));
    }

}
