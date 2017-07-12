package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/next-greater-element-ii/#/description
 */
public class NextGreaterElementIITests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.nextGreaterElements(new int[]{1, 2, 1}), equalTo(new int[]{2, -1, 2}));
    }

    public class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] result = new int[nums.length];
            Stack<Integer> indexStack = new Stack<>();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (!indexStack.isEmpty() && nums[i] > nums[indexStack.peek()]) {
                    while (!indexStack.isEmpty() && nums[i] > nums[indexStack.peek()]) {
                        result[indexStack.pop()] = nums[i];
                    }
                }
                indexStack.push(i);
                max = Math.max(max, nums[i]);
            }

            int index = 0;
            while (!indexStack.isEmpty()) {
                if (nums[indexStack.peek()] == max) {
                    result[indexStack.pop()] = -1;
                } else {
                    if (nums[index] <= nums[indexStack.peek()]) {
                        index++;
                    } else {
                        result[indexStack.pop()] = nums[index];
                    }
                }
            }

            return result;
        }
    }
}
