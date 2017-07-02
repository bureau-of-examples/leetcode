package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NextPermutationTests {

    @Test
    public void basicTest() {
        Solution2 solution = new Solution2();
        int[] array = {1, 2, 3};
        solution.nextPermutation(array);
        assertArrayEquals(new int[]{1, 3, 2}, array);

        solution.nextPermutation(array);
        assertArrayEquals(new int[]{2, 1, 3}, array);

        array = new int[]{4, 4, 3, 1};
        solution.nextPermutation(array);
        assertArrayEquals(new int[]{1, 3, 4, 4}, array);

        solution.nextPermutation(array);
        assertArrayEquals(new int[]{1, 4, 3, 4}, array);

        solution.nextPermutation(array);
        assertArrayEquals(new int[]{1, 4, 4, 3}, array);

        solution.nextPermutation(array);
        assertArrayEquals(new int[]{3, 1, 4, 4}, array);
    }

    public class Solution2 {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            for (; i >= 0; i--) {//dipping point back to front
                if (nums[i] < nums[i + 1])
                    break;
            }
            if (i != -1) {
                int increasingDigit = nums[i];
                int newDigit = getFirstGreaterBackToFront(nums, increasingDigit);
                swap(nums, i, newDigit);
            }
            reverse(nums, i + 1, nums.length - 1);
        }

        private int getFirstGreaterBackToFront(int[] array, int target) {
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] > target)
                    return i;
            }
            return -1;
        }

        private void reverse(int[] array, int start, int end) {
            while (start < end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }

        private void swap(int[] array, int index1, int index2) {
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
    }
}
