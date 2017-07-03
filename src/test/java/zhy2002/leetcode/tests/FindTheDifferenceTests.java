package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-the-difference/#/description
 */
public class FindTheDifferenceTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public char findTheDifference(String s, String t) {
            char[] counts = new char[26];
            for (char ch : t.toCharArray()) {
                counts[ch - 'a']++;
            }

            for (char ch : s.toCharArray()) {
                counts[ch - 'a']--;
            }

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    return (char) ('a' + i);
                }
            }
            throw new RuntimeException("No such char!");
        }
    }
}
