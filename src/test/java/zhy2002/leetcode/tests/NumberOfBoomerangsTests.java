package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/number-of-boomerangs/#/description
 */
public class NumberOfBoomerangsTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        int[][] input = {{0, 0}, {1, 0}, {1, 1}, {0, 1}};
        assertThat(
                solution.numberOfBoomerangs(input),
                equalTo(8)
        );

        input = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        assertThat(
                solution.numberOfBoomerangs(input),
                equalTo(2)
        );
    }

    public class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int count = 0;
            for (int i = 0; i < points.length; i++) {
                HashMap<Integer, Integer> distancesI = new HashMap<>();
                for (int j = 0; j < points.length; j++) {
                    if (i == j)
                        continue;
                    int d = dist(points, i, j);
                    distancesI.put(d, distancesI.getOrDefault(d, 0) + 1);
                }

                for (Integer size : distancesI.values()) {
                    if (size < 2)
                        continue;
                    count += size * (size - 1);
                }
            }
            return count;
        }

        private int dist(int[][] points, int i, int j) {
            int diffX = points[i][0] - points[j][0];
            int diffY = points[i][1] - points[j][1];
            return diffX * diffX + diffY * diffY;
        }
    }
}
