package zhy2002.leetcode.tests;

import zhy2002.leetcode.solutions.multiplystrings.Solution;
import org.junit.Test;

import static org.junit.Assert.*;


public class MultiplyStringsTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        assertEquals("1", solution.multiply("1", "1"));
        assertEquals("72", solution.multiply("8", "9"));
        assertEquals("0", solution.multiply("0", "88"));
        assertEquals("0", solution.multiply("998", "0"));
        assertEquals("998", solution.multiply("998", "1"));
        assertEquals("10978", solution.multiply("998", "11"));
        assertEquals("1996", solution.multiply("998", "2"));
        assertEquals("7973757", solution.multiply("1011", "7887"));
        assertEquals("520000", solution.multiply("52", "10000"));
        assertEquals("10000", solution.multiply("10", "1000"));
        assertEquals("1009293", solution.multiply("101", "9993"));
        assertEquals("84321120", solution.multiply("405390", "208"));
    }
}
