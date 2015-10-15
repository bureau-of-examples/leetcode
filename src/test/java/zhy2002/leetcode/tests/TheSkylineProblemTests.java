package zhy2002.leetcode.tests;

import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.theskylineproblem.*;

import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TheSkylineProblemTests {

    @Test
    public void dncTest(){
        DncSolution solution = new DncSolution();

        basicTest(solution);
        ojFailedTest(solution);
        ojFailedTest2(solution);
    }

    @Test
    public void miscTest(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(100);
        priorityQueue.offer(100);
        priorityQueue.offer(100);

        assertThat(priorityQueue.size(), equalTo(3));
    }

    @Test
    public void priorityQueueTest(){
        PriorityQueueSolution solution = new PriorityQueueSolution();

        basicTest(solution);
        ojFailedTest(solution);
        ojFailedTest2(solution);
    }

    private void basicTest(Solution solution){

        List<int[]> result = solution.getSkyline(Utils.stringToIntMatrix("0 5 10"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[0 10] [5 0]"));

        result = solution.getSkyline(Utils.stringToIntMatrix("0 5 10,6 8 12"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[0 10] [5 0] [6 12] [8 0]"));

        result = solution.getSkyline(Utils.stringToIntMatrix("0 5 10,0 5 10"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[0 10] [5 0]"));

        result = solution.getSkyline(Utils.stringToIntMatrix("0 5 10,0 5 10,0 5 10"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[0 10] [5 0]"));

        result = solution.getSkyline(Utils.stringToIntMatrix("0 5 10,4 8 12"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[0 10] [4 12] [8 0]"));

        result = solution.getSkyline(Utils.stringToIntMatrix("0 5 10,4 8 6"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[0 10] [5 6] [8 0]"));

        result = solution.getSkyline(Utils.stringToIntMatrix("0 5 10,3 8 6,7 9 10"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[0 10] [5 6] [7 10] [9 0]"));

        result = solution.getSkyline(Utils.stringToIntMatrix("0 5 10,3 8 12,7 9 10"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[0 10] [3 12] [8 10] [9 0]"));

        result = solution.getSkyline(Utils.stringToIntMatrix("2 9 10,3 7 15,5 12 12,15 20 10,19 24 8"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[2 10] [3 15] [7 12] [12 0] [15 10] [20 8] [24 0]"));

    }

    private void ojFailedTest(Solution solution){
        List<int[]> result = solution.getSkyline(Utils.stringToIntMatrix("3 7 8,3 8 7,3 9 6,3 10 5"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[3 8] [7 7] [8 6] [9 5] [10 0]"));

        result = solution.getSkyline(Utils.stringToIntMatrix("3 7 8,3 8 7,3 9 6,3 10 5,3 11 4,3 12 3,3 13 2,3 14 1"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[3 8] [7 7] [8 6] [9 5] [10 4] [11 3] [12 2] [13 1] [14 0]"));
    }

    private void ojFailedTest2(Solution solution){
        List<int[]> result = solution.getSkyline(Utils.stringToIntMatrix("0 2 3,2 5 3"));
        assertThat(Utils.listOfIntArrayToString(result), equalTo("[0 3] [5 0]"));
    }
}
