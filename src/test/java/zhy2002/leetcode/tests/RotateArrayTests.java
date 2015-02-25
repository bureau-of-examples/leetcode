package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.rotatearray.Solution;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class RotateArrayTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        int[] array = new int[]{2, 3, 4, 5, 6};
        solution.rotate(array, 0);
        assertArrayEquals(new int[]{2, 3, 4, 5, 6}, array);

        array = new int[]{2, 3, 4, 5, 6};
        solution.rotate(array, 1);
        assertArrayEquals(new int[]{6, 2, 3, 4, 5}, array);

        array = new int[]{2, 3, 4, 5, 6};
        solution.rotate(array, 2);
        assertArrayEquals(new int[]{5, 6, 2, 3, 4}, array);

        array = new int[]{2, 3, 4, 5, 6};
        solution.rotate(array, 3);
        assertArrayEquals(new int[]{4, 5, 6, 2, 3}, array);

        array = new int[]{2, 3, 4, 5, 6};
        solution.rotate(array, 4);
        assertArrayEquals(new int[]{3, 4, 5, 6, 2}, array);

        array = new int[]{2, 3, 4, 5, 6};
        solution.rotate(array, 5);
        assertArrayEquals(new int[]{2, 3, 4, 5, 6}, array);

        array = new int[]{2, 3, 4, 5, 6};
        solution.rotate(array, 6);
        assertArrayEquals(new int[]{6, 2, 3, 4, 5}, array);
    }

    @Test
    public void cornerCaseTest() {
        Solution solution = new Solution();

        int[] array = new int[]{};
        solution.rotate(array, 100);
        assertArrayEquals(new int[]{}, array);

        array = new int[]{5};
        solution.rotate(array, 100);
        assertArrayEquals(new int[]{5}, array);

        array = new int[]{5, -2};
        solution.rotate(array, 99);
        assertArrayEquals(new int[]{-2, 5}, array);

        array = new int[]{88, 54, 5353, 68};
        solution.rotate(array, 2);
        assertArrayEquals(new int[]{5353, 68, 88, 54}, array);

        array = new int[]{88, 54, 5353, 68};
        solution.rotate(array, 3);
        assertArrayEquals(new int[]{54, 5353, 68, 88}, array);

        array = new int[]{1, 2, 3, 4, 5, 6};
        solution.rotate(array, 2);
        assertArrayEquals(new int[]{5, 6, 1, 2, 3, 4}, array);

        array = new int[]{1, 2, 3, 4, 5, 6};
        solution.rotate(array, 3);
        assertArrayEquals(new int[]{4, 5, 6, 1, 2, 3}, array);

    }

    @Test
    public void comparisonTest() {
        Solution solution = new Solution();
        for (int len = 0; len < 9; len++) {
            for (int k = 0; k <= len; k++) {
                int[] array = Utils.createRange(0, len);
                solution.rotate(array, k);
                int[] array2 = Utils.createRange(0, len);
                solution.rotate2(array2, k);
                assertArrayEquals(array2, array);
            }
        }
    }
}
