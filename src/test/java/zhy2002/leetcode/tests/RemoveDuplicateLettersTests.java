package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 */
public class RemoveDuplicateLettersTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.removeDuplicateLetters("cbacdcbc"), equalTo("acdb"));
        assertThat(solution.removeDuplicateLetters("bcabc"), equalTo("abc"));
        assertThat(solution.removeDuplicateLetters("aba"), equalTo("ab"));
    }

    public class Solution {
        public String removeDuplicateLetters(String s) {
            int[] lastIndex = new int[26]; //last position of each char
            Arrays.fill(lastIndex, -1);
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';
                lastIndex[ch] = i;
            }

            boolean[] checkpoints = new boolean[s.length()]; //char at this position is the last.
            for (int i : lastIndex) {
                if (i != -1) {
                    checkpoints[i] = true;
                }
            }

            StringBuilder sb = new StringBuilder();
            int minIndex = -1;
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';
                if (lastIndex[ch] == -1)
                    continue;
                if (minIndex == -1 || s.charAt(minIndex) > s.charAt(i)) {
                    minIndex = i;
                }
                if (checkpoints[i]) {
                    sb.append(s.charAt(minIndex));
                    lastIndex[s.charAt(minIndex) - 'a'] = -1;
                    i = minIndex;
                    minIndex = -1;
                }
            }
            return sb.toString();
        }
    }

}
