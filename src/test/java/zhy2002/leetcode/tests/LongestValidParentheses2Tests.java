package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/#/description
 */
public class LongestValidParentheses2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.longestValidParentheses("(()"), equalTo(2));
        assertThat(solution.longestValidParentheses("(()(((()"), equalTo(2));
        assertThat(solution.longestValidParentheses("((()))())"), equalTo(8));
        assertThat(solution.longestValidParentheses("()(()"), equalTo(2));
        assertThat(solution.longestValidParentheses("(()))"), equalTo(4));
        assertThat(solution.longestValidParentheses(")()())"), equalTo(4));

    }

    public class Solution {
        public int longestValidParentheses(String s) {
            return Math.max(getMax(s), getMax(mirror(s)));
        }

        private String mirror(String s) {
            char[] array = s.toCharArray();
            int start = 0;
            int end = array.length - 1;
            while (start < end) {
                char temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] == ')' ? '(' : ')';
            }
            return new String(array);
        }

        private int getMax(String s) {
            int max = 0;
            int openCount = 0;
            int closeCount = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    openCount++;
                } else {
                    closeCount++;
                }
                if (closeCount == openCount) {
                    max = Math.max(max, closeCount * 2);
                } else if (closeCount > openCount) {
                    closeCount = 0;
                    openCount = 0;
                }
            }
            return max;
        }
    }

}
