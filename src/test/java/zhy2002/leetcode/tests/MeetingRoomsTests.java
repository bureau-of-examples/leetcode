package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.Interval;
import zhy2002.leetcode.solutions.meetingrooms.Solution;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MeetingRoomsTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        boolean result = solution.canAttendMeetings(createIntervals("[[0, 30],[5, 10],[15, 20]]"));
        assertThat(result, equalTo(false));

        result = solution.canAttendMeetings(createIntervals("[[0, 3],[5, 10],[15, 20]]"));
        assertThat(result, equalTo(true));

        result = solution.canAttendMeetings(createIntervals("[[0, 3],[3,5],[5, 10],[15, 20]]"));
        assertThat(result, equalTo(true));

        result = solution.canAttendMeetings(createIntervals("[[0, 3],[3,5],[5, 10],[15, 20],[14,15]]"));
        assertThat(result, equalTo(true));

        result = solution.canAttendMeetings(createIntervals("[[0, 3],[3,5],[5, 10],[11,12],[15, 20],[14,15]]"));
        assertThat(result, equalTo(true));

        result = solution.canAttendMeetings(createIntervals("[[0, 3],[3,5],[5, 10],[9,12],[15, 20],[14,15]]"));
        assertThat(result, equalTo(false));
    }

    private Interval[] createIntervals(String str){
        List<Interval> intervals = Utils.stringToIntervals(str.replaceAll(",\\s+", ","));
        Interval[] result = new Interval[intervals.size()];
        intervals.toArray(result);
        return result;
    }
}
