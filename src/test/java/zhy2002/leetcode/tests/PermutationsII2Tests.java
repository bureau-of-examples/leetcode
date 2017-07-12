package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/permutations-ii/#/description
 */
public class PermutationsII2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(
                "[[2,1,1,2],[2,1,2,1],[2,2,1,1],[1,1,2,2],[1,2,2,1],[1,2,1,2]]",
                Utils.listOfListToString(solution.permuteUnique(new int[]{2, 1, 1, 2}))
        );
        assertEquals(
                "[[1,1,2],[1,2,1],[2,1,1]]",
                Utils.listOfListToString(solution.permuteUnique(new int[]{1, 1, 2}))
        );
        assertEquals(
                "[[1,1]]",
                Utils.listOfListToString(solution.permuteUnique(new int[]{1, 1}))
        );
        assertEquals(
                "[[1,2,3],[1,3,2],[2,3,1],[2,1,3],[3,1,2],[3,2,1]]",
                Utils.listOfListToString(solution.permuteUnique(new int[]{1, 2, 3}))
        );
        assertEquals(
                "[[1,2],[2,1]]",
                Utils.listOfListToString(solution.permuteUnique(new int[]{1, 2}))
        );
        assertEquals(
                "[[3]]",
                Utils.listOfListToString(solution.permuteUnique(new int[]{3}))
        );
    }

    private class Solution {

        private List<List<Integer>> result;

        public List<List<Integer>> permuteUnique(int[] num) {
            result = new ArrayList<>();
            Deque<Integer> remaining = new ArrayDeque<>();
            for (int n : num) {
                remaining.add(n);
            }
            solve(new ArrayList<>(), remaining);
            return result;
        }

        private void solve(List<Integer> buffer, Deque<Integer> remaining) {
            if (remaining.size() == 0) {
                result.add(new ArrayList<>(buffer));
                return;
            }

            int count = remaining.size();
            Set<Integer> used = new HashSet<>();
            for (int i = 0; i < count; i++) {
                Integer val = remaining.poll();
                if (used.contains(val)) {
                    remaining.add(val);
                    continue;
                }

                buffer.add(val);
                solve(buffer, remaining);
                buffer.remove(buffer.size() - 1);
                remaining.add(val);
                used.add(val);
            }
        }
    }


}
