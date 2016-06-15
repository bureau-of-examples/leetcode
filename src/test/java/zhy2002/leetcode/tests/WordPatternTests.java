package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.wordpattern.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WordPatternTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        assertThat(solution.wordPattern("a", "test"), equalTo(true));
        assertThat(solution.wordPattern("aa", "test test"), equalTo(true));
        assertThat(solution.wordPattern("aa", "test tes"), equalTo(false));
        assertThat(solution.wordPattern("aba", "test tes test"), equalTo(true));
        assertThat(solution.wordPattern("abac", "test tes test tes"), equalTo(false));
        assertThat(solution.wordPattern("abab", "test tes test tes"), equalTo(true));
        assertThat(solution.wordPattern("abba", "dog cat cat fish"), equalTo(false));
    }
}
