package zhy2002.leetcode.solutions.editdistance;

/**
 * https://oj.leetcode.com/problems/edit-distance/
 */
public class Solution {

    public int minDistance(String word1, String word2) {

        int[] dist = new int[word2.length() + 1];
        for(int j=0; j<dist.length; j++)//empty string to word2
            dist[j] = j;

        for(int i=1; i<=word1.length(); i++){
            int distJ_1 = i;

            for(int j=1; j<dist.length; j++){
                int distJ;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    distJ = dist[j-1];
                } else {
                    int change = dist[j-1];
                    int insert = dist[j];
                    int delete = distJ_1;
                    distJ = Math.min(change, Math.min( insert, delete)) + 1;
                }
                dist[j-1] = distJ_1;
                distJ_1 = distJ;
            }
            dist[word2.length()] = distJ_1;
        }

        return  dist[word2.length()];
    }

}
