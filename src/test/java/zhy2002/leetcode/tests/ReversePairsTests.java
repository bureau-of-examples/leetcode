package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/reverse-pairs/#/description
 */
public class ReversePairsTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.reversePairs(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}), equalTo(0));
        assertThat(solution.reversePairs(new int[]{-5, -5}), equalTo(1));
        assertThat(solution.reversePairs(new int[]{8, 3, 1}), equalTo(3));
    }

    public class Solution {
        private int count;
        private int[] buffer;

        public int reversePairs(int[] nums) {
            count = 0;
            buffer = new int[nums.length];
            mergeSort(nums, 0, nums.length - 1);
            return count;
        }

        private void mergeSort(int[] nums, int start, int end) {
            if (start >= end) //base case
                return;
            int mid = (start + end) >>> 1;
            int left = start;
            int right = mid + 1;
            mergeSort(nums, left, mid);
            mergeSort(nums, right, end);
            //update count
            int j = right;
            for (int i = start; i <= mid; i++) {//for each on left count # of items on right that meets the criteria
                while (j <= end && 2L * nums[j] < nums[i])
                    j++;
                count += j - right;
            }

            //merge to buffer
            int index = start;
            while (index <= end) {
                if (left > mid) {
                    buffer[index++] = nums[right++];
                } else if (right > end) {
                    buffer[index++] = nums[left++];
                } else {
                    if (nums[left] <= nums[right]) {
                        buffer[index++] = nums[left++];
                    } else {
                        buffer[index++] = nums[right++];
                    }
                }
            }
            for (int i = start; i <= end; i++) {
                nums[i] = buffer[i];
            }
        }
    }

}
