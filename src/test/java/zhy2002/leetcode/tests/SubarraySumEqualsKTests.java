package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/#/description
 */
public class SubarraySumEqualsKTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.subarraySum(new int[]{1, 2, 3}, 3),
                equalTo(2)
        );
        assertThat(
                solution.subarraySum(new int[]{1, 1, 1}, 2),
                equalTo(2)
        );
    }

    public class Solution2 {
        public int subarraySum(int[] nums, int k) {
            long[] sum = new long[nums.length];
            long s = 0;
            for (int i = 0; i < nums.length; i++) {
                s += nums[i];
                sum[i] = s;
            }

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    s = sum[j] - (i > 0 ? sum[i - 1] : 0);
                    if (s == k) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> sumCount = new HashMap<>();
            int sum = 0;
            sumCount.put(sum, 1);

            int count = 0;
            for (int num : nums) {
                sum += num;
                int find = sum - k;
                if (sumCount.containsKey(find)) {
                    count += sumCount.get(find);
                }
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
            return count;

        }
    }
}
