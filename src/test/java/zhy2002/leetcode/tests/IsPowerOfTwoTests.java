package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.poweroftwo.Solution;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class IsPowerOfTwoTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertThat(solution.isPowerOfTwo(0), equalTo(false));
        assertThat(solution.isPowerOfTwo(1), equalTo(true));
        assertThat(solution.isPowerOfTwo(2), equalTo(true));
        assertThat(solution.isPowerOfTwo(3), equalTo(false));
        assertThat(solution.isPowerOfTwo(4), equalTo(true));
        assertThat(solution.isPowerOfTwo(5), equalTo(false));
        assertThat(solution.isPowerOfTwo(6), equalTo(false));
        assertThat(solution.isPowerOfTwo(7), equalTo(false));
        assertThat(solution.isPowerOfTwo(8), equalTo(true));
        assertThat(solution.isPowerOfTwo(9), equalTo(false));
    }
}
