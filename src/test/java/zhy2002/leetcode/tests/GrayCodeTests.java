package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.graycode.Solution;
import static org.junit.Assert.*;

public class GrayCodeTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("0,1", Utils.integersToString(solution.grayCode(1)));
        assertEquals("0,1,3,2", Utils.integersToString(solution.grayCode(2)));
        assertEquals("0,1,3,2,6,7,5,4", Utils.integersToString(solution.grayCode(3)));
    }
}
