package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.bitwiseandofnumbersrange.CleanSolution;
import zhy2002.leetcode.solutions.bitwiseandofnumbersrange.MySolution;
import zhy2002.leetcode.solutions.bitwiseandofnumbersrange.Solution;
import static org.junit.Assert.*;

public class BitwiseAndOfNumbersRangeTests {

    @Test
    public void myTest(){
         basicTest(new MySolution());
    }

    @Test
    public void cleanTest(){
        basicTest(new CleanSolution());
    }

    private void basicTest(Solution solution){

        assertEquals(4, solution.rangeBitwiseAnd(5,7));
        assertEquals(0, solution.rangeBitwiseAnd(0,7));
        assertEquals(8, solution.rangeBitwiseAnd(8,15));
        assertEquals(0, solution.rangeBitwiseAnd(8,16));
    }
}
