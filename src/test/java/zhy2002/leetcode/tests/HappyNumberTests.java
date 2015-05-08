package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.happynumber.Solution;
import static org.junit.Assert.*;

public class HappyNumberTests {

    @Test
    public void basicTest(){
         Solution solution = new Solution();
        assertTrue(solution.isHappy(19));
        assertTrue(solution.isHappy(1000));
        assertFalse(solution.isHappy(111));
    }
}
