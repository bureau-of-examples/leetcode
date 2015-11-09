package zhy2002.leetcode.solutions.besttimetobuyandsellstockiv;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public interface Solution {

    int maxProfit(int k, int[] prices);
}
