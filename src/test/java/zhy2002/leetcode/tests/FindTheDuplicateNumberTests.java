package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/#/description
 */
public class FindTheDuplicateNumberTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int findDuplicate(int[] nums) {
            int start = 1, end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                int smallerCount = 0, greaterCount = 0;
                for (int num : nums) {
                    if (num < mid)
                        smallerCount++;
                    else if (num > mid)
                        greaterCount++;
                }
                if (nums.length - smallerCount - greaterCount > 1)
                    return mid;
                if (smallerCount >= mid) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            throw new RuntimeException("No duplicate");
        }
    }
}
