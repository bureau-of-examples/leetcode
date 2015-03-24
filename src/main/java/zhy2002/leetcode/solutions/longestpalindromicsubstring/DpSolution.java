package zhy2002.leetcode.solutions.longestpalindromicsubstring;


/**
 * Dynamic programming solution.
 * s(i,j) is palindrome if s(i) = s(j) and s(i+1, j-1) is palindrome (j - i >= 2).
 */
public class DpSolution implements Solution {

    @Override
    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];//if i to j is palindrome.
        int longestI = 0, longestJ = 0;
        for(int i=0; i<s.length();i++){//j-i=0
            isPalindrome[i][i] = true;
        }

        for(int i=0; i<s.length() - 1; i++){//j-i=1
            if(s.charAt(i) == s.charAt(i+1)){
                isPalindrome[i][i+1] = true;
                if(longestJ - longestI < 2){
                    longestI = i;
                    longestJ = i + 1;
                }
            }
        }

        for(int i=s.length() - 3; i>=0; i--){//bottom up, left to right
            for(int j=i+2; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && isPalindrome[i+1][j-1]){//only the bottom left is needed, isPalindrome can be reduced to a rolling array
                    isPalindrome[i][j] = true;
                    if(j - i > longestJ - longestI){
                        longestI = i;
                        longestJ = j;
                    }
                }
            }
        }
        return s.substring(longestI, longestJ + 1);
    }
}
