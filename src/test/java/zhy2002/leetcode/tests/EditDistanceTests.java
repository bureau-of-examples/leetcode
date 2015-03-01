package zhy2002.leetcode.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import zhy2002.leetcode.solutions.editdistance.Solution;

public class EditDistanceTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        assertEquals(0, solution.minDistance("",""));
        assertEquals(1, solution.minDistance("","a"));
        assertEquals(2, solution.minDistance("","ab"));
        assertEquals(0, solution.minDistance("abc","abc"));
        assertEquals(3, solution.minDistance("sea", "ate"));
        assertEquals(2, solution.minDistance("mark", "remark"));
        assertEquals(4, solution.minDistance("running", "run"));
        assertEquals(2, solution.minDistance("compression", "comspresasion"));
        assertEquals(2, solution.minDistance("aabbabatab", "aaxbabaab"));
    }
}
