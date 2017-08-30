package zhy2002.leetcode.tests;

import org.hamcrest.Matchers;
import org.junit.Test;
import zhy2002.leetcode.solutions.decodeways.Solution;
import static org.junit.Assert.*;

public class DecodeWaysTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(1, solution.numDecodings("1"));
        assertEquals(0, solution.numDecodings("0"));
        assertEquals(1, solution.numDecodings("10"));
        assertEquals(2, solution.numDecodings("12"));
        assertEquals(3, solution.numDecodings("121"));
        assertEquals(1, solution.numDecodings("999"));
        assertEquals(2, solution.numDecodings("1999"));
        assertEquals(1, solution.numDecodings("101"));
        assertEquals(0, solution.numDecodings("100"));
    }

    @Test
    public void test1() {
        String[] parts = "aaa bbb  ".split("\\s+");
        assertThat(parts.length, Matchers.equalTo(2));
    }

    @Test
    public void testMatch() {
        assertThat(matches("ccddee", "*ccddee*"), Matchers.equalTo(true));
    }

    private boolean matches(String str, String pattern) {
        boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        boolean allStar = true;
        for (int j=1; j<=pattern.length(); j++) {
            char p = pattern.charAt(j - 1);
            if (p != '*') {
                allStar = false;
            }
            dp[0][j] = allStar;
            boolean j_1Matches = dp[0][j-1];
            for (int i=1; i<=str.length(); i++) {
                if (dp[i][j-1]) {
                    j_1Matches = true;
                }

                if (p == '*') {
                    dp[i][j] = j_1Matches;
                } else if (p == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    char c = str.charAt(i - 1);
                    dp[i][j] = p == c && dp[i-1][j-1];
                }
            }
        }
        return dp[str.length()][pattern.length()];
    }
}
