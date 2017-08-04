package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/count-of-range-sum/discuss/
 */
public class CountOfRangeSumTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.countRangeSum(new int[]{2147483647, -2147483648, -1, 0}, -1, 0),
                equalTo(4)
        );
        assertThat(
                solution.countRangeSum(new int[]{-2, 5, -1}, -2, 2),
                equalTo(3)
        );
    }

    public class Solution {

        private long[] buffer;

        public int countRangeSum(int[] nums, int lower, int upper) {
            long[] sumLeft = new long[nums.length + 1];
            for (int i = 1; i <= nums.length; i++) {
                sumLeft[i] = sumLeft[i - 1] + nums[i - 1];
            }

            buffer = new long[sumLeft.length];
            return countAndMergeSort(sumLeft, 0, sumLeft.length - 1, lower, upper);
        }

        private int countAndMergeSort(long[] sumLeft, int start, int end, int lower, int upper) {
            if (start >= end)
                return 0;
            int mid = (start + end) >>> 1;
            int result = countAndMergeSort(sumLeft, start, mid, lower, upper);
            result += countAndMergeSort(sumLeft, mid + 1, end, lower, upper);

            int mergeIndex = start;
            int rightIndex = mid + 1;
            int rightRangeLeft = rightIndex;
            int rightRangeRight = rightIndex;
            for (int leftIndex = start; leftIndex <= mid; leftIndex++) {
                while (rightRangeLeft <= end && sumLeft[rightRangeLeft] - sumLeft[leftIndex] < lower) {
                    rightRangeLeft++;
                }
                while (rightRangeRight <= end && sumLeft[rightRangeRight] - sumLeft[leftIndex] <= upper) {
                    rightRangeRight++;
                }
                result += rightRangeRight - rightRangeLeft;
                while (rightIndex <= end && sumLeft[rightIndex] < sumLeft[leftIndex]) {
                    buffer[mergeIndex++] = sumLeft[rightIndex++];
                }
                buffer[mergeIndex++] = sumLeft[leftIndex];
            }
            System.arraycopy(buffer, start, sumLeft, start, rightIndex - start);
            return result;
        }
    }

}
