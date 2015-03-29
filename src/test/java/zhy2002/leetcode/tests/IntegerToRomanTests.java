package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.integertoroman.Solution;
import static org.junit.Assert.*;

public class IntegerToRomanTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        assertEquals("MMXV",solution.intToRoman(2015));
        assertEquals("MMXLIX",solution.intToRoman(2049));
        assertEquals("MMXIV",solution.intToRoman(2014));
        assertEquals("MCMXC",solution.intToRoman(1990));
        assertEquals("MCMLIV",solution.intToRoman(1954));
        assertEquals("LXXI",solution.intToRoman(71));
        assertEquals("VIII",solution.intToRoman(8));
        assertEquals("MCMIV",solution.intToRoman(1904));
    }
}
