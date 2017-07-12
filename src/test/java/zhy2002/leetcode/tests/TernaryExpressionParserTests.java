package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/ternary-expression-parser/#/description
 */
public class TernaryExpressionParserTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(solution.parseTernary("T?T?F:5:3"), equalTo("F"));
        assertThat(solution.parseTernary("F?1:T?4:5"), equalTo("4"));
        assertThat(solution.parseTernary("T?2:3"), equalTo("2"));

    }

    public class Solution {
        private int start;

        public String parseTernary(String expression) {
            start = 0;
            return eval(expression);
        }

        private String eval(String expression) {
            char ch = expression.charAt(start);
            start++;
            if (start < expression.length() && expression.charAt(start) == '?') {
                start++;
                String left = eval(expression);
                assert expression.charAt(start) == ':';
                start++;
                String right = eval(expression);
                return ch == 'T' ? left : right;
            } else {
                return String.valueOf(ch);
            }
        }
    }
}
