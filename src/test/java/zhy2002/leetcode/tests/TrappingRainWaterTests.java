package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.trappingrainwater.Solution;
import static org.junit.Assert.*;

public class TrappingRainWaterTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        assertEquals(0, solution.trap(new int[]{1,2,3,4,5}));
        assertEquals(5, solution.trap(new int[]{4,1,2,5}));
        assertEquals(6, solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        assertEquals(7, solution.trap(new int[]{4,2,1,3,1,1,3}));
    }
}
