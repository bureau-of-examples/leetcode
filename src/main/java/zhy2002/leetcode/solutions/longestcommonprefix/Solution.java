package zhy2002.leetcode.solutions.longestcommonprefix;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * Just a double loop.
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        String first = strs[0];
        int endIndex = -1;
        boolean loop = true;
        while (loop && ++endIndex < first.length()){
            for(int i=1; i<strs.length; i++){
                if(endIndex == strs[i].length() || strs[i].charAt(endIndex) != first.charAt(endIndex)){
                    loop = false;
                    break;
                }
            }
        }

        return first.substring(0, endIndex);
    }
}
