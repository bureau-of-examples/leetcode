package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.distinctsubsequences.Solution;
import org.junit.Test;
import static org.junit.Assert.*;

public class DistinctSequencesTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertEquals(1, solution.numDistinct("", ""));
        assertEquals(3, solution.numDistinct("rabbbit", "rabbit"));
        assertEquals(5, solution.numDistinct("babgbag", "bag"));
        assertEquals(numDistinct1("bbannana", "na"), solution.numDistinct("bbannana", "na"));
        assertEquals(numDistinct1("test", "test1"), solution.numDistinct("test", "test1")); //0
    }

    /**
     * implementation by: http://blog.csdn.net/abcbc/article/details/8978146
     * @param S source
     * @param T target
     * @return how many sub-sequence of S equals to T.
     */
    public int numDistinct1(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= T.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= S.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= T.length(); i++) {
            for (int j = 1; j <= S.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[T.length()][S.length()];

    }

}
