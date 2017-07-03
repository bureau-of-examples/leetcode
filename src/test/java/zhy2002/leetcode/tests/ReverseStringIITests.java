package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/reverse-string-ii/#/description
 */
public class ReverseStringIITests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.reverseStr("abcd", 100), equalTo("dcba"));
        assertThat(solution.reverseStr("abcd", 3), equalTo("cbad"));
        assertThat(solution.reverseStr("abcdefg", 2), equalTo("bacdfeg"));
        assertThat(solution.reverseStr("abcdefg", 3), equalTo("cbadefg"));
    }

    public class Solution {
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            int start = 0, end = k - 1;
            while (true) {
                if (start >= s.length())
                    break;

                if (end >= s.length()) {
                    end = s.length() - 1;
                    reverse(chars, start, end);
                    break;
                }

                reverse(chars, start, end);
                start += 2 * k;
                end = start + k - 1;
            }
            return new String(chars);
        }

        private void reverse(char[] chars, int start, int end) {
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
    }
}
