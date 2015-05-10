package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.nextpermutation.Solution;
import static org.junit.Assert.*;

public class NextPermutationTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        int[] array = {1,2,3};
        solution.nextPermutation(array);
        assertArrayEquals(new int[]{1,3,2}, array);

        solution.nextPermutation(array);
        assertArrayEquals(new int[]{2,1,3}, array);

        array = new int[]{4,4,3,1};
        solution.nextPermutation(array);
        assertArrayEquals(new int[]{1,3,4,4}, array);

        solution.nextPermutation(array);
        assertArrayEquals(new int[]{1,4,3,4}, array);

        solution.nextPermutation(array);
        assertArrayEquals(new int[]{1,4,4,3}, array);

        solution.nextPermutation(array);
        assertArrayEquals(new int[]{3,1,4,4}, array);
    }
}
