package zhy2002.leetcode.solutions.interleavingstring;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/interleaving-string/
 * Dp on:
 * isInterleaving[i,j] = s1[0~i] and s2[0~j] can form s3[0~i+j].
 * isInterleaving[i + 1,j + 1] = isInterleaving[i,j + 1] and s2[i+1] == s3[i+j+1] or isInterleaving[i,j + 1] and s1[j+1] == s3[i+j+1]
 */
public class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() < s2.length())
            return isInterleave(s2, s1, s3); //s1.len >= s2.len

        if (s1.length() + s2.length() != s3.length())//check impossible case
            return false;

        //row 1
        boolean[] buffer = new boolean[s1.length() + 1];//buffer[0] for empty string, rolling array for 2d dp
        Arrays.fill(buffer, false);
        buffer[0] = true;
        for (int j = 0; j < s1.length(); j++) {//if empty string and s1 can interleave into s3.
            if (buffer[j] && s1.charAt(j) == s3.charAt(j))
                buffer[j + 1] = true;
            else
                break;
        }

        for (int i = 0; i < s2.length(); i++) {//each char in s2
            boolean allFalse = true;
            if (buffer[0]) {
                buffer[0] = s2.charAt(i) == s3.charAt(i);//empty string and s2 can interleave into s3
                allFalse = !buffer[0];
            }
            for (int j = 0; j < s1.length(); j++) {

                boolean newVal = false;
                if (buffer[j]) {
                    newVal = s1.charAt(j) == s3.charAt(i + j + 1);
                }

                if (!newVal && buffer[j + 1]) {
                    newVal = s2.charAt(i) == s3.charAt(i + j + 1);
                }

                if (allFalse && newVal)
                    allFalse = false;

                buffer[j + 1] = newVal;//set the next
            }
            if (allFalse)//early exit
                break;
        }

        return buffer[buffer.length - 1];
    }

}
