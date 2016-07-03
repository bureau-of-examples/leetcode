package zhy2002.leetcode.additional.makechange;

/**
 * CCI question 8.7:
 * Calculate the number of ways to make change for amount cents.
 * Available denominations are 25, 10, 5, 1.
 */
public class Solution {

    public int calcWays(int amount) {
        return calcWays(amount, 25);
    }

    private int calcWays(int amount, int maxDenomination) {
        if (amount == 0 || maxDenomination == 1)
            return 1;
        int nextMax = nextDenomination(maxDenomination);
        int ways = 0;
        while (amount >= 0) {
            ways += calcWays(amount, nextMax);
            amount -= maxDenomination;
        }
        return ways;
    }

    private int nextDenomination(int denomination) {
        if (denomination == 25)
            return 10;
        if (denomination == 10)
            return 5;
        if (denomination == 5)
            return 1;
        throw new IllegalArgumentException("denomination");
    }
}
