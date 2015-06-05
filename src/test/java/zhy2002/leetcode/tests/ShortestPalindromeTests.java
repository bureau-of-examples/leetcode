package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.shortestpalindrome.Solution;
import static org.junit.Assert.*;

public class ShortestPalindromeTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

       assertEquals("aaacecaaa", solution.shortestPalindrome("aacecaaa"));
       assertEquals("dcbabcd", solution.shortestPalindrome("abcd"));
       assertEquals("aa", solution.shortestPalindrome("aa"));
       assertEquals("aaa", solution.shortestPalindrome("aaa"));
       assertEquals("aabaa", solution.shortestPalindrome("abaa"));
    }
}
