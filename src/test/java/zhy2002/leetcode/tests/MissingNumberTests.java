package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.missingnumber.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MissingNumberTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        int missing = solution.missingNumber(new int[]{1, 0, 2, 5, 4});
        assertThat(missing, equalTo(3));

        missing = solution.missingNumber(new int[]{1, 3, 0, 2, 5, 4});
        assertThat(missing, equalTo(6));

        missing = solution.missingNumber(new int[]{1, 2, 5, 4, 3, 6});
        assertThat(missing, equalTo(0));

        missing = solution.missingNumber(new int[]{6, 3, 0, 2, 5, 4});
        assertThat(missing, equalTo(1));
    }
}
