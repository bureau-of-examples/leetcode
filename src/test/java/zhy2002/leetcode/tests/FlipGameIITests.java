package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.flipgameii.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FlipGameIITests {


    @Test
    public void basicTest(){

        Solution solution = new Solution();
        boolean result = solution.canWin("++++");
        assertThat(result, equalTo(true));

        result = solution.canWin("-++++--");
        assertThat(result, equalTo(true));

        result = solution.canWin("-+++++--+");
        assertThat(result, equalTo(false));

        result = solution.canWin("-++++++++");
        assertThat(result, equalTo(true));

    }
}
