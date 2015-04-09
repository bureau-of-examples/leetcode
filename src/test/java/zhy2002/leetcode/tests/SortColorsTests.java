package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.sortcolors.InsertionSolution;
import zhy2002.leetcode.solutions.sortcolors.Solution;
import zhy2002.leetcode.solutions.sortcolors.TwoPointersSolution;

import static org.junit.Assert.*;

public class SortColorsTests {

    @Test
    public void insertionBasicTest(){
        basicTest(new InsertionSolution());
    }

    @Test
    public void twoPointersSolution(){
        basicTest(new TwoPointersSolution());
    }

    private void basicTest(Solution solution) {

        int[] colors = new int[]{2, 0, 2, 0, 2, 1, 1};
        solution.sortColors(colors);
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2, 2}, colors);

        colors = new int[]{2, 2, 2, 1, 1, 1, 0, 0};
        solution.sortColors(colors);
        assertArrayEquals(new int[]{0, 0, 1, 1, 1, 2, 2, 2}, colors);
    }
}
