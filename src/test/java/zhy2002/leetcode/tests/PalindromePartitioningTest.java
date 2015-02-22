package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.palindromepartitioning.Solution;

import java.util.List;

import static org.junit.Assert.*;

/**
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioningTest {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        List<List<String>> result = solution.partition("aab");
        assertEquals(2, result.size());

        result = solution.partition("aaa");
        assertEquals(4, result.size());

        result = solution.partition("aaaa");
        assertEquals(8, result.size());

        result = solution.partition("abba");
        assertEquals(3, result.size());
    }
}
