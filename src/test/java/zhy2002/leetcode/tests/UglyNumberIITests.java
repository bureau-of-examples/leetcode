package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.uglynumberii.PriorityQueueSolution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UglyNumberIITests {

    @Test
    public void basicTest(){

        PriorityQueueSolution solution = new PriorityQueueSolution();
        assertThat(solution.nthUglyNumber(1), equalTo(1));
        assertThat(solution.nthUglyNumber(2), equalTo(2));
        assertThat(solution.nthUglyNumber(3), equalTo(3));
        assertThat(solution.nthUglyNumber(7), equalTo(8));
        assertThat(solution.nthUglyNumber(8), equalTo(9));
        assertThat(solution.nthUglyNumber(10), equalTo(12));
        assertThat(solution.nthUglyNumber(1407), equalTo(536870912));
        assertThat(solution.nthUglyNumber(1600), equalTo(1399680000));

    }
}
