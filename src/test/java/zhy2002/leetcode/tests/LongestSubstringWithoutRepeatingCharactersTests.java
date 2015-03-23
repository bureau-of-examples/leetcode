package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.longestsubstringwithoutrepeatingcharaters.Solution;
import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        assertEquals(0,solution.lengthOfLongestSubstring(""));
        assertEquals(1,solution.lengthOfLongestSubstring("a"));
        assertEquals(1,solution.lengthOfLongestSubstring("aaaaaa"));
        assertEquals(2,solution.lengthOfLongestSubstring("ab"));
        assertEquals(2,solution.lengthOfLongestSubstring("aba"));
        assertEquals(3,solution.lengthOfLongestSubstring("abaca"));
        assertEquals(3,solution.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(2,solution.lengthOfLongestSubstring("abba"));
        assertEquals(3,solution.lengthOfLongestSubstring("abcba"));
        assertEquals(3,solution.lengthOfLongestSubstring("dvdf"));
    }

}
