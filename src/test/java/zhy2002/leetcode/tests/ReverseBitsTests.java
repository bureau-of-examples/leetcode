package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.reversebits.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReverseBitsTests {


    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertThat(solution.reverseBits(-2), equalTo(2147483647));
        assertThat(solution.reverseBits(-1), equalTo(-1));
    }
}
