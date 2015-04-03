package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.countandsay.Solution;

import static org.junit.Assert.*;

public class CountAndSayTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertEquals("1", solution.countAndSay(1));
        assertEquals("11", solution.countAndSay(2));
        assertEquals("21", solution.countAndSay(3));
        assertEquals("1211", solution.countAndSay(4));
        assertEquals("111221", solution.countAndSay(5));
        assertEquals("312211", solution.countAndSay(6));
    }
}
