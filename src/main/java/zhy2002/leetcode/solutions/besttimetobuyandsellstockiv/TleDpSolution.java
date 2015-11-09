package zhy2002.leetcode.solutions.besttimetobuyandsellstockiv;

/*
 * This solution works but is not optimal. See ProperDpSolution.
 * Time complexity is O(k*^2).
 */
public class TleDpSolution implements Solution {
    /**
     * It's all about categorization.
     * How to divide sub-problems?
     * - profit[i][j] is the maximum profit when trade day range is [0, j] and allow at most i transactions.
     * How to solve a sub-problem profit[i][j]?
     * - All the possible legal trading ways can be divided into two categories:
     * 1) (last) Sell on day j - then can categorized into last buy on day j, last buy on day j-1, ...., last buy on day 0;
     *      assume the last buy day is r, then the solution is: profit[i-1][r]+prices[j]-prices[i]
     * 2) Don't sell on day j, that is the last possible sell day is j-1 therefore the solution is profit[i][j-1].
     *
     * Formally we have:
     * plain implementation: profit[i][j] = max {
     *  profit[i][j-1] //i transactions til day j-1 //last transaction finish before today
     *  max_r(profit[i-1][r] + prices[j] - price[r]) where 0 <= r <= j //last transaction finish today
     * }
     */
    public int maxProfit(int k, int[] prices) {
        if(k == 0 || prices.length == 0)
            return 0;

        if(k<<1 >= prices.length) {
            return maxProfitUnlimitedK(prices);
        }
        int[][] profit = new int[2][prices.length]; //profit[i][j] max profit earned if we trade until day j and is allowed at most i transactions
        for (int i = 1; i <= k; i++) {//profit === 0 when i == 0
            int currentRow = i % 2;
            int lastRow = (currentRow - 1 + 2) % 2;

            for (int j = 1; j < prices.length; j++) {//profit === 0 when j == 0
                int previousDay = profit[currentRow][j - 1]; //max profit earned on previous day (discard today)
                //max profit earned today with (i-1) + 1 trades
                int today = profit[lastRow][j];
                for (int r = j - 1; r >= 0; r--) {
                    int maxRJ = profit[lastRow][r] + prices[j] - prices[r];//do at most i-1 trades in day [0, r] and one last trade buy on day r and sell on day j
                    if (maxRJ > today)//why buy day r and sell day j? because buy any other day t > r is already examined
                        today = maxRJ;
                }
                profit[currentRow][j] = Math.max(previousDay, today);
            }
        }
        return profit[k%2][prices.length - 1];
    }

    private int maxProfitUnlimitedK(int[] prices) {
        int result = 0;
        for(int i=1; i<prices.length; i++){
            int diff = prices[i] - prices[i-1];
            if(diff > 0){
                result += diff;
            }
        }
        return result;
    }

//    Plain version (no memory optimization):
//    public int maxProfit(int k, int[] prices) {
//        if(prices.length == 0)
//            return 0;
//
//        int[][] profit = new int[k + 1][prices.length]; //profit[i][j] max profit earned if we trade until day j and is allowed at most i transactions
//        for (int i = 1; i <= k; i++) {//profit === 0 when i == 0
//            for (int j = 1; j < prices.length; j++) {//profit === 0 when j == 0
//                int previousDay = profit[i][j - 1]; //max profit earned on previous day (discard today)
//                //max profit earned today with (i-1) + 1 trades
//                int today = profit[i - 1][j];
//                for (int r = j - 1; r >= 0; r--) {
//                    int maxRJ = profit[i - 1][r] + prices[j] - prices[r];//do at most i-1 trades in day [0, r] and one last trade buy on day r and sell on day j
//                    if (maxRJ > today)//why buy day r and sell day j? because buy any other day t > r is already examined
//                        today = maxRJ;
//                }
//                profit[i][j] = Math.max(previousDay, today);
//            }
//        }
//        return profit[k][prices.length - 1];
//    }
}
