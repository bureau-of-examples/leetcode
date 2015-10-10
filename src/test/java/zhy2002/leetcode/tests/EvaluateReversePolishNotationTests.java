package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.evaluatereversepolishnotation.Solution;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class EvaluateReversePolishNotationTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        assertThat(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}), equalTo(9));
        assertThat(solution.evalRPN(new String[]{"4", "13", "5", "/", "+"}), equalTo(6));

    }
}
