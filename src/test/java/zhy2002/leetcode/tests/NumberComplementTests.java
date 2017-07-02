package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/number-complement/#/description
 */
public class NumberComplementTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findComplement(5), equalTo(2));
        assertThat(solution.findComplement(1), equalTo(0));
        assertThat(solution.findComplement(2), equalTo(1));
    }

    public class Solution {
        public int findComplement(int num) {
            int temp = num;
            int mask = 1;
            int result = 0;

            while (temp > 0) {
                int bit = num & mask;
                bit ^= mask;
                if (bit > 0) {
                    result |= bit;
                }
                temp >>>= 1;
                mask <<= 1;
            }
            return result;

        }
    }

}
