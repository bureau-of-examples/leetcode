package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/one-edit-distance/#/description
 */
public class OneEditDistance2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.isOneEditDistance("abcda", "abcaaa"), equalTo(false));
    }

    public class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if (Math.abs(s.length() - t.length()) >= 2)
                return false;

            if (s.length() == t.length()) {
                return differByOne(s, t);
            }

            return s.length() > t.length() ? oneExtra(t, s) : oneExtra(s, t);
        }

        private boolean differByOne(String s, String t) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i))
                    count++;
            }
            return count == 1;
        }

        private boolean oneExtra(String shorter, String longer) {
            boolean skipped = false;
            int j = 0;
            for (int i = 0; i < shorter.length(); i++) {
                if (shorter.charAt(i) != longer.charAt(j)) {
                    if (skipped)
                        return false;
                    j++;
                    i--;
                    skipped = true;
                } else {
                    j++;
                }

            }
            return true;
        }
    }

}
