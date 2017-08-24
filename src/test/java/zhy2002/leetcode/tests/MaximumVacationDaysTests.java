package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/maximum-vacation-days/description/
 */
public class MaximumVacationDaysTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.maxVacationDays(new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}}, new int[][]{{1, 3, 1}, {6, 0, 3}, {3, 3, 3}}),
                equalTo(12)
        );
    }

    class Solution {
        public int maxVacationDays(int[][] flights, int[][] days) {
            int n = flights.length;
            if (n == 0)
                return 0;
            int k = days[0].length;
            if (k == 0)
                return 0;

            int[][] dp = new int[n][k + 1]; //dp[i][j] = max vac days starting from city i on week j
            for (int j = k - 1; j >= 0; j--) {
                for (int i = 0; i < n; i++) {
                    int max = days[i][j] + dp[i][j + 1]; //default is stay at city i
                    for (int t = 0; t < n; t++) {
                        if (flights[i][t] == 1) {
                            max = Math.max(max, days[t][j] + dp[t][j + 1]);
                        }
                    }
                    dp[i][j] = max;
                }
            }
            return dp[0][0];
        }
    }

}
