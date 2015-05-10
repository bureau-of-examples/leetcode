package zhy2002.leetcode.solutions.wordbreakii;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/word-break-ii/
 */
public class Solution {

    @SuppressWarnings("unchecked")
    public List<String> wordBreak(String s, Set<String> dict) {

        //make sure all chars are in dict.
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(String word : dict){
            if(first)
                first = false;
            else
                sb.append(" ");

            if(sb.indexOf(word) == -1)
                sb.append(word);
        }

        for(int i=0; i<s.length(); i++){
            if(sb.indexOf(s.substring(i, i + 1)) == -1)
                return new ArrayList<>();
        }

        //normal dp
        List<String>[] breakFrom = new ArrayList[s.length()]; //break from i to the end
        breakFrom[s.length() - 1] = new ArrayList<>();
        if (dict.contains(s.substring(s.length() - 1)))
            breakFrom[s.length() - 1].add(s.substring(s.length() - 1)); //populate the last one

        for (int i = s.length() - 2; i >= 0; i--) {
            breakFrom[i] = new ArrayList<>();
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (dict.contains(substring)) {
                    if (j == s.length() - 1) {
                        breakFrom[i].add(substring);
                    } else {
                        for (String b : breakFrom[j + 1]) {
                            breakFrom[i].add(substring + " " + b);
                        }
                    }
                }
            }
        }
        return breakFrom[0];

    }

}
