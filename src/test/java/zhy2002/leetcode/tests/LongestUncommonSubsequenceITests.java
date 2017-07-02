package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/#/description
 */
public class LongestUncommonSubsequenceITests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int findLUSlength(String a, String b) {
            if (a.length() != b.length()) {
                return Math.max(a.length(), b.length());
            }

            return a.equals(b) ? 0 : a.length();
        }
    }
}