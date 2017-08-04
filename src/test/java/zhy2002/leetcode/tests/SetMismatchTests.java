package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/set-mismatch/description/
 */
public class SetMismatchTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.findErrorNums(new int[]{4, 5, 2, 6, 5, 3, 1}),
                equalTo(new int[]{5, 7})
        );
        assertThat(
                solution.findErrorNums(new int[]{4, 5, 2, 8, 7, 3, 1}),
                equalTo(new int[]{8, 6})
        );
        assertThat(
                solution.findErrorNums(new int[]{4, 5, 2, 6, 1, 1}),
                equalTo(new int[]{1, 3})
        );
        assertThat(
                solution.findErrorNums(new int[]{1, 2, 2, 4}),
                equalTo(new int[]{2, 3})
        );
    }

    public class Solution {
        public int[] findErrorNums(int[] nums) {
            int index = 0;
            while (index < nums.length) {
                if (nums[index] == index + 1) {
                    index++;
                } else {
                    int correctIndex = nums[index] - 1;
                    if (correctIndex >= nums.length || nums[correctIndex] == nums[index]) {
                        index++;
                    } else {//swap
                        int temp = nums[correctIndex];
                        nums[correctIndex] = nums[index];
                        nums[index] = temp;
                    }
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    return new int[]{nums[i], i + 1};
                }
            }
            return new int[0];
        }
    }

}
