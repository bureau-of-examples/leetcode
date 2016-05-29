package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.bestmeetingpoint.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BestMeetingPointTests {


    @Test
    public void basicTest() {

        Solution solution = new Solution();
        int result = solution.minTotalDistance(Utils.stringToIntMatrix("1 0 0 0 1,0 0 0 0 0,0 0 1 0 0"));
        assertThat(result, equalTo(6));

        result = solution.minTotalDistance(Utils.stringToIntMatrix("0 1,1 0"));
        assertThat(result, equalTo(2));

        result = solution.minTotalDistance(Utils.stringToIntMatrix("0 1 0,1 0 1"));
        assertThat(result, equalTo(3));

        result = solution.minTotalDistance(Utils.stringToIntMatrix("0 1 0,1 0 1,1 1 0"));
        assertThat(result, equalTo(6));

        result = solution.minTotalDistance(Utils.stringToIntMatrix("0 1 0 0,1 0 1 0,1 1 0 0"));
        assertThat(result, equalTo(6));

        result = solution.minTotalDistance(Utils.stringToIntMatrix("1 1 1,1 1 1,0 1 1"));
        assertThat(result, equalTo(10));

        result = solution.minTotalDistance(Utils.stringToIntMatrix("1 1 1,1 1 0,0 1 1"));
        assertThat(result, equalTo(9));

        result = solution.minTotalDistance(Utils.stringToIntMatrix("1 1"));
        assertThat(result, equalTo(1));
    }
}
