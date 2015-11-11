package zhy2002.leetcode.solutions.palindromepartitioningii;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class Solution {
    public int minCut(String s) {

        if (s.length() == 0)
            return 0;

        //find out if s(i to j) is palindrome
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            isPalindrome[i][i] = true;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        //find min cut at i
        int[] minCut = new int[s.length() + 1];
        minCut[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            int minCutHere = minCut[i - 1] + 1;
            for (int j = i - 1; j >= 1; j--) {
                if (isPalindrome[j - 1][i - 1]) {
                    minCutHere = Math.min(minCutHere, minCut[j - 1] + 1);
                }
            }
            minCut[i] = minCutHere;
        }

        return minCut[s.length()] - 1;
    }
}
