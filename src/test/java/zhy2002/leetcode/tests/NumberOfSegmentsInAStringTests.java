package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/#/description
 */
public class NumberOfSegmentsInAStringTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int countSegments(String s) {
            int count = 0;
            boolean lastIsSpace = true;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isWhitespace(s.charAt(i))) {
                    lastIsSpace = true;
                } else {
                    if (lastIsSpace) {
                        count += 1;
                        lastIsSpace = false;
                    }
                }
            }
            return count;
        }
    }

}
