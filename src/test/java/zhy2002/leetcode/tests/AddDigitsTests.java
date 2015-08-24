package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.solutions.adddigits.Solution;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class AddDigitsTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertThat(solution.addDigits(0), equalTo(0));
        assertThat(solution.addDigits(8), equalTo(8));
        assertThat(solution.addDigits(9), equalTo(9));
        assertThat(solution.addDigits(10), equalTo(1));
        assertThat(solution.addDigits(18), equalTo(9));
        assertThat(solution.addDigits(19), equalTo(1));

    }
}
