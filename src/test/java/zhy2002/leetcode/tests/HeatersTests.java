package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/heaters/#/description
 */
public class HeatersTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findRadius(new int[]{1}, new int[]{1}), equalTo(0));
        assertThat(solution.findRadius(new int[]{0, 3}, new int[]{1}), equalTo(2));
        assertThat(solution.findRadius(new int[]{0, 3}, new int[]{1, 4}), equalTo(1));
        assertThat(solution.findRadius(new int[]{0, 3}, new int[]{-10, 1, 4, 19}), equalTo(1));
        assertThat(solution.findRadius(new int[]{0, 4, 12}, new int[]{10}), equalTo(10));
        assertThat(solution.findRadius(new int[]{0, 4, 12}, new int[]{2, 10}), equalTo(2));
        assertThat(solution.findRadius(new int[]{0, 4, 12}, new int[]{2, 5, 10}), equalTo(2));
    }

    public class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            if (houses.length == 0)
                return 0;
            assert heaters.length > 0;

            Arrays.sort(houses);
            Arrays.sort(heaters);
            int[] clusterMax = new int[heaters.length];
            int nextHeaterPos = 0; //first heater to the right of first house
            for (int i = 0; i < houses.length; i++) {
                int house = houses[i];
                if (nextHeaterPos < heaters.length) {
                    if (heaters[nextHeaterPos] < house) {
                        nextHeaterPos++;
                        i--; //stay at this house
                        continue;
                    }
                    if (nextHeaterPos == 0) {
                        clusterMax[0] = Math.max(clusterMax[0], heaters[0] - house);
                    } else { //no previous heater
                        if (heaters[nextHeaterPos] - house < house - heaters[nextHeaterPos - 1]) {
                            clusterMax[nextHeaterPos] = Math.max(clusterMax[nextHeaterPos], heaters[nextHeaterPos] - house);
                        } else { //closer to previous heater
                            clusterMax[nextHeaterPos - 1] = Math.max(clusterMax[nextHeaterPos - 1], house - heaters[nextHeaterPos - 1]);
                        }
                    }
                } else { //no next heater
                    clusterMax[heaters.length - 1] = Math.max(clusterMax[heaters.length - 1], house - heaters[heaters.length - 1]);//add to previous heater
                }
            }
            return Arrays.stream(clusterMax).max().orElse(0);
        }
    }
}
