package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/optimal-account-balancing/description/
 */
public class OptimalAccountBalancingTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.minTransfers(new int[][]{{0, 3, 2}, {1, 4, 3}, {2, 3, 2}, {2, 4, 2}}), equalTo(3));
        assertThat(solution.minTransfers(new int[][]{{1, 2, 3}, {1, 3, 3}, {6, 4, 1}, {5, 4, 4}}), equalTo(4));
        assertThat(solution.minTransfers(new int[][]{{0, 1, 5}, {0, 2, 5}, {3, 4, 5}, {3, 5, 5}}), equalTo(4));
        assertThat(solution.minTransfers(new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 4}, {3, 4, 5}}), equalTo(3));
        assertThat(solution.minTransfers(new int[][]{{2, 0, 5}, {0, 1, 10}}), equalTo(2));
        assertThat(solution.minTransfers(new int[][]{{1, 5, 8}, {8, 9, 8}, {2, 3, 9}, {4, 3, 1}}), equalTo(4));
        assertThat(solution.minTransfers(new int[][]{{2, 0, 5}, {3, 4, 4}}), equalTo(2));
    }

    class Solution {
        private int minCount;

        public int minTransfers(int[][] transactions) {
            Map<Integer, Integer> balance = new HashMap<>();
            for (int[] transaction : transactions) {
                int val0 = balance.getOrDefault(transaction[0], 0) - transaction[2];
                balance.put(transaction[0], val0);
                int val1 = balance.getOrDefault(transaction[1], 0) + transaction[2];
                balance.put(transaction[1], val1);
            }
            int[] array = balance.values().stream().mapToInt(v -> v).filter(v -> v != 0).toArray();
            minCount = Integer.MAX_VALUE;
            backTrack(array, 0);
            return minCount;
        }

        private void backTrack(int[] array, int currentCount) {
            if (currentCount >= minCount)
                return;//prune
            int first = 0;
            while (first < array.length && array[first] == 0)
                first++;
            if (first == array.length) {
                minCount = Math.min(minCount, currentCount);
                return;
            }
            int firstVal = array[first];
            for (int second = first + 1; second < array.length; second++) {
                if (array[second] == -firstVal) {
                    int secondVal = array[second];
                    array[first] = array[second] = 0;
                    backTrack(array, currentCount + 1);
                    array[first] = firstVal;
                    array[second] = secondVal;
                    return;
                }
            }
            for (int second = first + 1; second < array.length; second++) {
                if (array[second] * firstVal < 0) {
                    int secondVal = array[second];
                    array[first] = firstVal + secondVal;
                    array[second] = 0;
                    backTrack(array, currentCount + 1);
                    array[second] = secondVal;
                }
            }
            array[first] = firstVal;
        }
    }

}
