package zhy2002.leetcode.solutions.besttimetobuyandsellstock;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Calculate the max of max profit if selling at day i.
 */
public class Solution {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int[] deltas = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            deltas[i - 1] = prices[i] - prices[i - 1];//price change on day i
        }

        int maxProfit = 0;
        int maxProfitSellAtJ = 0;
        for (int j = 0; j < deltas.length; j++) {
            maxProfitSellAtJ = maxProfitSellAtJ + deltas[j];
            if (maxProfitSellAtJ < 0)
                maxProfitSellAtJ = 0;
            else {
                if (maxProfitSellAtJ > maxProfit)
                    maxProfit = maxProfitSellAtJ;
            }
        }

        return maxProfit;
    }
}
