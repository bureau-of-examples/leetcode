package zhy2002.leetcode.solutions.shortestpalindrome;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 */
public class Solution {

    public String shortestPalindrome(String s) {
        if(s.length() <= 1)
            return s;

        int left = (s.length() - 1) / 2;
        int right = s.length() / 2;

        while (left >= 0){
            int l = left;
            int r = right;
            while (l >= 0 && s.charAt(l) == s.charAt(r)){
              l--; r++;
            }

            if(l<0){
                left = l;
                right = r;
            } else {
                if(left == right){
                    left--;
                } else {
                    right--;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i=s.length() - 1; i>=right; i--){
            result.append(s.charAt(i));
        }
        result.append(s);
        return result.toString();

    }

}
