package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/encode-string-with-shortest-length/description/
 */
public class EncodeStringWithShortestLengthTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.encode("abbbabbbcabbbabbbc"), equalTo("2[2[abbb]c]"));
        assertThat(solution.encode("aaaaa"), equalTo("5[a]"));
    }

    public class Solution {

        public String encode(String s) {
            String[][] dp = new String[s.length()][s.length()];
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i; j < s.length(); j++) {
                    String subStr = s.substring(i, j + 1);
                    dp[i][j] = subStr;
                    if (subStr.length() <= 4)
                        continue;

                    int len = subStr.length();
                    for (int k = 1; k <= len / 2; k++) {
                        if (len % k != 0)
                            continue;
                        String repeated = subStr.substring(0, k);
                        if (subStr.replaceAll(repeated, "").length() == 0) {
                            String encoded = (len / k) + "[" + dp[i][i + k - 1] + "]";
                            if (encoded.length() < dp[i][j].length()) {
                                dp[i][j] = encoded;
                                break;
                            }
                        }
                    }

                    for (int k = i + 1; k <= j; k++) {
                        if (dp[i][k - 1].length() + dp[k][j].length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k - 1] + dp[k][j];
                        }
                    }
                }
            }
            return dp[0][s.length() - 1];
        }
    }

}
