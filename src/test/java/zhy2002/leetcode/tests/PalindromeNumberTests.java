package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.palindromenumber.LogSolution;
import zhy2002.leetcode.solutions.palindromenumber.Solution;
import static org.junit.Assert.*;

public class PalindromeNumberTests {

    @Test
    public void basicTest(){
        Solution solution = new LogSolution();
        assertEquals(true,solution.isPalindrome(0));
        assertEquals(true, solution.isPalindrome(1));
        assertEquals(true, solution.isPalindrome(11));
        assertEquals(true, solution.isPalindrome(121));
        assertEquals(true,solution.isPalindrome(1221));
        assertEquals(true, solution.isPalindrome(93539));
        assertEquals(false, solution.isPalindrome(162));
        assertEquals(false, solution.isPalindrome(17));
        assertEquals(false, solution.isPalindrome(10));
        assertEquals(false, solution.isPalindrome(100));
    }
}
