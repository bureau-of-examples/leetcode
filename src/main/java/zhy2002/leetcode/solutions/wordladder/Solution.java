package zhy2002.leetcode.solutions.wordladder;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-ladder/
 */
public class Solution {

    private static int diffCount(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

    //search from both ends
    @SuppressWarnings("unchecked")
    public int ladderLength(String start, final String end, Set<String> dict) {

        if (start.length() != end.length())
            return 0;

        int diffCount = diffCount(start, end);
        if (diffCount <= 1)
            return diffCount + 1;

        if(dict.size() < 3)//assume start and end will always be in dict
            return 0;

        //populate data structure
        HashSet<String>[][] layers = new HashSet[2][2];//{{start front, start back}, {end front, end back}}
        for (int i = 0; i < layers.length; i++) {
            for (int j = 0; j < layers[i].length; j++) {
                layers[i][j] = new HashSet<>();
            }
        }
        int thisLayer = 0;
        int otherLayer = 1;
        int[] frontIndex = {0, 0}; //front set index
        int[] backIndex = {1,1};
        layers[thisLayer][frontIndex[thisLayer]].add(start);
        layers[otherLayer][frontIndex[otherLayer]].add(end);
        int[] step = {1, 1};

        while(true) {
            //draw from thisLayer frontSet
            HashSet<String> frontSet = layers[thisLayer][frontIndex[thisLayer]];
            if (frontSet.isEmpty()) {
                if(layers[thisLayer][backIndex[thisLayer]].isEmpty()) //backSet is also empty, no point searching in it
                    break;
                frontIndex[thisLayer] = backIndex[thisLayer];
                backIndex[thisLayer] = (frontIndex[thisLayer] + 1) % 2;
                step[thisLayer]++;
                thisLayer = otherLayer;
                otherLayer = (thisLayer + 1) % 2;
            } else {
                String current = frontSet.iterator().next();
                frontSet.remove(current); //de-queue
                if (layers[otherLayer][frontIndex[otherLayer]].contains(current))
                    return step[0] + step[1] - 1;

                dict.remove(current);
                //reach to neighbour and put into backSet
                for (int i = 0; i < current.length(); i++) {
                    char[] chars = current.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch != chars[i]) {
                            char oriCh = chars[i];
                            chars[i] = ch;
                            String newWord = new String(chars);
                            chars[i] = oriCh;
                            if (dict.contains(newWord)) {
                                layers[thisLayer][backIndex[thisLayer]].add(newWord);
                            }
                        }
                    }
                }

            }
        }

        return 0;
    }
}
