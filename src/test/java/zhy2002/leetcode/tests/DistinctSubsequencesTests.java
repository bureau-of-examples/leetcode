package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/distinct-subsequences/#/description
 */
public class DistinctSubsequencesTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.numDistinct("rabbbit", "rabbit"), equalTo(3));
        assertThat(solution.numDistinct("aa", "a"), equalTo(2));
    }

    public class Solution2 {
        public int numDistinct(String s, String t) {
            if (s.length() < t.length())
                return 0;
            if (s.equals(t))
                return 1;

            int[][] dp = new int[s.length() + 1][t.length() + 1]; //dp[i][j] = # of distinct subsequences in s[0,i) equal to t[0,j)
            for (int i = 0; i <= s.length(); i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                }
            }

            return dp[s.length()][t.length()];

        }
    }

    public class Solution {
        public int numDistinct(String s, String t) {
            if (s.length() < t.length())
                return 0;
            if (s.equals(t))
                return 1;

            int[] dp = new int[t.length() + 1];
            dp[0] = 1;
            for (int i = 1; i <= s.length(); i++) {
                int prevJMinus1 = dp[0];
                for (int j = 1; j <= t.length(); j++) {
                    int prevJ = dp[j];
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[j] += prevJMinus1;
                    }
                    prevJMinus1 = prevJ;
                }
            }
            return dp[t.length()];
        }
    }
}
