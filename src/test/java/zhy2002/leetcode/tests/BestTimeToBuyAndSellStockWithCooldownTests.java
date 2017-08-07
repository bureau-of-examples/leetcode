package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/
 */
public class BestTimeToBuyAndSellStockWithCooldownTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.maxProfit(new int[]{1, 2, 3, 0, 2}), equalTo(3));
    }

    public class Solution {
        public int maxProfit(int[] prices) {
            int[] sell = new int[prices.length];
            int[] buy = new int[prices.length];
            buy[0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
                buy[i] = Math.max(buy[i - 1], (i - 2 >= 0 ? sell[i - 2] : 0) - prices[i]);
            }
            return sell[prices.length - 1];
        }
    }
}
