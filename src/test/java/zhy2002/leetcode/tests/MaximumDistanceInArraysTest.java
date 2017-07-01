package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/maximum-distance-in-arrays/#/description
 */
public class MaximumDistanceInArraysTest {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(solution.maxDistance(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5),
                        Arrays.asList(1, 2, 3)
                )
        ), equalTo(4));

        assertThat(solution.maxDistance(
                Arrays.asList(
                        Arrays.asList(1, 4),
                        Arrays.asList(0, 5)
                )
        ), equalTo(4));

        assertThat(solution.maxDistance(
                Arrays.asList(
                        Arrays.asList(1, 5),
                        Arrays.asList(3, 4)
                )
        ), equalTo(3));
    }

    private static class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            Map<Integer, Integer> minMap = new HashMap<>();
            Map<Integer, Integer> maxMap = new HashMap<>();

            for (int i = 0; i < arrays.size(); i++) {
                List<Integer> list = arrays.get(i);
                if (list.isEmpty())
                    continue;

                minMap.put(i, list.get(0));
                maxMap.put(i, list.get(list.size() - 1));
            }

            int minIndex = -1, maxIndex = -1;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            for (Integer minKey : minMap.keySet()) {
                int minVal = minMap.get(minKey);
                if (minVal < min) {
                    min = minVal;
                    minIndex = minKey;
                }
            }

            for (Integer maxKey : maxMap.keySet()) {
                int maxVal = maxMap.get(maxKey);
                if (maxVal > max) {
                    max = maxVal;
                    maxIndex = maxKey;
                }
            }

            int finalMinIndex = minIndex;
            int finalMaxIndex = maxIndex;
            int diff1 = maxMap.entrySet().stream().filter(entry -> !entry.getKey().equals(finalMinIndex)).mapToInt(Map.Entry::getValue).max().getAsInt() - min;
            int diff2 = max - minMap.entrySet().stream().filter(entry -> !entry.getKey().equals(finalMaxIndex)).mapToInt(Map.Entry::getValue).min().getAsInt();
            return Math.max(diff1, diff2);
        }
    }
}