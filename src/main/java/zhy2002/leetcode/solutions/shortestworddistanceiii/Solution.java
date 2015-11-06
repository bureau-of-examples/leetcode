package zhy2002.leetcode.solutions.shortestworddistanceiii;

/**
 * https://leetcode.com/problems/shortest-word-distance-iii/
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 */
public class Solution {

    public int shortestWordDistance(String[] words, String word1, String word2) {

        boolean sameWord = word1.equals(word2);
        int lastIndex = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if(lastIndex == -1){
                    lastIndex = i;
                    continue;
                }
                if (sameWord || !words[lastIndex].equals(words[i])) {
                    result = Math.min(result, i - lastIndex);
                }
                lastIndex = i;
            }
        }
        return result;
    }
}
