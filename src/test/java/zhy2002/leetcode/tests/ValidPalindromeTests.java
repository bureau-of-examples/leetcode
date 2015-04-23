package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.validpalindrome.Solution;
import static org.junit.Assert.*;

public class ValidPalindromeTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(true,solution.isPalindrome(""));
        assertEquals(true,solution.isPalindrome("A man, a plan, a canal: Panama"));
        assertEquals(true,solution.isPalindrome("A23   BB///32A"));
        assertEquals(false,solution.isPalindrome("A23   BdBb///32A"));

    }
}
