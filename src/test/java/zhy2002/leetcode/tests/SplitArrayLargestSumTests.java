package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/split-array-largest-sum/description/
 */
public class SplitArrayLargestSumTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.splitArray(new int[]{7, 2, 5, 10, 8, 6}, 3),
                equalTo(14)
        );
        assertThat(
                solution.splitArray(new int[]{7, 2, 5, 10, 8}, 2),
                equalTo(18)
        );
    }

    class Solution {
        private Map<String, Integer> cache = new HashMap<>();

        public int splitArray(int[] nums, int m) {
            cache.clear();
            int[] sumLeft = new int[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sumLeft[i] = sumLeft[i - 1] + nums[i - 1];
            }
            return find(nums, 0, sumLeft, m);
        }

        private int find(int[] nums, int start, int[] sumLeft, int m) {
            if (m == 1) {
                return sumLeft[nums.length] - sumLeft[start];
            }

            String key = start + "," + m;
            if (cache.containsKey(key)) {
                return cache.get(key);
            }

            int min = Integer.MAX_VALUE;
            for (int i = start; nums.length - (i + 1) >= m - 1; i++) {
                int firstSum = sumLeft[i + 1] - sumLeft[start];
                int restSum = find(nums, i + 1, sumLeft, m - 1);
                min = Math.min(min, Math.max(firstSum, restSum));
            }
            cache.put(key, min);
            return min;
        }
    }
}
