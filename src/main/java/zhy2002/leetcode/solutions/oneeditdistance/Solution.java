package zhy2002.leetcode.solutions.oneeditdistance;

/**
 * https://leetcode.com/problems/one-edit-distance/
 * Check if we can convert s to t with a single insertion, deletion or substitution.
 */
public class Solution {

    public boolean isOneEditDistance(String s, String t) {

        //ensure len(s)>=len(t)
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }

        int diffCount = 0;
        if (s.length() == t.length()) {
            //if s and t have the same length, then they should at most differ by 1 char.
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diffCount++;
                    if (diffCount > 1)
                        return false;
                }
            }
            return diffCount == 1;
        } else if (s.length() - t.length() == 1) {
            int i = 0, j = 0;
            do {
                if (j == t.length()) {//when i < s.length() and j == t.length()
                    diffCount++;//insert at the end of t
                    break;
                }
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                } else { //delete ch[i] from s.
                    i++;
                    diffCount++;
                    if (diffCount > 1)
                        return false;
                }
            } while (i < s.length() || j < t.length());
            return diffCount == 1;
        }
        //length difference is greater than 1, edit distance > 1
        return false;
    }
}
