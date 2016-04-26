package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.longestsubstringwithatmostkdistinctcharacters.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class LongestSubstringWithAtMostKDistinctCharactersTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertThat(solution.lengthOfLongestSubstringKDistinct("", 1), equalTo(0));
        assertThat(solution.lengthOfLongestSubstringKDistinct("abcdef", 0), equalTo(0));
        assertThat(solution.lengthOfLongestSubstringKDistinct("abcdef", 1), equalTo(1));
        assertThat(solution.lengthOfLongestSubstringKDistinct("aaaa", 1), equalTo(4));
        assertThat(solution.lengthOfLongestSubstringKDistinct("baaaab", 1), equalTo(4));
        assertThat(solution.lengthOfLongestSubstringKDistinct("baaaab", 2), equalTo(6));
        assertThat(solution.lengthOfLongestSubstringKDistinct("baaaacc", 2), equalTo(6));
        assertThat(solution.lengthOfLongestSubstringKDistinct("baadaaccb", 2), equalTo(5));
        assertThat(solution.lengthOfLongestSubstringKDistinct("baadeaaccb", 2), equalTo(4));
        assertThat(solution.lengthOfLongestSubstringKDistinct("baadeaaccb", 3), equalTo(6));
    }

    @Test
    public void failedTest() {
        Solution solution = new Solution();
        assertThat(solution.lengthOfLongestSubstringKDistinct("abaccc", 2), equalTo(4));
        assertThat(solution.lengthOfLongestSubstringKDistinct("dabacccd", 2), equalTo(4));
    }
}
