package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/perfect-squares/#/description
 */
public class PerfectSquaresTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int numSquares(int n) {
            if (n < 0)
                return -1;

            int[] dp = new int[n + 1];
            int m = (int) Math.sqrt(n);
            for (int i = 1; i <= n; i++) {
                int min = i; //use all 1s
                for (int j = 1; j <= m; j++) {
                    int square = j * j;
                    if (square > i)
                        break;
                    min = Math.min(min, dp[i - square] + 1);
                }
                dp[i] = min;
            }
            return dp[n];
        }
    }
}
