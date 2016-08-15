package zhy2002.leetcode.solutions.regularexpressionmatching;

/**
 * Naive recursive solution with special handling of a corner case.
 */
public class RecursiveSolution implements Solution {

    @Override
    public boolean isMatch(String s, String p) {
        if (!possiblyMatch(s, p))
            return false;

        return isMatch(s, 0, p, 0);
    }

    public static boolean possiblyMatch(String s, String p) {
        if (p.length() == 0)
            return s.length() == 0;

        int minLen = 0;//min string length required to match pattern
        int pIndex = 1;//require at least 1 char
        while (pIndex < p.length()) {
            if (p.charAt(pIndex) == '*') {
                pIndex++;
                if (pIndex < p.length())
                    pIndex++;

            } else {
                pIndex++;
                minLen++;
            }
        }
        if (p.charAt(pIndex - 1) != '*')
            minLen++;

        //this condition is necessary to pass a special test case:
        //if source string is not long enough then dont bother
        return s.length() >= minLen;

    }

    private boolean isMatch(String s, int sIndex, String p, int pIndex) {
        if (pIndex >= p.length()) {
            return sIndex >= s.length();
        }

        char pChar = p.charAt(pIndex);
        if (pIndex != p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            do {
                if (isMatch(s, sIndex, p, pIndex + 2))
                    return true;
            } while (sIndex < s.length() && (pChar == '.' || s.charAt(sIndex) == pChar) && ++sIndex >= 0);
            return false;
        } else if (pChar == '.' || sIndex < s.length() && pChar == s.charAt(sIndex)) {
            return isMatch(s, sIndex + 1, p, pIndex + 1);
        } else {
            return false;
        }
    }

}
