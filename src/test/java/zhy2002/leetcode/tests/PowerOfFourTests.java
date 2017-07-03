package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/power-of-four/#/description
 */
public class PowerOfFourTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {

        public boolean isPowerOfFour(int num) {
            if (num == 1)
                return true;

            int start = 4;
            while (start > 0) {
                if (num == start)
                    return true;
                start <<= 2;
            }
            return false;
        }
    }
}
