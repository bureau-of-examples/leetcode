package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.longestvalidparentheses.*;

import static org.junit.Assert.*;

public class LongestValidParenthesesTests {

    @Test
    public void mergeBasicTest(){
        basicTest(new MergeSolution());
    }

    @Test
    public void countingBasicTest(){
        basicTest(new CountingSolution());
    }

    @Test
    public void stackBasicTest(){
        basicTest(new StackSolution());
    }

    private void basicTest(Solution solution ){


        assertEquals(2,solution.longestValidParentheses("()"));
        assertEquals(4,solution.longestValidParentheses("()()"));
        assertEquals(8,solution.longestValidParentheses("(()(()))"));
        assertEquals(8,solution.longestValidParentheses(")(()(()))"));
        assertEquals(4,solution.longestValidParentheses("(()))))"));
        assertEquals(4,solution.longestValidParentheses(")))(()))))"));
        assertEquals(2,solution.longestValidParentheses("))(()(("));
        assertEquals(4,solution.longestValidParentheses("((())(()"));
        assertEquals(4,solution.longestValidParentheses("((())(()"));
        assertEquals(10,solution.longestValidParentheses("(()()()())"));
        assertEquals(10,solution.longestValidParentheses("(()()()()))())"));
        assertEquals(4,solution.longestValidParentheses("(()((()((())"));
        assertEquals(8,solution.longestValidParentheses("(((()))))"));
    }
}
