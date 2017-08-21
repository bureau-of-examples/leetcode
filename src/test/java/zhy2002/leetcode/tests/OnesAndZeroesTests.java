package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/ones-and-zeroes/description/
 */
public class OnesAndZeroesTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(solution.findMaxForm(
                new String[]{"10", "0001", "111001", "1", "0"}, 5, 3),
                equalTo(4)
        );
    }

    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] costs = new int[strs.length][2];
            for (int i = 0; i < strs.length; i++) {
                calcCount(costs[i], strs[i]);
            }

            int[][][] dp = new int[m + 1][n + 1][costs.length + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    for (int k = 1; k <= costs.length; k++) {
                        int max = dp[i][j][k - 1];
                        if (i > 0) {
                            max = Math.max(max, dp[i - 1][j][k]);
                        }
                        if (j > 0) {
                            max = Math.max(max, dp[i][j - 1][k]);
                        }
                        int[] cost = costs[k - 1];
                        if (i >= cost[0] && j >= cost[1]) {
                            max = Math.max(max, 1 + dp[i - cost[0]][j - cost[1]][k - 1]);
                        }
                        dp[i][j][k] = max;
                    }
                }
            }

            return dp[m][n][costs.length];
        }

        private void calcCount(int[] cost, String str) {
            for (char ch : str.toCharArray()) {
                if (ch == '0')
                    cost[0]++;
                else
                    cost[1]++;
            }
        }
    }
}
