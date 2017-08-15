package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/sort-transformed-array/description/
 */
public class SortTransformedArrayTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] result = solution.sortTransformedArray(new int[] {-4,-2,2,4}, 1, 4, 5);
        assertThat(result, equalTo(new int[] {1,5,17,37}));
    }

    public class Solution {
        public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            if (a == 0)
                return computeLinear(nums, b, c);
            double center = -1.0 * b/(2 * a);
            int start = -1, end = 0;
            while (end < nums.length && nums[end] < center) {
                start = end++;
            }
            //out put from middle
            int[] result = new int[nums.length];
            for (int i=0; i<nums.length; i++) {
                int index = a > 0 ? i : nums.length - 1 - i;
                if (start < 0 || end < nums.length && center - nums[start] > nums[end] - center) {
                    result[index] = nums[end++];
                } else {
                    result[index] = nums[start--];
                }
                result[index] = a * result[index] * result[index] + b * result[index] + c;
            }
            return result;
        }

        private int[] computeLinear(int[] nums, int b, int c) {
            int[] result = new int[nums.length];
            if (b >= 0) {
                for (int i=0; i<nums.length; i++) {
                    result[i] = b * nums[i] + c;
                }
            } else {
                for (int i=0; i<nums.length; i++) {
                    result[nums.length - 1 - i] = b * nums[i] + c;
                }
            }
            return result;
        }
    }
}
