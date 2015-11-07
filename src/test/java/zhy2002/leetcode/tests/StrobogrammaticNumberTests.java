package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.strobogrammaticnumber.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StrobogrammaticNumberTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        assertThat(solution.isStrobogrammatic(""), equalTo(true));
        assertThat(solution.isStrobogrammatic("0"), equalTo(true));
        assertThat(solution.isStrobogrammatic("1"), equalTo(true));
        assertThat(solution.isStrobogrammatic("01"), equalTo(false));
        assertThat(solution.isStrobogrammatic("45"), equalTo(false));
        assertThat(solution.isStrobogrammatic("69"), equalTo(true));
        assertThat(solution.isStrobogrammatic("88"), equalTo(true));
        assertThat(solution.isStrobogrammatic("818"), equalTo(true));
        assertThat(solution.isStrobogrammatic("68186"), equalTo(false));
        assertThat(solution.isStrobogrammatic("98186"), equalTo(true));
        assertThat(solution.isStrobogrammatic("2"), equalTo(false));

    }
}
