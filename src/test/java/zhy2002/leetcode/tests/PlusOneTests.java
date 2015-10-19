package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.plusone.Solution;

import static org.junit.Assert.*;

public class PlusOneTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertArrayEquals(new int[]{8, 0, 0, 1}, solution.plusOne(new int[]{8, 0, 0, 0}));
        assertArrayEquals(new int[]{9, 0, 0, 0}, solution.plusOne(new int[]{8, 9, 9, 9}));
        assertArrayEquals(new int[]{1}, solution.plusOne(new int[]{0}));
        assertArrayEquals(new int[]{1, 0}, solution.plusOne(new int[]{0, 9}));
    }
}
