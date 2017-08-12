package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/4sum-ii/description/
 */
public class FourSumIITests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(
                solution.fourSumCount(
                        new int[]{1, 2},
                        new int[]{-2, -1},
                        new int[]{-1, 2},
                        new int[]{0, 2}
                ),
                equalTo(2));
    }

    public class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> countsAB = new HashMap<>();
            for (int a : A) {
                for (int b : B) {
                    countsAB.put(a + b, countsAB.getOrDefault(a + b, 0) + 1);
                }
            }

            Map<Integer, Integer> countsCD = new HashMap<>();
            for (int c : C) {
                for (int d : D) {
                    countsCD.put(c + d, countsCD.getOrDefault(c + d, 0) + 1);
                }
            }

            int result = 0;
            for (Integer c : countsAB.keySet()) {
                if (countsCD.containsKey(-c)) {
                    result += countsAB.get(c) * countsCD.get(-c);
                }
            }
            return result;
        }
    }
}
