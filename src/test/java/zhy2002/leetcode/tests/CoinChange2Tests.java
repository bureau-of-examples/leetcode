package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/coin-change/#/description
 */
public class CoinChange2Tests {

    @Test
    public void test() {
        Solution2 solution = new Solution2();
        assertThat(solution.coinChange(new int[]{1, 2, 5, 10}, 14), equalTo(3));
        assertThat(solution.coinChange(new int[]{1, 2, 5}, 10), equalTo(2));
        assertThat(solution.coinChange(new int[]{1, 2, 5}, 11), equalTo(3));
    }

    public class Solution {
        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            int[][] dp = new int[amount + 1][coins.length + 1];
            for (int j = 0; j <= coins.length; j++) {
                dp[0][j] = 0;
            }
            for (int i = 1; i <= amount; i++) {
                dp[i][0] = -1;
            }

            for (int i = 1; i <= amount; i++) {
                for (int j = 1; j <= coins.length; j++) {
                    int minRequired = -1;
                    int value = 0;
                    while (value <= i) {
                        int diff = i - value;
                        int need = dp[diff][j - 1];
                        if (need >= 0) {
                            need += value / coins[j - 1];
                            if (minRequired == -1 || minRequired > need) {
                                minRequired = need;
                            }
                        }
                        value += coins[j - 1];
                    }
                    dp[i][j] = minRequired;
                }
            }
            return dp[amount][coins.length];
        }
    }

    public class Solution2 {
        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);

            int[] dp = new int[amount + 1]; //dp[i] = min # of coins to get i
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                int minRequired = -1;
                for (int denom : coins) {
                    int remaining = i - denom;
                    if (remaining < 0)
                        break;
                    if (dp[remaining] == -1)
                        continue;

                    if (minRequired == -1 || minRequired > dp[remaining] + 1) {
                        minRequired = dp[remaining] + 1;
                    }
                }
                dp[i] = minRequired;
            }
            return dp[amount];
        }
    }
}
