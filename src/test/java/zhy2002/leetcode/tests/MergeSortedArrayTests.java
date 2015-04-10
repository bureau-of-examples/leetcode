package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.mergesortedarray.Solution;

import static org.junit.Assert.*;

public class MergeSortedArrayTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        int[] array1 = {5, 6, 7, 8, 9, 0, 0, 0};
        int[] array2 = {1, 2, 3};
        solution.merge(array1, 5, array2, 3);
        assertArrayEquals(new int[]{1, 2, 3, 5, 6, 7, 8, 9}, array1);

        array1 = new int[]{1, 2, 8, 9, 10, 0, 0, 0};
        array2 = new int[]{4, 5, 8};
        solution.merge(array1, 5, array2, 3);
        assertArrayEquals(new int[]{1, 2, 4, 5, 8, 8, 9, 10}, array1);

        array1 = new int[]{1, 4, 8, 0, 0, 0, 0, 0};
        array2 = new int[]{2, 3, 7, 10};
        solution.merge(array1, 3, array2, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4, 7, 8, 10, 0}, array1);
    }
}
