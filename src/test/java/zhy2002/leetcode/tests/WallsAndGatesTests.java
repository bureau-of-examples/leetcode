package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.wallsandgates.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class WallsAndGatesTests {

    private static final int INF = Integer.MAX_VALUE;

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        int[][] input = new int[][]{{0, INF, -1}};
        solution.wallsAndGates(input);
        assertThat(Utils.intMatrixToString(input), equalTo("0,1,-1"));

        input = new int[][]{{0, INF, -1}, {INF, -1, 0}};
        solution.wallsAndGates(input);
        assertThat(Utils.intMatrixToString(input), equalTo("0,1,-1 1,-1,0"));

        input = new int[][]{{INF, -1, 0, INF}, {INF, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF}};
        solution.wallsAndGates(input);
        assertThat(Utils.intMatrixToString(input), equalTo("3,-1,0,1 2,2,1,-1 1,-1,2,-1 0,-1,3,4"));

        input = new int[][]{{-1, -1, -1}, {-1, 0, -1}, {-1, -1, -1}, {INF, INF, INF}};
        solution.wallsAndGates(input);
        assertThat(Utils.intMatrixToString(input), equalTo("-1,-1,-1 -1,0,-1 -1,-1,-1 2147483647,2147483647,2147483647"));

        input = new int[][]{{-1, -1, -1}, {-1, 0, -1}, {-1, -1, 0}, {INF, INF, INF}};
        solution.wallsAndGates(input);
        assertThat(Utils.intMatrixToString(input), equalTo("-1,-1,-1 -1,0,-1 -1,-1,0 3,2,1"));

        input = new int[][] { {INF, 0, INF, INF, 0, INF, -1, INF} };
        solution.wallsAndGates(input);
        assertThat(Utils.intMatrixToString(input), equalTo("1,0,1,1,0,1,-1,2147483647"));
    }
}
