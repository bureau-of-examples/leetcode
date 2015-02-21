package zhy2002.leetcode.solutions.excelsheetcolumntitle;

/**
 * https://oj.leetcode.com/problems/excel-sheet-column-title/
 */
public class Solution {

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
