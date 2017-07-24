package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/increasing-subsequences/#/description
 */
public class IncreasingSubsequencesTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                Utils.listOfListToString(solution.findSubsequences(new int[]{4, 6, 7, 7})),
                equalTo("[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]")
        );
    }

    public class Solution {
        private List<List<Integer>> result;

        public List<List<Integer>> findSubsequences(int[] nums) {
            result = new ArrayList<>();
            backTrack(nums, new ArrayList<>(), 0);
            return result;
        }

        private void backTrack(int[] nums, List<Integer> buffer, int start) {
            if (buffer.size() >= 2) {
                result.add(new ArrayList<>(buffer));
            }
            Set<Integer> used = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                if ((buffer.isEmpty() || buffer.get(buffer.size() - 1) <= nums[i]) && !used.contains(nums[i])) {
                    buffer.add(nums[i]);
                    backTrack(nums, buffer, i + 1);
                    buffer.remove(buffer.size() - 1);
                    used.add(nums[i]);
                }
            }
        }
    }
}
