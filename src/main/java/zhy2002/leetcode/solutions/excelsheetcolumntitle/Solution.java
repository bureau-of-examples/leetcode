package zhy2002.leetcode.solutions.excelsheetcolumntitle;

/**
 * https://leetcode.com/problems/excel-sheet-column-title/
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet. E.g.
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class Solution {

    //If title from least significant letter is C1 C2 C3 C4
    //then the number is d(C1) + 26*d(C2) + 26*26*d(C3) + 26*26*26*d(C4)
    public String convertToTitle(int n) {
        if(n <= 0)
            throw new IllegalArgumentException("n");

        String result = "";
        while (n > 0){//iteratively fetch the last letter, which is always in [1, 26].
            int leastLetter = n % 26;
            if(leastLetter == 0)
                leastLetter = 26;
            result = (char)(leastLetter + 64) + result;
            n = (n - leastLetter) / 26;
        }

        return result;
    }
}
