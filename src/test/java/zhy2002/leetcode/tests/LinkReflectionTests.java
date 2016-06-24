package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.linereflection.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LinkReflectionTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        boolean result = solution.isReflected(new int[][]{});
        assertThat(result, equalTo(true));

        result = solution.isReflected(new int[][]{{1, 1}});
        assertThat(result, equalTo(true));

        result = solution.isReflected(new int[][]{{1, 1}, {2, 1}});
        assertThat(result, equalTo(true));

        result = solution.isReflected(new int[][]{{1, 1}, {2, 1}, {3, 1}});
        assertThat(result, equalTo(true));

        result = solution.isReflected(new int[][]{{1, 1}, {2, 1}, {3, 1}, {-1, 2}});
        assertThat(result, equalTo(false));

        result = solution.isReflected(new int[][]{{1, 1}, {2, 1}, {3, 1}, {-1, 2}, {4, 2}});
        assertThat(result, equalTo(false));

        result = solution.isReflected(new int[][]{{1, 1}, {2, 1}, {3, 1}, {-1, 2}, {5, 2}});
        assertThat(result, equalTo(true));

        result = solution.isReflected(new int[][]{{1, 1}, {2, 10}, {2, 1}, {3, 1}, {-1, 2}, {5, 2}});
        assertThat(result, equalTo(true));

        result = solution.isReflected(new int[][]{{1, 1}, {2, 10}, {2, 1}, {3, 1}, {-1, 2}, {5, 2}, {3, 7}});
        assertThat(result, equalTo(false));

    }
}
