package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.meetingroomsii.MergeSolution;
import zhy2002.leetcode.solutions.meetingroomsii.PriorityQueueSolution;
import zhy2002.leetcode.solutions.meetingroomsii.Solution;
import zhy2002.leetcode.solutions.meetingroomsii.TreeSetSolution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class meetingRoomsIITests {

    @Test
    public void treeSetTest(){
        basicTest(new TreeSetSolution());
    }

    @Test
    public void priorityQueueTest(){
        PriorityQueueSolution solution = new PriorityQueueSolution();
        basicTest(solution);
    }

    @Test
    public void mergeTest(){
         basicTest(new MergeSolution());
    }

    private void basicTest(Solution solution){

        int result = solution.minMeetingRooms(Utils.stringToIntervalArray("[[1,2]]"));
        assertThat(result, equalTo(1));

        result = solution.minMeetingRooms(Utils.stringToIntervalArray("[[1,2],[2,3]]"));
        assertThat(result, equalTo(1));

        result = solution.minMeetingRooms(Utils.stringToIntervalArray("[[1,2],[2,3],[2,5]]"));
        assertThat(result, equalTo(2));

        result = solution.minMeetingRooms(Utils.stringToIntervalArray("[[1,2],[2,3],[2,5],[1,2]]"));
        assertThat(result, equalTo(2));

        result = solution.minMeetingRooms(Utils.stringToIntervalArray("[[1,2],[2,3],[2,5],[1,6]]"));
        assertThat(result, equalTo(3));

        result = solution.minMeetingRooms(Utils.stringToIntervalArray("[[5,8],[6,8]]"));
        assertThat(result, equalTo(2));
    }
}
