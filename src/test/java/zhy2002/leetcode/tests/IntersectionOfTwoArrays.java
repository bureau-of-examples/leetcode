package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.intersectionoftwoarrays.Solution;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class IntersectionOfTwoArrays {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        int[] result = solution.intersection(new int[]{}, new int[]{});
        assertThat(result, equalTo(new int[]{}));

        result = solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        assertThat(result, equalTo(new int[]{2}));

        result = solution.intersection(new int[]{1, 2, 6, 4, 3, 1, 0}, new int[]{17, 19, 4, 2, 2, 3, 0});
        Arrays.sort(result);
        assertThat(result, equalTo(new int[]{0, 2, 3, 4}));

    }
}
