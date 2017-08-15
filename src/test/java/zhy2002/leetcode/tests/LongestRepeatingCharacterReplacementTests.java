package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/discuss/
 */
public class LongestRepeatingCharacterReplacementTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.characterReplacement("AABABBA", 1),
                equalTo(4)
        );
        assertThat(
                solution.characterReplacement("ABAB", 2),
                equalTo(4)
        );
    }

    public class Solution {
        public int characterReplacement(String s, int k) {
            int[] counts = new int[26];
            int start = 0, maxCount = 0, maxLength = 0;
            for (int end = 0; end < s.length(); end++) {//inclusive
                int len = end - start + 1;
                maxCount = Math.max(maxCount, ++counts[s.charAt(end) - 'A']);
                if (len - maxCount > k) {
                    counts[s.charAt(start++) - 'A']--;
                } else {
                    maxLength = Math.max(maxLength, len);
                }
            }
            return maxLength;
        }
    }
}
