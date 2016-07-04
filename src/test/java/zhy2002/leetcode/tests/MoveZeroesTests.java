package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.movezeroes.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MoveZeroesTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        int[] input = {};
        solution.moveZeroes(input);
        assertThat(input, equalTo(new int[]{}));

        input = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(input);
        assertThat(input, equalTo(new int[]{1, 3, 12, 0, 0}));

        input = new int[]{3, 1, 2, 3};
        solution.moveZeroes(input);
        assertThat(input, equalTo(new int[]{3, 1, 2, 3}));

        input = new int[]{3, 1, 2, 3, 0, 0};
        solution.moveZeroes(input);
        assertThat(input, equalTo(new int[]{3, 1, 2, 3, 0, 0}));

        input = new int[]{3, 1, 0, 2, 3, 0, 0, 1};
        solution.moveZeroes(input);
        assertThat(input, equalTo(new int[]{3, 1, 2, 3, 1, 0, 0, 0}));

    }
}
