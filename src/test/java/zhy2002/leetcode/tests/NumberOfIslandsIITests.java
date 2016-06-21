package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.numberofislandsii.Solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberOfIslandsIITests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        List<Integer> result = solution.numIslands2(0, 0, new int[0][0]);
        assertThat(result, hasSize(0));

        result = solution.numIslands2(1, 1, new int[][]{{0, 0}});
        assertThat(result, equalTo(Collections.singletonList(1)));

        result = solution.numIslands2(3, 3, new int[][]{
                {1, 1}
        });
        assertThat(result, equalTo(Collections.singletonList(1)));

        result = solution.numIslands2(3, 3, new int[][]{
                {1, 1},
                {2, 2}
        });
        assertThat(result, equalTo(Arrays.asList(1, 2)));

        result = solution.numIslands2(3, 3, new int[][]{
                {0, 0},
                {1, 1},
                {2, 2}
        });
        assertThat(result, equalTo(Arrays.asList(1, 2, 3)));

        result = solution.numIslands2(3, 3, new int[][]{
                {0, 0},
                {0, 1},
                {0, 2}
        });
        assertThat(result, equalTo(Arrays.asList(1, 1, 1)));

        result = solution.numIslands2(3, 3, new int[][]{
                {0, 0},
                {0, 1},
                {0, 2},
                {2, 2}
        });
        assertThat(result, equalTo(Arrays.asList(1, 1, 1, 2)));

        result = solution.numIslands2(3, 3, new int[][]{
                {0, 0},
                {0, 1},
                {2, 2},
                {2, 1},
                {1, 1}
        });
        assertThat(result, equalTo(Arrays.asList(1, 1, 2, 2, 1)));

        result = solution.numIslands2(3, 3, new int[][]{
                {0, 0},
                {0, 2},
                {0, 1},
        });
        assertThat(result, equalTo(Arrays.asList(1, 2, 1)));

        result = solution.numIslands2(3, 3, new int[][]{
                {0,1},
                {1,2},
                {2,1},
                {1,0},
                {0,2},
                {0,0},
                {1,1}
        });
        assertThat(result, equalTo(Arrays.asList(1,2,3,4,3,2,1)));

        result = solution.numIslands2(3, 3, new int[][]{
                {0,1},
                {1,2},
                {2,1},
                {1,0},
                {0,2},
                {0,0},
                {1,1},
                {2,2}
        });
        assertThat(result, equalTo(Arrays.asList(1,2,3,4,3,2,1, 1)));
    }
}
