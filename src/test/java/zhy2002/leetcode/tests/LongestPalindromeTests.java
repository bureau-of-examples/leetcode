package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class LongestPalindromeTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.longestPalindrome("a"), equalTo(1));
        assertThat(solution.longestPalindrome("aa"), equalTo(2));
        assertThat(solution.longestPalindrome("baa"), equalTo(3));
        assertThat(solution.longestPalindrome("abccccdd"), equalTo(7));
    }

    public class Solution {
        public int longestPalindrome(String s) {
            Map<Character, Integer> counts = new HashMap<>();
            for (char ch : s.toCharArray()) {
                counts.put(ch, counts.getOrDefault(ch, 0) + 1);
            }

            int loneCount = 0;
            int wingCount = 0;
            for (int count : counts.values()) {
                wingCount += count / 2;
                loneCount += count % 2;
            }
            return wingCount * 2 + (loneCount > 0 ? 1 : 0);
        }
    }

}
