package zhy2002.leetcode.solutions.generateparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * Recursively set the current char to ( or ) with respect to parenthesis restrictions.
 */
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> arrayList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(n * 2);
        for (int i = 0; i < n; i++)
            stringBuilder.append("AB");//fill to length
        generateParenthesis(arrayList, stringBuilder, n, n, 0);
        return arrayList;
    }

    private void generateParenthesis(List<String> result, StringBuilder buffer, int remainingOpen, int remainingClose, int charIndex) {
        if (remainingClose == 0) {
            result.add(buffer.toString());
            return;
        }

        if (remainingOpen > 0) {
            buffer.setCharAt(charIndex, '(');
            generateParenthesis(result, buffer, remainingOpen - 1, remainingClose, charIndex + 1);
        }

        if (remainingOpen < remainingClose) {
            buffer.setCharAt(charIndex, ')');
            generateParenthesis(result, buffer, remainingOpen, remainingClose - 1, charIndex + 1);
        }
    }

}
