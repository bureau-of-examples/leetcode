package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.searchforagrange.Solution;

import static org.junit.Assert.*;

public class SearchForARangeTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{}, 10));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{1, 2, 5}, 10));
        assertArrayEquals(new int[]{3, 3}, solution.searchRange(new int[]{1, 2, 5, 10}, 10));
        assertArrayEquals(new int[]{3, 4}, solution.searchRange(new int[]{1, 2, 5, 10, 10}, 10));
        assertArrayEquals(new int[]{0, 0}, solution.searchRange(new int[]{1, 2, 5, 10, 10}, 1));
        assertArrayEquals(new int[]{0, 2}, solution.searchRange(new int[]{1, 1, 1, 2, 5, 10, 10}, 1));
        assertArrayEquals(new int[]{4, 4}, solution.searchRange(new int[]{1, 1, 1, 2, 5, 10, 10}, 5));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{1, 1, 1, 2, 5, 10, 10}, 8));
        assertArrayEquals(new int[]{5, 7}, solution.searchRange(new int[]{1, 1, 1, 2, 5, 8, 8, 8, 10, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{1, 1, 1, 2, 5, 8, 8, 8, 10, 10}, 11));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{1, 1, 1, 2, 5, 8, 8, 8, 10, 10}, -11));
    }
}
