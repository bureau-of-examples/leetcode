package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/detect-capital/#/description
 */
public class DetectCapitalTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public boolean detectCapitalUse(String word) {
            boolean firstUpper = Character.isUpperCase(word.charAt(0));
            boolean hasUpper = false;
            boolean hasLower = false;
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    hasUpper = true;
                } else {
                    hasLower = true;
                }
            }
            return firstUpper && (!hasLower || !hasUpper) || !firstUpper && !hasUpper;
        }
    }

}
