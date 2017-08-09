package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/elimination-game/description/
 */
public class EliminationGameTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.lastRemaining(1), equalTo(1));
        assertThat(solution.lastRemaining(2), equalTo(2));
        assertThat(solution.lastRemaining(3), equalTo(2));
        assertThat(solution.lastRemaining(4), equalTo(2));
        assertThat(solution.lastRemaining(9), equalTo(6));
        assertThat(solution.lastRemaining(10), equalTo(8));
        assertThat(solution.lastRemaining(12), equalTo(6));
    }

    public class Solution {
        public int lastRemaining(int n) {
            int first = 1, last = n;
            boolean fromStart = true;
            int step = 1, remaining = n;
            while (first < last) {
                if (fromStart) {
                    first += step;
                } else {
                    last -= step;
                }
                if (remaining % 2 == 1) {
                    if (fromStart) {
                        last -= step;
                    } else {
                        first += step;
                    }
                }
                remaining /= 2;
                fromStart = !fromStart;
                step *= 2;
            }
            return first;
        }
    }

}
