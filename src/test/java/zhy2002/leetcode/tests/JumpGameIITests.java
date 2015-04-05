package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.jumpgameii.Solution;
import static org.junit.Assert.*;

public class JumpGameIITests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(4, solution.jump(new int[]{3, 3, 2, 5, 4, 3, 9, 5, 5, 7, 9, 4, 9, 1, 0, 3, 6, 8, 2}));
        assertEquals(4,solution.jump(new int[]{7, 9, 5, 2, 5, 7, 3, 8, 8, 7, 9, 3, 1, 7, 6, 3, 8, 7, 2, 2, 5, 9}));
        assertEquals(3, solution.jump(new int[]{2, 4, 8, 1, 0, 8, 3, 0, 7, 9, 9, 8, 3, 1, 7, 3}));
        assertEquals(0,solution.jump(new int[]{0}));
        assertEquals(3, solution.jump(new int[]{3, 1, 9, 0, 4, 4, 8, 4, 7, 0, 8, 4, 3, 1, 2}));
        assertEquals(3,solution.jump(new int[]{5, 4, 0, 1, 3, 6, 8, 0, 9, 4, 9, 1, 8, 7, 4, 8}));
        assertEquals(5, solution.jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}));

    }
}
