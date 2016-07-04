package zhy2002.leetcode.solutions.countnumberswithuniquedigits;

/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        if (n <= 0)
            return 0;
        int effectiveN = Math.min(n, 10);
        int[] dp = new int[effectiveN]; //dp[i] = count of numbers with unique (i+1) digits
        dp[0] = 10; //0 to 9
        int lastVal = 9;
        int current = 9;
        for (int i = 1; i < effectiveN; i++) {
            dp[i] = lastVal * current;
            lastVal = dp[i];
            current--;
        }
        int sum = 0;
        for (int num : dp) {
            sum += num;
        }
        return sum;
    }
}
