package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.countingbits.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CountingBitsTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        int[] result = solution.countBits(1);
        assertThat(result, equalTo(new int[]{0, 1}));

        result = solution.countBits(5);
        assertThat(result, equalTo(new int[]{0, 1, 1, 2, 1, 2}));

        result = solution.countBits(6);
        assertThat(result, equalTo(new int[]{0, 1, 1, 2, 1, 2, 2}));

        result = solution.countBits(27);
        assertThat(result, equalTo(new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4}));

    }
}
