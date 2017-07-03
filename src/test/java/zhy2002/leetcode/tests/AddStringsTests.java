package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/add-strings/#/description
 */
public class AddStringsTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.addStrings("0", "0"), equalTo("0"));
        assertThat(solution.addStrings("9", "99"), equalTo("108"));
        assertThat(solution.addStrings("9", "999"), equalTo("1008"));
    }

    public class Solution {
        public String addStrings(String num1, String num2) {
            int index1 = num1.length() - 1;
            int index2 = num2.length() - 1;
            Stack<Character> chars = new Stack<>();
            int carry = 0;
            while (index1 >= 0 || index2 >= 0 || carry != 0) {
                int digit1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
                int digit2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
                int sum = digit1 + digit2 + carry;
                chars.push((char) ((sum % 10) + '0'));
                carry = sum / 10;
                index1--;
                index2--;
            }
            return build(chars);
        }

        private String build(Stack<Character> chars) {
            StringBuilder stringBuilder = new StringBuilder();
            while (!chars.isEmpty()) {
                stringBuilder.append(chars.pop());
            }
            return stringBuilder.toString();
        }
    }
}
