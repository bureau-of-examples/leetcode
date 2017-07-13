package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/shuffle-an-array/#/description
 */
public class ShuffleAnArrayTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {

        private Random random = new Random();
        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return Arrays.copyOf(nums, nums.length);
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int[] result = reset();
            for (int i = nums.length - 1; i >= 0; i--) {
                int index = random.nextInt(i + 1);
                swap(result, i, index);
            }
            return result;
        }

        private void swap(int[] result, int i, int index) {
            int temp = result[i];
            result[i] = result[index];
            result[index] = temp;
        }
    }

}
