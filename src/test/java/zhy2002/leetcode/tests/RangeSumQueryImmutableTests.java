package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.rangesumqueryimmutable.NumArray;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RangeSumQueryImmutableTests {

    @Test
    public void basicTest() {

        NumArray solution = new NumArray(new int[]{7,1,5,2});

        assertThat(solution.sumRange(0,1), equalTo(8));
        assertThat(solution.sumRange(0,0), equalTo(7));
        assertThat(solution.sumRange(1,2), equalTo(6));
        assertThat(solution.sumRange(1,3), equalTo(8));
    }
}
