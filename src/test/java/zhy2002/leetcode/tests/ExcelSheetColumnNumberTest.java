package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.excelsheetcolumnnumber.Solution;
import static org.junit.Assert.*;

public class ExcelSheetColumnNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void overflowTest(){
        Solution solution = new Solution();

        solution.titleToNumber("FXSHRXX");
    }

    @Test
    public void boundaryTest(){
        Solution solution = new Solution();

        assertEquals(Integer.MAX_VALUE, solution.titleToNumber("FXSHRXW"));
        assertEquals(1, solution.titleToNumber("A"));
        assertEquals(27, solution.titleToNumber("AA"));
        assertEquals(26*26 + 26, solution.titleToNumber("ZZ"));
        assertEquals(26*26 + 26 + 1, solution.titleToNumber("AAA"));
    }
}
