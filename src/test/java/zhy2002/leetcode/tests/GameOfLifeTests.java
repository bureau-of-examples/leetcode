package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.gameoflife.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GameOfLifeTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        int[][] board = {{}};
        solution.gameOfLife(board);
        assertThat(Utils.intMatrixToString(board), equalTo(""));

        board = new int[][]{{1}};
        solution.gameOfLife(board);
        assertThat(Utils.intMatrixToString(board), equalTo("0"));

        board = new int[][]{
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };
        solution.gameOfLife(board);
        assertThat(Utils.intMatrixToString(board), equalTo("1,0,1 0,0,0 1,0,1"));
    }
}
