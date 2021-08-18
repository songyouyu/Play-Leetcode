import java.util.ArrayList;
import java.util.List;

/**
 * @author youyu.song
 * @date 2020/5/21 14:22
 */
public class Solution {

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/pascals-triangle
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }

        for (int i = 0; i < numRows; i ++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 0; j < i - 1; j ++) {
                list.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            if (i != 0) {
                list.add(1);
            }

            res.add(list);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(5));
    }

}
