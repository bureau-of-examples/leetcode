package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.wordpatternii.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WordPatternIITests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        boolean result = solution.wordPatternMatch("aa", "testtest");
        assertThat(result, equalTo(true));

        result = solution.wordPatternMatch("aa", "testtesta");
        assertThat(result, equalTo(false));

        result = solution.wordPatternMatch("ab", "testtesta");
        assertThat(result, equalTo(true));

        result = solution.wordPatternMatch("aba", "ttt");
        assertThat(result, equalTo(false));

        result = solution.wordPatternMatch("aba", "texte");
        assertThat(result, equalTo(true));

        result = solution.wordPatternMatch("abc", "ax");
        assertThat(result, equalTo(false));

        result = solution.wordPatternMatch("acda", "acsfqeffesacsf");
        assertThat(result, equalTo(true));

        result = solution.wordPatternMatch("acda", "acsfqqacsf");
        assertThat(result, equalTo(false));

        result = solution.wordPatternMatch("taaca", "testaaeaaefffaae");
        assertThat(result, equalTo(true));
    }
}
