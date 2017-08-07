package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
 */
public class CountOfSmallerNumbersAfterSelfTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.countSmaller(new int[]{5, 2, 6, 1}),
                equalTo(Arrays.asList(2, 1, 1, 0))
        );
    }

    public class Solution {
        private int[] buffer;
        private int[] counts;

        public List<Integer> countSmaller(int[] nums) {
            buffer = new int[nums.length]; //merge sort buffer
            counts = new int[nums.length]; //smaller count for index
            int[] indices = new int[nums.length]; //will sort indices

            for (int i = 0; i < indices.length; i++) { //init
                indices[i] = i;
                counts[i] = 0;
            }

            mergeAndCount(indices, nums, 0, nums.length - 1); //populate counts array

            List<Integer> result = new ArrayList<Integer>(); //export result
            for (int c : counts) {
                result.add(c);
            }
            return result;
        }

        private void mergeAndCount(int[] indices, int[] nums, int start, int end) {
            if (start >= end)
                return;
            int mid = (start + end) >>> 1;
            mergeAndCount(indices, nums, start, mid);
            mergeAndCount(indices, nums, mid + 1, end);

            int bIndex = start;
            int right = mid + 1;
            int count = 0;
            for (int i = start; i <= mid; i++) {
                while (right <= end && nums[indices[right]] < nums[indices[i]]) {
                    count++;
                    buffer[bIndex++] = indices[right++];
                }
                buffer[bIndex++] = indices[i];
                counts[indices[i]] += count;
            }
            System.arraycopy(buffer, start, indices, start, right - start);
        }
    }
}
