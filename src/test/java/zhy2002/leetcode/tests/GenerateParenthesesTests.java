package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.generateparentheses.Solution;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class GenerateParenthesesTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertTrue(Arrays.equals(new String[]{"()"},  solution.generateParenthesis(1).toArray()));
        assertTrue(Arrays.equals(new String[]{"(())", "()()"},  solution.generateParenthesis(2).toArray()));
        assertTrue(Arrays.equals(new String[]{"((()))", "(()())","(())()","()(())","()()()"},  solution.generateParenthesis(3).toArray()));
    }
}
