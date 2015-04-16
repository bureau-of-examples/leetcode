package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.pascalstriangle.Solution;
import static org.junit.Assert.*;

public class PascalsTriangleTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("[[1]]", Utils.listOfListToString(solution.generate(1)));
        assertEquals("[[1],[1,1]]", Utils.listOfListToString(solution.generate(2)));
        assertEquals("[[1],[1,1],[1,2,1]]", Utils.listOfListToString(solution.generate(3)));
        assertEquals("[[1],[1,1],[1,2,1],[1,3,3,1]]", Utils.listOfListToString(solution.generate(4)));
        assertEquals("[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]", Utils.listOfListToString(solution.generate(5)));
    }
}
