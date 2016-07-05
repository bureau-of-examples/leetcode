package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.powerofthree.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PowerOfThreeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertThat(solution.isPowerOfThree(3), equalTo(true));
        assertThat(solution.isPowerOfThree(9), equalTo(true));
        assertThat(solution.isPowerOfThree(27), equalTo(true));
        assertThat(solution.isPowerOfThree(81), equalTo(true));
        assertThat(solution.isPowerOfThree(5), equalTo(false));
        assertThat(solution.isPowerOfThree(2), equalTo(false));
        assertThat(solution.isPowerOfThree(17), equalTo(false));
    }



}
