package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.movingaveragefromdatastream.MovingAverage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MovingAverageTests {

    @Test
    public void basicTest() {
        MovingAverage movingAverage = new MovingAverage(3);
        assertThat(movingAverage.next(10), equalTo(10d));
        assertThat(movingAverage.next(8), equalTo(9d));
        assertThat(movingAverage.next(3), equalTo(7d));
        assertThat(movingAverage.next(4), equalTo(5d));
        assertThat(movingAverage.next(2), equalTo(3d));

    }
}
