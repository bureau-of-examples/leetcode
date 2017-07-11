package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/squirrel-simulation/#/description
 */
public class SquirrelSimulationTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.minDistance(0, 0, new int[]{0, 1}, new int[]{0, 0}, new int[][]{{0, 2}}),
                equalTo(3)
        );
        assertThat(
                solution.minDistance(0, 0, new int[]{2, 2}, new int[]{4, 4}, new int[][]{{3, 0}, {2, 5}}),
                equalTo(12)
        );
    }

    public class Solution {
        public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
            int dist = 0;
            int min = Integer.MAX_VALUE;
            for (int[] nut : nuts) {
                int d = Math.abs(nut[0] - tree[0]) + Math.abs(nut[1] - tree[1]);
                int diff = Math.abs(nut[0] - squirrel[0]) + Math.abs(nut[1] - squirrel[1]) - d;
                min = Math.min(min, diff);
                dist += d;
            }
            return dist * 2 + min;
        }
    }

}
