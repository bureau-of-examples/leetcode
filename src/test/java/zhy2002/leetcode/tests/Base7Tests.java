package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/base-7/#/description
 */
public class Base7Tests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public String convertToBase7(int num) {
            if (num == 0) {
                return "0";
            }

            boolean negative = num < 0;
            num = Math.abs(num);
            Stack<Character> digits = new Stack<>();
            while (num > 0) {
                int rem = num % 7;
                digits.push((char) (rem + '0'));
                num /= 7;
            }
            StringBuilder builder = new StringBuilder(digits.size());
            while (!digits.isEmpty()) {
                builder.append(digits.pop());
            }

            return negative ? "-" + builder.toString() : builder.toString();
        }
    }
}
