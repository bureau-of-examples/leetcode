package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.triangle.Solution;
import java.util.List;

import static org.junit.Assert.*;

public class TriangleTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        assertEquals(0, solution.minimumTotal(null));

        List<List<Integer>> input = Utils.arrayOfArrayToListOfList(new Integer[][]{{1}});
        assertEquals(1, solution.minimumTotal(input));

        input = Utils.arrayOfArrayToListOfList(new Integer[][]{{1}, {2,3}});
        assertEquals(3, solution.minimumTotal(input));

        input = Utils.arrayOfArrayToListOfList(new Integer[][]{
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}});
        assertEquals(11, solution.minimumTotal(input));
    }
}
