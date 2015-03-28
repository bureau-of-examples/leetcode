package zhy2002.leetcode.solutions.regularexpressionmatching;


/**
 * Dynamic programming solution.
 * DP relation is 2d matrix that s[0~i] matches p[0,j]
 */
public class DpSolution implements Solution {
    @Override
    public boolean isMatch(String s, String p) {

//        if(!RecursiveSolution.possiblyMatch(s, p))//handle that special test case.
//            return false;

        boolean[][] canMatch = new boolean[s.length() + 1][p.length() + 1];//if up to s[i] can match up to p[j], default all to false; empty string padded to the beginning
        canMatch[0][0] = true; //empty pattern string matches empty string.
        for (int j = 1; j <= p.length(); j++) {//figure out empty string can match to what j.
            if (j < p.length() && p.charAt(j) == '*') {
                j++;//position j when we get x*
                canMatch[0][j] = true; //if j is *, we never use canMatch column j-1.
            } else {
                break;
            }
        }

        for (int j = 1; j <= p.length(); j++) {//fill column by column
            int prevJ = j - 1;//used to locate last column comparison result
            if (j < p.length() && p.charAt(j) == '*') {
                j++;//position j when we get x*
            }
            int pIndex = j - 1;
            char pCh = p.charAt(pIndex);
            char prevCh = pIndex < 1 ? '\0' : p.charAt(pIndex - 1);
            boolean hasMatchJ = false;
            for (int i = 1; i <= s.length(); i++) {
                char sCh = s.charAt(i - 1);
                if (pCh == '*') {

                    //char match or char dont match
                    //if char match then we also need to ensure previous char match previous pattern or previous char match this pattern
                    if ((sCh == prevCh || prevCh == '.') && (canMatch[i - 1][j] || canMatch[i - 1][prevJ]) || canMatch[i][prevJ]) {
                        canMatch[i][j] = true;
                        hasMatchJ = true;
                    }

                } else if (pCh == sCh || pCh == '.') {
                    if (canMatch[i - 1][prevJ]) {
                        canMatch[i][j] = true;
                        hasMatchJ = true;
                    }
                }
            }

            if (!hasMatchJ && j + 1 <= p.length() && canMatch[0][j + 1]) //early termination condition
                break;
        }
        return canMatch[s.length()][p.length()];
    }
}
