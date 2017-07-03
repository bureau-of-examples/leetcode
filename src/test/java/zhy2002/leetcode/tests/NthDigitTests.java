package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/nth-digit/#/description
 */
public class NthDigitTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findNthDigit(2147483647), equalTo(2));
        assertThat(solution.findNthDigit(1000), equalTo(3));
        assertThat(solution.findNthDigit(1), equalTo(1));
        assertThat(solution.findNthDigit(9), equalTo(9));
        assertThat(solution.findNthDigit(10), equalTo(1));
        assertThat(solution.findNthDigit(11), equalTo(0));

    }

    public class Solution {
        public int findNthDigit(int n) {
            long temp = n;
            int len = 1;
            int start = 1;
            long count = 9;

            while (true) {
                if (temp <= count * len) {
                    return findDigit(temp, start, len);
                }
                temp -= count * len;
                start *= 10;
                count *= 10;
                len++;
            }
        }

        private int findDigit(long d, int start, int len) {
            int i = (int)((d - 1) / len);
            int j = (int)((d - 1) % len);
            return String.valueOf(start + i).charAt(j) - '0';
        }
    }
}
