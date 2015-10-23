package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.numberofdigitone.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CountDigitOneTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        assertThat(solution.countDigitOne(0), equalTo(0));
        assertThat(solution.countDigitOne(1), equalTo(1));
        assertThat(solution.countDigitOne(10), equalTo(2));
        assertThat(solution.countDigitOne(13), equalTo(6));
        assertThat(solution.countDigitOne(19), equalTo(12));
        assertThat(solution.countDigitOne(20), equalTo(12));
        assertThat(solution.countDigitOne(26), equalTo(13));
        assertThat(solution.countDigitOne(99), equalTo(20));
        assertThat(solution.countDigitOne(100), equalTo(21));
        assertThat(solution.countDigitOne(101), equalTo(23));
        assertThat(solution.countDigitOne(110), equalTo(33));
        assertThat(solution.countDigitOne(111), equalTo(36));
        assertThat(solution.countDigitOne(120), equalTo(53));
    }
}
