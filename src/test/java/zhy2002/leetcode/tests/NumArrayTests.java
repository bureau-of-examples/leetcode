package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.rangesumquerymutable.NumArray;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumArrayTests {

    @Test
    public void basicTest() {
        NumArray array = new NumArray(new int[]{3, 4, 1, 2, 9, 6, 5});

        assertThat(array.sumRange(0, 0), equalTo(3));
        assertThat(array.sumRange(0, 2), equalTo(8));
        assertThat(array.sumRange(2, 3), equalTo(3));

        array.update(2, 10);
        assertThat(array.sumRange(1, 3), equalTo(16));

        array.update(5, -2);
        assertThat(array.sumRange(6, 6), equalTo(5));
        assertThat(array.sumRange(5, 6), equalTo(3));
    }
}
