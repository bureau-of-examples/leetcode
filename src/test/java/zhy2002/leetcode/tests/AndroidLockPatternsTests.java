package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.androidunlockpatterns.BackTrackSolution;
import zhy2002.leetcode.solutions.androidunlockpatterns.EditorialSolution;
import zhy2002.leetcode.solutions.androidunlockpatterns.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AndroidLockPatternsTests {

    @Test
    public void editorialBasicTest() {
        basicTest(new EditorialSolution());
    }

    @Test
    public void backTrackBasicTest() {
        basicTest(new BackTrackSolution());
    }

    private void basicTest(Solution solution) {

        int result = solution.numberOfPatterns(1, 1);
        assertThat(result, equalTo(9));

        result = solution.numberOfPatterns(2, 2);
        assertThat(result, equalTo(56));

        result = solution.numberOfPatterns(1, 2);
        assertThat(result, equalTo(65));

        result = solution.numberOfPatterns(3, 3);
        assertThat(result, equalTo(320));

        result = solution.numberOfPatterns(4, 4);
        assertThat(result, equalTo(1624));

        result = solution.numberOfPatterns(5, 5);
        assertThat(result, equalTo(7152));

    }
}
