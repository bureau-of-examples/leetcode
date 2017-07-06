package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/complex-number-multiplication/#/description
 */
public class ComplexNumberMultiplicationTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public String complexNumberMultiply(String a, String b) {
            int[] numberA = parse(a);
            int[] numberB = parse(b);

            int n = numberA[0] * numberB[0] - numberA[1] * numberB[1];
            int i = numberA[0] * numberB[1] + numberA[1] * numberB[0];
            return String.format("%d+%di", n, i);

        }

        private int[] parse(String num) {
            String[] parts = num.substring(0, num.length() - 1).split("\\+");
            return new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
        }
    }

}
