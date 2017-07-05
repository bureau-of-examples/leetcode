package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/#/description
 */
public class LongestPalindromicSubsequenceTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(solution.longestPalindromeSubseq("bbbab"), equalTo(4));
    }

    public class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length()][s.length()]; //dp[i][j] = longest palindrome between [i, j]
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.max(
                                dp[i + 1][j],
                                dp[i][j - 1]
                        );
                        if (s.charAt(i) == s.charAt(j)) {
                            dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                        }
                    }
                }
            }
            return dp[0][s.length() - 1];
        }
    }

}
