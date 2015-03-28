package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.regularexpressionmatching.DpSolution;
import zhy2002.leetcode.solutions.regularexpressionmatching.RecursiveSolution;
import zhy2002.leetcode.solutions.regularexpressionmatching.Solution;

import static org.junit.Assert.*;

public class RegularExpressionMatchingTests {

    @Test
    public void dpDotTest(){
        dotTest(new DpSolution());
    }

    @Test
    public void dpStarTest(){
        starTest(new DpSolution());
    }

    @Test
    public void dpDotStarTest(){
        dotStarTest(new DpSolution());
    }

    @Test
    public void recursiveDotTest(){
        dotTest(new RecursiveSolution());
    }

    @Test
    public void recursiveStarTest(){
        starTest(new RecursiveSolution());
    }

    @Test
    public void recursiveDotStarTest(){
        dotStarTest(new RecursiveSolution());
    }

    private void dotTest(Solution solution){

        assertTrue(solution.isMatch("", ""));
        assertTrue(solution.isMatch("b", "."));
        assertTrue(solution.isMatch("ba", ".a"));
        assertTrue(solution.isMatch("ab", "a."));
        assertFalse(solution.isMatch("abc", "a."));
        assertTrue(solution.isMatch("abc", "a.c"));
        assertTrue(solution.isMatch("abc", "..."));
    }

    private void starTest(Solution solution){
        assertTrue(solution.isMatch("", "a*"));
        assertTrue(solution.isMatch("a", "a*"));
        assertTrue(solution.isMatch("aa", "a*"));
        assertTrue(solution.isMatch("b", "ba*"));
        assertTrue(solution.isMatch("ba", "ba*"));
        assertTrue(solution.isMatch("baa", "ba*"));
        assertTrue(solution.isMatch("b", "a*b"));
        assertTrue(solution.isMatch("ab", "a*b"));
        assertTrue(solution.isMatch("aab", "a*b"));
        assertTrue(solution.isMatch("fb", "fa*b"));
        assertTrue(solution.isMatch("fab", "fa*b"));
        assertTrue(solution.isMatch("faab", "fa*b"));
        assertFalse(solution.isMatch("aaba", "ab*a*c*a"));
        assertTrue(solution.isMatch("aab", "c*a*b"));
    }

    private void dotStarTest(Solution solution){

        assertTrue(solution.isMatch("ab", ".*"));
        assertTrue(solution.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
        assertTrue(solution.isMatch("aabbcbcacbacaaccacc", "c*b*b*.*.*.*a*.*"));
        assertTrue(solution.isMatch("bacacbacaaabccbcbaa", "a*.c*c*c*a*b*..*"));
    }
}
