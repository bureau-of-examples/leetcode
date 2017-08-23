package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/description/
 */
public class GuessNumberHigherOrLowerIITests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.getMoneyAmount(23), equalTo(58));
    }

    class Solution {

        private int[][] cache;

        public int getMoneyAmount(int n) {
            cache = new int[n+1][n+1];
            return guess(1, n);
        }

        private int guess(int start, int end) {
            if (start >= end)
                return 0;
            if (start + 1 == end)
                return start;
            if (start + 2 == end)
                return start + 1;
            if (cache[start][end] == 0) {
                int min = Integer.MAX_VALUE;
                for (int i=start; i<=end;i++) {
                    min = Math.min(
                            min,
                            Math.max(guess(start, i-1), guess(i+1, end)) + i
                    );
                }
                cache[start][end] = min;
            }
            return cache[start][end];
        }
    }


}
