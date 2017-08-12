package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/burst-balloons/description/
 */
public class BurstBalloonsTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.maxCoins(new int[]{3, 1, 5, 8}), equalTo(167));
        assertThat(solution.maxCoins(new int[]{3}), equalTo(3));
    }

    public class Solution {
        public int maxCoins(int[] nums) {
            if (nums.length == 0)
                return 0;
            int[][] dp = new int[nums.length][nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                for (int j = i; j < nums.length; j++) {
                    int max = 0;
                    for (int k = i; k <= j; k++) {
                        int val = (k - 1 < i ? 0 : dp[i][k - 1]) +
                                (k + 1 > j ? 0 : dp[k + 1][j]) +
                                nums[k] * (i == 0 ? 1 : nums[i - 1]) * (j == nums.length - 1 ? 1 : nums[j + 1]);
                        max = Math.max(max, val);
                    }
                    dp[i][j] = max;
                }
            }
            return dp[0][nums.length - 1];
        }
    }

    public class Solution2 {

        private Map<String, Integer> cache;

        public int maxCoins(int[] nums) {
            if (nums.length == 0)
                return 0;
            cache = new HashMap<>();
            return burst(nums, 0, nums.length - 1);
        }

        private int burst(int[] num, int start, int end) {
            if (start > end) {
                return 0;
            }
            String key = start + "," + end;
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            int max = 0;
            for (int i = start; i <= end; i++) {
                int val = burst(num, start, i - 1) +
                        burst(num, i + 1, end) +
                        num[i] * (start == 0 ? 1 : num[start - 1]) * (end == num.length - 1 ? 1 : num[end + 1]);
                max = Math.max(max, val);
            }
            cache.put(key, max);
            return max;
        }
    }
}
