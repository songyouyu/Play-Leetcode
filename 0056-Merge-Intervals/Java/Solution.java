import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author songyouyu
 * @date 2023/1/27 11:40
 */
public class Solution {

    /**
     * @see :https://leetcode.cn/problems/merge-intervals
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);

        int len = intervals.length;
        for (int i = 1; i < len; i ++) {
            int[] cur = intervals[i];
            int[] last = list.getLast();
            if (cur[0] <= last[1]) {
                last[1] = Math.max(cur[1], last[1]);
            } else {
                list.add(cur);
            }
        }

        return list.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        //int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr = {{1, 3}, {0, 3}};
        new Solution().merge(arr);
    }

}
