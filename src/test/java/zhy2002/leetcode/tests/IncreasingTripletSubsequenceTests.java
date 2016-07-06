package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.increasingtripletsebsequence.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class IncreasingTripletSubsequenceTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertThat(solution.increasingTriplet(new int[]{}), equalTo(false));
        assertThat(solution.increasingTriplet(new int[]{1, 1, 1, 1}), equalTo(false));
        assertThat(solution.increasingTriplet(new int[]{1, 1, 2, 1, 1, 5}), equalTo(true));
        assertThat(solution.increasingTriplet(new int[]{1, 2, 2, 1, 1}), equalTo(false));

    }
}
