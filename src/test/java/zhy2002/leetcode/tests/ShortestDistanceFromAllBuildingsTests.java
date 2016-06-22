package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.shortestdistancefromallbuildings.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShortestDistanceFromAllBuildingsTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        int result = solution.shortestDistance(new int[][]{});
        assertThat(result, equalTo(-1));

        result = solution.shortestDistance(new int[][]{{1}});
        assertThat(result, equalTo(-1));

        result = solution.shortestDistance(new int[][]{{0}});
        assertThat(result, equalTo(0));

        result = solution.shortestDistance(new int[][]{{0, 1, 1, 0}});
        assertThat(result, equalTo(-1));

        result = solution.shortestDistance(new int[][]{{1, 0, 1, 0}});
        assertThat(result, equalTo(2));

        result = solution.shortestDistance(new int[][]{
                {1, 1},
                {0, 0}
        });
        assertThat(result, equalTo(3));

        result = solution.shortestDistance(new int[][]{
                {1, 1},
                {0, 2}
        });
        assertThat(result, equalTo(-1));

        result = solution.shortestDistance(new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        });
        assertThat(result, equalTo(-1));

        result = solution.shortestDistance(new int[][]{
                {1, 1, 1},
                {0, 0, 0},
                {1, 1, 1}
        });
        assertThat(result, equalTo(10));

        result = solution.shortestDistance(new int[][]{
                {1, 0, 2, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
        });
        assertThat(result, equalTo(7));

        result = solution.shortestDistance(new int[][]{
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        });
        assertThat(result, equalTo(10));

        result = solution.shortestDistance(new int[][]{
                {1, 0, 0, 0},
                {1, 2, 0, 1},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        });
        assertThat(result, equalTo(-1));

        result = solution.shortestDistance(new int[][]{
                {0, 1, 0, 2, 0},
                {2, 1, 0, 2, 0},
                {0, 1, 0, 2, 0},
                {0, 1, 0, 0, 0}
        });
        assertThat(result, equalTo(8));
    }
}
