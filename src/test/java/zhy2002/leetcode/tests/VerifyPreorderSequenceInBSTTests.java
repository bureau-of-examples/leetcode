package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.verifypreordersequenceinbst.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class VerifyPreorderSequenceInBSTTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        assertThat(solution.verifyPreorder(new int[]{}), equalTo(true));
        assertThat(solution.verifyPreorder(new int[]{10}), equalTo(true));
        assertThat(solution.verifyPreorder(new int[]{10, 5}), equalTo(true));
        assertThat(solution.verifyPreorder(new int[]{10, 5, 20}), equalTo(true));
        assertThat(solution.verifyPreorder(new int[]{10, 5, 1,2, 20}), equalTo(true));
        assertThat(solution.verifyPreorder(new int[]{10, 5, 1,2, 20, 25}), equalTo(true));
        assertThat(solution.verifyPreorder(new int[]{10, 5, 1,2, 20, 25, 22}), equalTo(true));
        assertThat(solution.verifyPreorder(new int[]{10, 5, 1,2, 20, 25, 11}), equalTo(false));
        assertThat(solution.verifyPreorder(new int[]{10, 5, 1,2, 20, 25, 22,30,21}), equalTo(false));
    }
}
