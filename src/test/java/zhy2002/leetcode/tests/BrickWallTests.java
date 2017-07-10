package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/brick-wall/#/description
 */
public class BrickWallTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.leastBricks(
                        Arrays.asList(
                                Arrays.asList(1,2,2,1),
                                Arrays.asList(3,1,2),
                                Arrays.asList(1,3,2),
                                Arrays.asList(2,4),
                                Arrays.asList(3,1,2),
                                Arrays.asList(1,3,1,1)
                        )
                ),
                equalTo(2)
        );
        assertThat(
                solution.leastBricks(
                        Arrays.asList(
                                Arrays.asList(1, 1, 1),
                                Arrays.asList(1, 2),
                                Arrays.asList(2, 1)
                        )
                ),
                equalTo(1)
        );
        assertThat(
                solution.leastBricks(
                        Arrays.asList(
                                Arrays.asList(1, 1),
                                Arrays.asList(1, 1),
                                Arrays.asList(2)
                        )
                ),
                equalTo(1)
        );
        assertThat(
                solution.leastBricks(
                        Arrays.asList(
                                Arrays.asList(1, 1),
                                Arrays.asList(2)
                        )
                ),
                equalTo(1)
        );
        assertThat(
                solution.leastBricks(
                        Arrays.asList(
                                Arrays.asList(1),
                                Arrays.asList(1)
                        )
                ),
                equalTo(2)
        );
    }

    public class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer, Integer> frequency = new HashMap<>();
            for (List<Integer> row : wall) {
                int rightBorder = 0;
                for (int i = 0; i < row.size() - 1; i++) {
                    rightBorder += row.get(i);
                    frequency.put(rightBorder, frequency.getOrDefault(rightBorder, 0) + 1);
                }
            }
            return wall.size() - frequency.values().stream().mapToInt(i -> i).max().orElse(0);
        }
    }

    public class SlowSolution {
        public int leastBricks(List<List<Integer>> wall) {
            int width = 0;
            for (int w : wall.get(0)) {
                width += w;
            }
            if (width == 1)
                return wall.size();

            int[] dp = new int[width - 1];
            for (List<Integer> row : wall) {
                updateDp(row, dp);
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < dp.length; i++) {
                min = Math.min(min, dp[i]);
            }
            return min;
        }

        private void updateDp(List<Integer> row, int[] dp) {
            int brickIndex = -1;
            int brickRight = 0;
            for (int i = 0; i < dp.length; i++) {
                int dpRight = i + 1;
                if (brickRight == dpRight) {
                    brickIndex++;
                    brickRight += row.get(brickIndex);
                } else if (brickRight > dpRight) {
                    dp[i]++;
                } else {
                    brickIndex++;
                    brickRight += row.get(brickIndex);
                    i--;
                }
            }
        }


    }

}
