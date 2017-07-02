package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/max-consecutive-ones/#/description
 */
public class MaxConsecutiveOnesTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }


    public class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int maxCount = 0;
            int count = 0;
            for (int num : nums) {
                if (num == 1) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 0;
                }
            }
            return Math.max(maxCount, count);
        }
    }

}
