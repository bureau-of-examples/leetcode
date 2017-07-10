package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/teemo-attacking/#/description
 */
public class TeemoAttackingTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findPoisonedDuration(new int[]{1,4,7,8,14}, 2), equalTo(9));
    }

    public class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            int total = 0;
            int end = 0;
            for (int time : timeSeries) {
                if (time >= end) {
                    end = time + duration;
                    total += duration;
                } else {
                    if (time + duration > end) {
                        total += time + duration - end;
                        end = time + duration;
                    }
                }

            }
            return total;
        }
    }
}
