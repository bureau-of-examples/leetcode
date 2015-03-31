package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.removeduplicatesfromsortedarray.Solution;
import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedArrayTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        int[] array = Utils.intArrayFromString("");
        assertEquals(0, solution.removeDuplicates(array));

        array = Utils.intArrayFromString("1 1 1");
        assertEquals(1, solution.removeDuplicates(array));

        assertEquals(2, solution.removeDuplicates(new int[]{1, 1, 1, 2, 2}));
        assertEquals(5, solution.removeDuplicates(new int[]{1, 2, 3, 4, 5}));
        assertEquals(5, solution.removeDuplicates(new int[]{1, 1, 2, 2, 2, 3, 4, 5, 5, 5}));
        assertEquals(5, solution.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3, 3, 4, 5, 5}));
    }
}
