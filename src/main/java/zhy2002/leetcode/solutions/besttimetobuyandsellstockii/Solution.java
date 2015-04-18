package zhy2002.leetcode.solutions.besttimetobuyandsellstockii;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int change = prices[i] - prices[i - 1];
            if (change > 0)
                maxProfit += change;
        }
        return maxProfit;
    }

}
