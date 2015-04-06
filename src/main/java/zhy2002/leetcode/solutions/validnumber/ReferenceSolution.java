package zhy2002.leetcode.solutions.validnumber;

/**
 * Concise reference solution from Leetcode e-book.
 * This is less comprehensive than my solution (it returns true for ^\s*[+-]\d+(\.\d*){0,1}\s*$).
 */
public class ReferenceSolution implements Solution{
    @Override
    public boolean isNumber(String s) {
        int i=0, n=s.length();
        while (i<n && Character.isWhitespace(s.charAt(i)))//skip leading white space
            i++;
        if(i<n && (s.charAt(i) == '-' || s.charAt(i) == '+'))//skip sign
            i++;
        boolean isNumeric = false;
        while (i<n && Character.isDigit(s.charAt(i))){
            i++;
            isNumeric = true;
        }
        if(i<n && s.charAt(i) == '.'){
            i++;
            while (i<n && Character.isDigit(s.charAt(i))){
                i++;
                isNumeric = true;
            }
        }
        while (i<n && Character.isWhitespace(s.charAt(i)))
            i++;
        return isNumeric && i == n;
    }
}
