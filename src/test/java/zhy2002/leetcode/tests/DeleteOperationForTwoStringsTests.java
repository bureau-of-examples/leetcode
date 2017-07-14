package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/delete-operation-for-two-strings/#/description
 */
public class DeleteOperationForTwoStringsTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.longestCommonSequence1D("ab", "ca"), equalTo(1));
        assertThat(solution.longestCommonSequence1D("a", "a"), equalTo(1));
        assertThat(solution.longestCommonSequence1D("eat", "sea"), equalTo(2));
    }

    public class Solution {
        public int minDistance(String word1, String word2) {
            int size = longestCommonSequence1D(word1, word2);
            return word1.length() - size + word2.length() - size;
        }

        private int longestCommonSequence(String word1, String word2) {
            int[][] dp = new int[word1.length() + 1][word2.length() + 1]; //dp[i][j] = first i in word 1 and first j in word 2
            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
            return dp[word1.length()][word2.length()];
        }

        private int longestCommonSequence1D(String word1, String word2) {
            int[] dp = new int[word2.length() + 1];
            int[] dpPrevious = new int[word2.length() + 1];
            for (int i = 1; i <= word1.length(); i++) {
                System.arraycopy(dp, 0, dpPrevious, 0, dp.length);
                for (int j = 1; j <= word2.length(); j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[j] = dpPrevious[j - 1] + 1;
                    } else {
                        dp[j] = Math.max(dp[j - 1], dp[j]);
                    }
                }
            }
            return dp[word2.length()];
        }
    }

}
