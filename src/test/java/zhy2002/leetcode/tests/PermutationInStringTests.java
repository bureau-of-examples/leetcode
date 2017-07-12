package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/permutation-in-string/#/description
 */
public class PermutationInStringTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.checkInclusion("abb", "cbadbab"), equalTo(true));
        assertThat(solution.checkInclusion("ab", "cba"), equalTo(true));
        assertThat(solution.checkInclusion("ab", "bac"), equalTo(true));
    }

    public class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() == 0)
                return true;
            if (s2.length() < s1.length())
                return false;

            int[] frequency = new int[26];
            for (char ch : s1.toCharArray()) {
                frequency[ch - 'a']++;
            }

            int total = s1.length();
            int start = 0;
            for (int end = 0; end < s2.length(); end++) {
                char ch = s2.charAt(end);
                int count = frequency[ch - 'a']--;
                if (count > 0) {
                    total--;
                }
                if (end - start == s1.length()) {
                    count = frequency[s2.charAt(start++) - 'a']++;
                    if (count >= 0) {
                        total++;
                    }
                }
                if (total == 0)
                    return true;

            }
            return false;

        }
    }
}
