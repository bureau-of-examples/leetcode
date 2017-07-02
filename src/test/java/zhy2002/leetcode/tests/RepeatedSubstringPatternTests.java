package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class RepeatedSubstringPatternTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public boolean repeatedSubstringPattern(String s) {
            for (int len = 1; len <= s.length() / 2; len++) {
                if (len == 1 || s.length() % len == 0) {
                    if (verify(s, len))
                        return true;
                }
            }
            return false;
        }

        private boolean verify(String s, int len) {
            for (int i = len; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(i - len))
                    return false;
            }
            return true;
        }
    }

}
