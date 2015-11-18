package zhy2002.leetcode.additional;

import org.junit.Test;
import zhy2002.leetcode.additional.rivercrossing.Solution;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class RiverCrossingTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertThat(solution.minTime(new int[]{1, 2, 5, 8}), equalTo(15));
        assertThat(solution.minTime(new int[]{1, 2, 5, 10}), equalTo(17));
        assertThat(solution.minTime(new int[]{5, 10, 20, 25}), equalTo(60));
    }
}
