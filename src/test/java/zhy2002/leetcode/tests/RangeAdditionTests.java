package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.rangeaddition.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RangeAdditionTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        int[] result = solution.getModifiedArray(4, new int[][]{});
        assertThat(result, equalTo(new int[]{0, 0, 0, 0}));

        result = solution.getModifiedArray(4, new int[][]{{0, 1, 2}, {1, 2, 3}});
        assertThat(result, equalTo(new int[]{2, 5, 3, 0}));

        result = solution.getModifiedArray(4, new int[][]{{0, 1, 2}, {1, 2, 3}, {3, 3, 4}});
        assertThat(result, equalTo(new int[]{2, 5, 3, 4}));

        result = solution.getModifiedArray(5, new int[][]{{0, 4, 2}, {2, 4, 3}});
        assertThat(result, equalTo(new int[]{2, 2, 5, 5, 5}));

        result = solution.getModifiedArray(5, new int[][]{{0, 4, 2}, {2, 4, 3}, {1, 3, -1}});
        assertThat(result, equalTo(new int[]{2, 1, 4, 4, 5}));
    }

}
