package zhy2002.leetcode.solutions.coinchange;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * <p>
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * <p>
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1]; //dp[i] = min # coins to get amount i
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int count = -1;
            for (int denomination : coins) {
                int remainingAmount = i - denomination;
                if (remainingAmount < 0)
                    break;
                if (dp[remainingAmount] != -1) {
                    if (count == -1 || count > dp[remainingAmount]) {
                        count = dp[remainingAmount];
                    }
                }
            }
            dp[i] = count == -1 ? -1 : count + 1;
        }
        return dp[amount];
    }
}
