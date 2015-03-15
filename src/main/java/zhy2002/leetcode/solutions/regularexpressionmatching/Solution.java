package zhy2002.leetcode.solutions.regularexpressionmatching;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        if(p.length() == 0)
            return s.length() == 0;

        int minLen = 0;
        int pIndex = 1;
        while (pIndex < p.length()){
            if(p.charAt(pIndex) == '*'){
                pIndex++;
                if(pIndex < p.length())
                    pIndex++;

            } else {
                pIndex++;
                minLen++;
            }
        }
        if(p.charAt(pIndex - 1) != '*')
            minLen++;

        if(s.length() < minLen)
            return false;

        return isMatch(s, 0, p, 0);
    }

    private boolean isMatch(String s, int sIndex, String p,int pIndex){
        if(pIndex >= p.length()){
            return sIndex >= s.length();
        }

        char pChar = p.charAt(pIndex);
        if(pIndex != p.length() - 1 && p.charAt(pIndex + 1) == '*'){
            do{
                if(isMatch(s, sIndex, p, pIndex + 2))
                    return true;
            }while (sIndex < s.length() && (pChar == '.' || s.charAt(sIndex) == pChar) && ++sIndex >= 0);
            return false;
        } else if (pChar == '.' || sIndex < s.length() && pChar == s.charAt(sIndex)){
            return isMatch(s, sIndex + 1, p, pIndex + 1);
        } else {
            return false;
        }
    }
}
