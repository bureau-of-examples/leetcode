package zhy2002.leetcode.solutions.excelsheetcolumnnumber;

/**
 * https://oj.leetcode.com/problems/excel-sheet-column-number/
 */
public class Solution {

    public int titleToNumber(String s) {

        if (s == null || s.length() == 7 && s.compareTo("FXSHRXW") > 0 || s.length() > 7) //cannot fit in an integer
            throw new IllegalArgumentException("s");

        int result = 0;

        int base = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - 64) * base; //A -> 1
            base *= 26;
        }

        return result;
    }
}
