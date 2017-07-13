package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/coin-change-2/#/description
 */
public class CoinChangeIITests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.change(5, new int[]{1, 2, 5}), equalTo(4));
    }

    public class Solution {
        public int change(int amount, int[] coins) {
            Arrays.sort(coins);
            int[][] dp = new int[amount + 1][coins.length + 1];
            for (int j = 0; j <= coins.length; j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i <= amount; i++) {
                dp[i][0] = 0;
            }
            for (int i = 1; i <= amount; i++) {
                for (int j = 1; j <= coins.length; j++) {
                    int totalWays = 0;
                    int value = 0;
                    while (value <= i) {
                        totalWays += dp[i - value][j - 1];
                        value += coins[j - 1];
                    }
                    dp[i][j] = totalWays;
                }
            }

            return dp[amount][coins.length];
        }
    }
}
