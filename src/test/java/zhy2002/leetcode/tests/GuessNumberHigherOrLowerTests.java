package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.guessnumberhigherorlower.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GuessNumberHigherOrLowerTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        solution.setTarget(1);
        assertThat(solution.guessNumber(1), equalTo(1));

        solution.setTarget(2);
        assertThat(solution.guessNumber(3), equalTo(2));

        solution.setTarget(3);
        assertThat(solution.guessNumber(3), equalTo(3));

        solution.setTarget(3);
        assertThat(solution.guessNumber(4), equalTo(3));

        solution.setTarget(2);
        assertThat(solution.guessNumber(4), equalTo(2));

        solution.setTarget(78978432);
        assertThat(solution.guessNumber(Integer.MAX_VALUE), equalTo(78978432));
    }
}
