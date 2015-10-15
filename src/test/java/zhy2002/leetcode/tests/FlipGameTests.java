package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.flipgame.Solution;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class FlipGameTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        List<String> result = solution.generatePossibleNextMoves("++++");

        assertThat(result, equalTo(Arrays.asList("--++", "+--+", "++--")));

        result = solution.generatePossibleNextMoves("");

        assertThat(result, hasSize(0));
    }
}
