package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.smallestrectangleenclosingblackpixels.Solution;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SmallestRectangleEnclosingBlackPixelsTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        int result = solution.minArea(new char[][]{{'1'}}, 0, 0);
        assertThat(result, equalTo(1));

        result = solution.minArea(new char[][]{"0010".toCharArray(), "0110".toCharArray(), "0100".toCharArray()}, 0, 2);
        assertThat(result, equalTo(6));

        result = solution.minArea(new char[][]{"0000".toCharArray(), "0000".toCharArray(), "0000".toCharArray(), "0001".toCharArray()}, 3, 3);
        assertThat(result, equalTo(1));

        result = solution.minArea(new char[][]{"0000".toCharArray(), "0000".toCharArray(), "0001".toCharArray(), "0001".toCharArray()}, 3, 3);
        assertThat(result, equalTo(2));

        result = solution.minArea(new char[][]{"0000".toCharArray(), "0001".toCharArray(), "0001".toCharArray(), "0001".toCharArray()}, 1, 3);
        assertThat(result, equalTo(3));

        result = solution.minArea(new char[][]{"0000".toCharArray(), "0011".toCharArray(), "0001".toCharArray(), "0001".toCharArray()}, 1, 3);
        assertThat(result, equalTo(6));

        result = solution.minArea(new char[][]{"0000".toCharArray(), "0110".toCharArray(), "0110".toCharArray(), "0000".toCharArray()}, 1, 2);
        assertThat(result, equalTo(4));

        result = solution.minArea(new char[][]{"0000".toCharArray(), "1110".toCharArray(), "0110".toCharArray(), "0000".toCharArray()}, 1, 2);
        assertThat(result, equalTo(6));

    }
}
