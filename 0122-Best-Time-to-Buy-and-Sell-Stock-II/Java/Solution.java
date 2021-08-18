/**
 * @author youyu.song
 * @date 2020/5/28 10:01
 */
public class Solution {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 只要后一天的价格比前一天的大, 就卖出
        if (prices.length <= 1) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
