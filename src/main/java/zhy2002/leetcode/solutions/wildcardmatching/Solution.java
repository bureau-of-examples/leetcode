package zhy2002.leetcode.solutions.wildcardmatching;

/**
 * https://leetcode.com/problems/wildcard-matching/
 * //todo alternative implementation using string matching (index of)
 */
public class Solution {

    //dp solution
    public boolean isMatch(String s, String p) {

        //check for trivial case in linear time
        int patternMinLen = 0;
        for(int i = 0; i < p.length(); i++){
            if(p.charAt(i) != '*')
                patternMinLen++;
        }
        if(s.length() < patternMinLen)
            return false;

        //dp first line
        boolean[][] match = new boolean[p.length() + 1][s.length() + 1];
        match[0][0] = true;//empty string match empty string
        int firstMatch = 0;
        for(int j=1; j<=s.length(); j++){
            match[0][j] = false; //empty string dont match
        }

        //dp in O(m*n)
        for(int i=1; i<=p.length(); i++){
            if(firstMatch > s.length())
                return false;

            //col 0
            match[i][0] = match[i-1][0] && p.charAt(i - 1) == '*';
            int previousFirstMatch = firstMatch;
            firstMatch = match[i][0] ? 0 : s.length() + 1;

            for(int j=1; j<=s.length(); j++){
                if(p.charAt(i - 1) == '*'){
                    if(i >= 2 && p.charAt(i - 2) == '*')
                        match[i][j] = match[i - 1][j];
                    else
                        match[i][j] = j >= previousFirstMatch;
                } else if(p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1)){
                    match[i][j] = match[i-1][j-1];
                } else {
                    match[i][j] = false;
                }

                if(firstMatch > s.length() && match[i][j])
                    firstMatch = j;
            }
        }

        return match[p.length()][s.length()];
    }
}
