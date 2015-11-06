package zhy2002.leetcode.solutions.shortestworddistanceii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/shortest-word-distance-ii/
 * This is a follow up of Shortest Word Distance.
 * The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters.
 * How would you optimize it?
 */
public class WordDistance {

    private HashMap<String, List<Integer>> wordIndices = new HashMap<>();//the indices for a word is in ascending order

    public WordDistance(String[] words) {

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (wordIndices.containsKey(word)) {
                wordIndices.get(word).add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                wordIndices.put(word, indices);
            }
        }
    }

    public int shortest(String word1, String word2) {

        List<Integer> indices1 = wordIndices.get(word1);
        List<Integer> indices2 = wordIndices.get(word2);

        //do a merge of the two list and check the neighbouring values if they are from difference sequence
        int shortest = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < indices1.size() && j < indices2.size()) {
            int dist = indices1.get(i) - indices2.get(j);
            if(dist > 0){
                shortest = Math.min(shortest, dist);
                j++;
            } else {
                shortest = Math.min(shortest, -dist);
                i++;
            }
        }
        return shortest;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");