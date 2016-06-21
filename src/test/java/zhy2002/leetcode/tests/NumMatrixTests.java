package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.rangesumquery2dmutable.NumMatrix;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumMatrixTests {

    @Test
    public void basicTest() {

        //check no exception
        NumMatrix numMatrix = new NumMatrix(new int[][]{});

        numMatrix = new NumMatrix(new int[][]{{1}});
        assertThat(numMatrix.sumRegion(0, 0, 0, 0), equalTo(1));

        numMatrix.update(0, 0, 17);
        assertThat(numMatrix.sumRegion(0, 0, 0, 0), equalTo(17));

        numMatrix = new NumMatrix(new int[][]{{1, 2, 3}});
        assertThat(numMatrix.sumRegion(0, 0, 0, 2), equalTo(6));

        numMatrix.update(0, 0, 7);
        assertThat(numMatrix.sumRegion(0, 0, 0, 2), equalTo(12));

        numMatrix.update(0, 1, 9);
        assertThat(numMatrix.sumRegion(0, 0, 0, 2), equalTo(19));

        numMatrix.update(0, 2, 13);
        assertThat(numMatrix.sumRegion(0, 0, 0, 2), equalTo(29));

        numMatrix = new NumMatrix(new int[][]{{1}, {2}, {3}});
        assertThat(numMatrix.sumRegion(0, 0, 2, 0), equalTo(6));

        numMatrix.update(0, 0, 7);
        assertThat(numMatrix.sumRegion(0, 0, 2, 0), equalTo(12));

        numMatrix.update(1, 0, 9);
        assertThat(numMatrix.sumRegion(0, 0, 2, 0), equalTo(19));

        numMatrix.update(2, 0, 13);
        assertThat(numMatrix.sumRegion(0, 0, 2, 0), equalTo(29));

        assertThat(numMatrix.sumRegion(0, 0, 1, 0), equalTo(16));

        numMatrix = new NumMatrix(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        assertThat(numMatrix.sumRegion(0, 1, 1, 2), equalTo(16));
        assertThat(numMatrix.sumRegion(1, 1, 2, 1), equalTo(13));
        assertThat(numMatrix.sumRegion(0, 1, 2, 2), equalTo(33));

        numMatrix.update(0, 1, 4);
        assertThat(numMatrix.sumRegion(0, 1, 2, 2), equalTo(35));

        numMatrix.update(2, 0, 5);
        assertThat(numMatrix.sumRegion(0, 0, 2, 2), equalTo(45));

        numMatrix = new NumMatrix(new int[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                {1, 2, 3, 4, 5, 6, 7, 8, 9}
        });
        assertThat(numMatrix.sumRegion(0, 0, 1, 1), equalTo(6));
        assertThat(numMatrix.sumRegion(2, 5, 4, 8), equalTo(90));

        numMatrix.update(4, 8, 19);
        assertThat(numMatrix.sumRegion(2, 5, 4, 8), equalTo(100));

        numMatrix.update(1, 3, 14);
        assertThat(numMatrix.sumRegion(0, 2, 2, 6), equalTo(85));
    }
}
