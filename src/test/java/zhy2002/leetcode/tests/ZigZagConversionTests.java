package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.zigzagconversion.Solution;
import static org.junit.Assert.*;

public class ZigZagConversionTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals("A",solution.convert("A",3));
        assertEquals("AB",solution.convert("AB",3));
        assertEquals("ABC",solution.convert("ABC",3));
        assertEquals("ABDC",solution.convert("ABCD",3));
        assertEquals("AEBDC",solution.convert("ABCDE",3));
        assertEquals("AEBDFC",solution.convert("ABCDEF",3));
        assertEquals("AEBDFHCG",solution.convert("ABCDEFGH",3));
        assertEquals("ACEGBDFH",solution.convert("ABCDEFGH",2));
        assertEquals("ABFCED",solution.convert("ABCDEF",4));
        assertEquals("AGBFCED",solution.convert("ABCDEFG",4));
        assertEquals("AGBFHCEIKDJ",solution.convert("ABCDEFGHIJK",4));
        assertEquals("AIBHJCGKDFE",solution.convert("ABCDEFGHIJK",5));
    }
}
