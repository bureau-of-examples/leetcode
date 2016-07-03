package zhy2002.leetcode.additional;
import org.junit.Before;
import org.junit.Test;
import zhy2002.leetcode.additional.common.IntPair;
import zhy2002.leetcode.additional.swapwithouttempvariable.Solution;
import zhy2002.leetcode.tests.IntegerToRomanTests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SwapWithoutTempVaribleTests {

    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void basicTest() {
        testcase(1, 0);
        testcase(1, 1);
        testcase(-1, 0);
        testcase(-1, 16);
        testcase(10132, 432423);
        testcase(543534, 654654245);
        testcase(Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private void testcase( int left, int right) {
        IntPair pair;
        pair = new IntPair(left, right);
        solution.swap(pair);
        assertThat(pair.left, equalTo(right));
        assertThat(pair.right, equalTo(left));
    }
}
