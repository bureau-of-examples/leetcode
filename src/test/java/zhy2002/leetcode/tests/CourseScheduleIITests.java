package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.coursescheduleii.Solution;

import static org.junit.Assert.*;

public class CourseScheduleIITests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertArrayEquals(new int[]{}, solution.findOrder(0, new int[][]{}));
        assertArrayEquals(new int[]{0}, solution.findOrder(1, new int[][]{}));
        assertArrayEquals(new int[]{0, 1}, solution.findOrder(2, new int[][]{{1, 0}}));
        assertArrayEquals(new int[]{0, 1, 2}, solution.findOrder(3, new int[][]{{1, 0}, {2, 1}}));
        assertArrayEquals(new int[]{0, 1, 2}, solution.findOrder(3, new int[][]{{1, 0}, {2, 1}, {2, 0}}));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, solution.findOrder(5, new int[][]{{1, 0}, {2, 1}, {2, 0}, {4, 3}}));
    }
}
