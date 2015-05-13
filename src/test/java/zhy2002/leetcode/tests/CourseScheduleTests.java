package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.courseschedule.Solution;

import static org.junit.Assert.*;

public class CourseScheduleTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertTrue(solution.canFinish(2, new int[][]{new int[]{1, 0}}));
        assertTrue(solution.canFinish(3, new int[][]{new int[]{1, 0}, new int[]{2,1}}));
        assertTrue(solution.canFinish(3, new int[][]{new int[]{1, 0}, new int[]{2,0}}));
        assertFalse(solution.canFinish(2, new int[][]{new int[]{1, 0}, new int[]{0, 1}}));
        assertFalse(solution.canFinish(3, new int[][]{new int[]{1, 0}, new int[]{2, 1}, new int[]{0, 2}}));
    }
}
