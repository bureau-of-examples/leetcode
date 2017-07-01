package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/#/description
 */
public class MaximumProductOfThreeNumbersTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.maximumProduct(new int[]{1, 2, 3}), equalTo(6));
        assertThat(solution.maximumProduct(new int[]{1, 2, 3, 4}), equalTo(24));
        assertThat(solution.maximumProduct(new int[]{-1, -2, -3, -4}), equalTo(-6));
    }

    private static class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length - 1;
            List<Integer> candidates = new ArrayList<>();
            if (nums[1] < 0) {
                if (nums[n] >= 0) {
                    candidates.add(nums[0] * nums[1] * nums[n]);
                    if (nums[n - 2] >= 0) {
                        candidates.add(nums[n - 2] * nums[n - 1] * nums[n]);
                    }
                } else {
                    candidates.add(nums[n - 2] * nums[n - 1] * nums[n]);
                }
            } else {
                candidates.add(nums[n - 2] * nums[n - 1] * nums[n]);
            }

            return max(candidates);
        }

        private int max(List<Integer> list) {
            int max = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) > max) {
                    max = list.get(i);
                }
            }
            return max;
        }

    }
}

