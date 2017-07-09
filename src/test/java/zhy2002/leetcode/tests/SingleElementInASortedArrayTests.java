package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/#/description
 */
public class SingleElementInASortedArrayTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.singleNonDuplicate(new int[]{1, 1, 2, 2, 3, 4, 4}), equalTo(3));
        assertThat(solution.singleNonDuplicate(new int[]{1, 1, 2}), equalTo(2));
        assertThat(solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3}), equalTo(2));
        assertThat(solution.singleNonDuplicate(new int[]{1, 2, 2}), equalTo(1));
        assertThat(solution.singleNonDuplicate(new int[]{1}), equalTo(1));
    }

    public class Solution {
        public int singleNonDuplicate(int[] nums) {
            int pairCount = nums.length / 2 + 1;
            int start = 0, end = pairCount - 1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                int midFirst = mid * 2;
                if (midFirst - 1 >= 0 && nums[midFirst] == nums[midFirst - 1]) {
                    end = mid - 1;
                } else if (midFirst + 1 < nums.length && nums[midFirst] == nums[midFirst + 1]) {
                    start = mid + 1;
                } else {
                    return nums[midFirst];
                }
            }
            throw new RuntimeException("Invalid input");
        }
    }

}
