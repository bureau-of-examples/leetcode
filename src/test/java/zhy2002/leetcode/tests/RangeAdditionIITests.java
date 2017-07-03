package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/range-addition-ii/#/description
 */
public class RangeAdditionIITests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}),
                equalTo(4)
        );
    }

    public class Solution {
        public int maxCount(int m, int n, int[][] ops) {
            int minM = m;
            int minN = n;
            for (int[] op : ops) {
                minM = Math.min(minM, op[0]);
                minN = Math.min(minN, op[1]);
            }
            return minM * minN;
        }
    }
}
