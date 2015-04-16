package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.pascalstriangleii.Solution;

import static org.junit.Assert.*;

public class PascalsTriangleIITests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals("1,1", Utils.integersToString(solution.getRow(1)));
        assertEquals("1,2,1", Utils.integersToString(solution.getRow(2)));
        assertEquals("1,3,3,1", Utils.integersToString(solution.getRow(3)));
        assertEquals("1,4,6,4,1", Utils.integersToString(solution.getRow(4)));
        assertEquals("1,5,10,10,5,1", Utils.integersToString(solution.getRow(5)));
        assertEquals("1,6,15,20,15,6,1", Utils.integersToString(solution.getRow(6)));

    }
}
