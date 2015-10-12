package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.compareversionnumbers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class CompareVersionNumbersTests {

    @Test
    public void indexOfTest() {
        basicTest(new IndexOfSolution());
    }

    @Test
    public void splitTest() {
        basicTest(new SplitSolution());
    }

    public void basicTest(Solution solution) {

        assertThat(solution.compareVersion("1", "1"), equalTo(0));
        assertThat(solution.compareVersion("1.1", "1.12"), equalTo(-1));
        assertThat(solution.compareVersion("1.1.321", "1.1.4"), equalTo(1));
        assertThat(solution.compareVersion("1.1.4.1", "1.1.4"), equalTo(1));
        assertThat(solution.compareVersion("1.09", "1.10"), equalTo(-1));
        assertThat(solution.compareVersion("1", "1.00"), equalTo(0));
    }
}
