package zhy2002.leetcode.solutions.isomorphicstrings;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * Check if there is a 1-1 mapping f between distinct chars in s and t such that f(s)=t and f(t)=s.
 */
public class Solution {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(!map.containsKey(ch1)) {
                if(map.containsValue(ch2))
                    return false;

                map.put(ch1, ch2);    //map first occurrence of ch1 to ch2 if ch2 is not already mapped
            } else {
                if(map.get(ch1) != ch2) //for subsequent occurrences of ch1 ensure ch2 is the what ch1 maps to.
                    return false;
            }

        }
        return true;
    }
}
