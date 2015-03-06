package zhy2002.leetcode.solutions.besttimetobuyandsellstockiii;


public class Solution {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0)
            return 0;

        int[] maxToI = new int[prices.length];

        maxToI[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int dayProfit = maxToI[i - 1] + prices[i] - prices[i - 1];
            maxToI[i] = dayProfit > 0 ? dayProfit : 0;//max profit sell on day i
        }
        for (int i = 1; i < prices.length; i++) {//max profit sell on or before day i
            if (maxToI[i] < maxToI[i - 1])
                maxToI[i] = maxToI[i - 1];
        }

        int[] maxFromI = new int[prices.length];
        maxFromI[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            int dayProfit = prices[i + 1] - prices[i] + maxFromI[i + 1];
            maxFromI[i] = dayProfit > 0 ? dayProfit : 0; //max profit buy on day i
        }
        for (int i = prices.length - 2; i >= 0; i--) {
            if (maxFromI[i] < maxFromI[i + 1])
                maxFromI[i] = maxFromI[i + 1];//max profit buy on or after day i
        }

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int maxI = maxToI[i] + maxFromI[i];
            if (maxI > max)
                max = maxI;
        }
        return max;
    }

}
