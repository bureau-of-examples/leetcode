package zhy2002.leetcode.solutions.shortestworddistance;

/**
 * https://leetcode.com/problems/shortest-word-distance/
 *
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 */
public class Solution {

    public int shortestDistance(String[] words, String word1, String word2) {

        int lastIndex = -1;
        String lastWord = null;
        int distance = words.length;

        for(int i=0; i<words.length; i++){
            if(words[i].equals(word1)){
                if(lastIndex == -1){
                    lastIndex = i;
                    lastWord = word1;
                } else {
                    if(lastWord.equals(word1)){
                        lastIndex = i;
                    } else {
                        distance = Math.min(i - lastIndex, distance);
                        lastIndex = i;
                        lastWord = word1;
                    }
                }
            } else if(words[i].equals(word2)){
                if(lastIndex == -1){
                    lastIndex = i;
                    lastWord = word2;
                } else {
                    if(lastWord.equals(word2)){
                        lastIndex = i;
                    } else {
                        distance = Math.min(i - lastIndex, distance);
                        lastIndex = i;
                        lastWord = word2;
                    }
                }
            }
        }

        return distance;
    }
}
