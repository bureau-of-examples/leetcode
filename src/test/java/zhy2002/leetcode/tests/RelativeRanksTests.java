package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problemset/algorithms/?difficulty=Easy
 */
public class RelativeRanksTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.findRelativeRanks(new int[]{5, 4, 3, 2, 1}),
                equalTo(new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"})
        );
    }

    public class Solution {
        public String[] findRelativeRanks(int[] nums) {
            Map<Integer, Integer> scoreIndex = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                scoreIndex.put(nums[i], i);
            }
            Arrays.sort(nums);
            String[] result = new String[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                String rank = getRank(nums.length - 1 - i);
                result[scoreIndex.get(nums[i])] = rank;
            }
            return result;
        }

        private final String[] RANKS = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        private String getRank(int i) {
            if (i < RANKS.length)
                return RANKS[i];
            return String.valueOf(i + 1);
        }
    }

}
