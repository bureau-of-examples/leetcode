package zhy2002.leetcode.solutions.besttimetobuyandsellstockiv;

/**
 * The basic idea is the same as the TLE solution, however there is one more optimization to make.
 * Define p[i][j] as the max profit achievable if trade from day 0 to day j, making at most i transactions
 * Then p[i][j] =
 * 1) Last sell before day j - the max profit is the same as p[i][j-1].
 * 2) Last sell on day j - then the max profit is:
 * L[i][j] = max(
 *  p[i-1][0]+price[j]-price[0], //the last trade is buy on day 0 and sell on day j
 *  p[i-1][1]+price[j]-price[1], //the last trade is buy on day 1 and sell on day j
 *  p[i-1][2]+price[j]-price[2], //the last trade is buy on day 2 and sell on day j
 *  ...
 *  p[i-1][j-1]+price[j]-price[j-1] //the last trade is buy on day j-1 and sell on day j
 *  )
 *
 *  Previously I calculated this L[i][j] in a loop, which is bad.
 *  Note that L[i][j-1] = max(
 *  p[i-1][0]+price[j-1]-price[0],
 *  p[i-1][1]+price[j-1]-price[1],
 *  p[i-1][2]+price[j-1]-price[2],
 *  ...
 *  p[i-1][j-2]+price[j-1]-price[j-2]
 *  )
 *  So we have (formula A):
 *  L[i][j-1] + price[j] - price[j-1] = max(
 *  p[i-1][0]+price[j]-price[0],
 *  p[i-1][1]+price[j]-price[1],
 *  p[i-1][2]+price[j]-price[2],
 *  ...
 *  p[i-1][j-2]+price[j]-price[j-2]
 *  )
 *  Now all we need to know is:
 *  p[i-1][j-1]+price[j]-price[j-1]
 *  Now we know L[i][j].
 *  
 *  The meaning of formula A is the max profit achievable when last sell on day j is 
 *  1) the max profit achievable when last buy before day j - 1 OR
 *  2) the max profit achievable when last buy on day j - 1
 *  last buy is on day j <=> last buy is before j
 *  The twist of this problem is it has double DP: the DP sub-problem can also solved by DP.
 */
public class ProperDpSolution implements Solution  {

    @Override
    public int maxProfit(int k, int[] prices) {

        if(k == 0 || prices.length == 0)
            return 0;

        if(k<<1 >= prices.length) {
            return maxProfitUnlimitedK(prices);
        }

        int[] p = new int[prices.length]; //1d dp
        int[] L = new int[prices.length];

        for(int i=1; i<=k; i++){
            int newPreviousP = 0;
            for(int j=1; j<prices.length; j++){
                int delta = prices[j] - prices[j-1];
                L[j] = Math.max(p[j-1], L[j-1]) + delta;
                p[j-1] = newPreviousP;
                newPreviousP = Math.max(p[j-1], L[j]);
            }
            p[p.length - 1] = newPreviousP;
        }

        return p[p.length - 1];
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
}
