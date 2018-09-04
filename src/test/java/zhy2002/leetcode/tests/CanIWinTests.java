package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.caniwin.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CanIWinTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.canIWin(20, 210), equalTo(false));
        assertThat(solution.canIWin(10, 40), equalTo(false));
        assertThat(solution.canIWin(10, 11), equalTo(false));
    }
}
