package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.removeduplicatesfromsortedarrayii.Solution;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedArrayIITests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals(0, solution.removeDuplicates(new int[]{}));
        assertEquals(2, solution.removeDuplicates(new int[]{1, 1, 1}));
        assertEquals(4, solution.removeDuplicates(new int[]{1, 1, 1, 2, 2}));
        assertEquals(5, solution.removeDuplicates(new int[]{1, 2, 3, 4, 5}));
        assertEquals(8, solution.removeDuplicates(new int[]{1, 1, 2, 2, 2, 3, 4, 5, 5, 5}));
        int[] array = new int[]{1, 1, 1, 2, 2, 3, 3, 4, 5, 5};
        assertEquals(9, solution.removeDuplicates(array));
        assertEquals(array[0], 1);
        assertEquals(array[1], 1);
        assertEquals(array[2], 2);
        assertEquals(array[3], 2);
        assertEquals(array[4], 3);
        assertEquals(array[5], 3);
        assertEquals(array[6], 4);
        assertEquals(array[7], 5);
        assertEquals(array[8], 5);
    }
}
