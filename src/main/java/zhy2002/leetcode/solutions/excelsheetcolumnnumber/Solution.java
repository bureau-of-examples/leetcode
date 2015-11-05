package zhy2002.leetcode.solutions.excelsheetcolumnnumber;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class Solution {

    public int titleToNumber(String s) {

        if (s == null || s.length() == 7 && s.compareTo("FXSHRXW") > 0 || s.length() > 7) //cannot fit in an integer
            throw new IllegalArgumentException("s");

        int result = 0;

        int pow = 1;
        for (int i = s.length() - 1; i >= 0; i--) { //from the last letter
            result += (s.charAt(i) - 64) * pow; //A -> 1
            pow *= 26;
        }

        return result;
    }
}
