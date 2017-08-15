package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/2-keys-keyboard/description/
 */
public class TwoKeysKeyboardTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.minSteps(25), equalTo(10));
        assertThat(solution.minSteps(15), equalTo(8));
    }

    public class Solution {
        public int minSteps(int n) {
            int[] dp = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                int min = i;
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j != 0)
                        continue;
                    min = Math.min(min, dp[j] + i / j);
                }
                dp[i] = min;
            }
            return dp[n];
        }
    }

}
