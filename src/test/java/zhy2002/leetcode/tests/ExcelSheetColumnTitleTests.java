package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.excelsheetcolumntitle.Solution;

import static org.junit.Assert.*;


public class ExcelSheetColumnTitleTests {


    @Test
    public void basicTest(){
        Solution solution = new Solution();
        for(int i=1; i<= 26; i++){
            String result = solution.convertToTitle(i);
            char expected = (char)('A' - 1 + i);
            assertEquals(String.valueOf(expected), result);
        }

        assertEquals("AA", solution.convertToTitle(27));
        assertEquals("AB", solution.convertToTitle(28));
        assertEquals("ZZ", solution.convertToTitle(26*26 + 26));
        assertEquals("AAA", solution.convertToTitle(26*26 + 26 + 1));
    }

}
