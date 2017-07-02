package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/perfect-number/#/description
 */
public class PerfectNumberTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public boolean checkPerfectNumber(int num) {
            if (num <= 1)
                return false;

            int sum = 1;
            int sqrt = (int)Math.sqrt(num);
            for (int i = 2; i <= sqrt; i++) {
                if (num % i == 0) {
                    sum += i;
                    if (i != num / i)
                        sum += num / i;
                }
            }

            return sum == num;
        }
    }

}
