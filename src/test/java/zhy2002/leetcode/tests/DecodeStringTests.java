package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/decode-string/#/description
 */
public class DecodeStringTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.decodeString("jk3[a2[c]]2[d]"), equalTo("jkaccaccaccdd"));
        assertThat(solution.decodeString("3[a2[c]]2[d]"), equalTo("accaccaccdd"));
        assertThat(solution.decodeString("3[a]2[d]"), equalTo("aaadd"));
        assertThat(solution.decodeString("3[a]d"), equalTo("aaad"));
        assertThat(solution.decodeString("3[a]"), equalTo("aaa"));
        assertThat(solution.decodeString("abcd"), equalTo("abcd"));


    }

    public class Solution {

        private int start = 0;

        public String decodeString(String s) {
            start = 0;
            return solve(s, 1);
        }

        private String solve(String s, int repeat) {
            String result = "";
            while (start < s.length() && s.charAt(start) != ']') {
                char ch = s.charAt(start);
                if (isDigit(ch)) {
                    int end = start + 1;
                    while (isDigit(s.charAt(end))) {
                        end++;
                    }
                    int count = Integer.parseInt(s.substring(start, end));
                    start = end;
                    assert s.charAt(start) == '[';
                    start++;
                    result += solve(s, count);
                    assert s.charAt(start) == ']';
                    start++;
                } else if (ch != ']') {
                    int end = start + 1;
                    while (end < s.length() && !isDigit(s.charAt(end)) && s.charAt(end) != ']') {
                        end++;
                    }
                    result += s.substring(start, end);
                    start = end;
                }
            }
            return repeat(result, repeat);

        }

        private boolean isDigit(char ch) {
            return ch >= '0' && ch <= '9';
        }

        private String repeat(String s, int repeat) {
            String result = "";
            while (repeat-- > 0) {
                result += s;
            }
            return result;
        }
    }

}
