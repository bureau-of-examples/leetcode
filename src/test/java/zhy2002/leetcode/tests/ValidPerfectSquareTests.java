package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/valid-perfect-square/#/description
 */
public class ValidPerfectSquareTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public boolean isPerfectSquare(int num) {
            if (num == 1)
                return true;
            int start = 0;
            int end = num/2;

            while (start <= end) {
                int mid = (start + end) >>> 1;
                long prod = (long)mid * mid;
                if (prod == num)
                    return true;
                if (prod > num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            return false;
        }
    }

}
