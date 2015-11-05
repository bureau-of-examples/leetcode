package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import zhy2002.leetcode.solutions.twosumiii.TwoSum;


public class TwoSumIIITests {

    @Test
    public void basicTest() {

        TwoSum twoSum = new TwoSum();
        twoSum.add(3);
        twoSum.add(3);
        twoSum.add(1);
        assertThat(twoSum.find(6), equalTo(true));
        assertThat(twoSum.find(4), equalTo(true));
        assertThat(twoSum.find(5), equalTo(false));
        assertThat(twoSum.find(7), equalTo(false));
        twoSum.add(-2);
        assertThat(twoSum.find(-1), equalTo(true));
        assertThat(twoSum.find(-2), equalTo(false));
    }
}
