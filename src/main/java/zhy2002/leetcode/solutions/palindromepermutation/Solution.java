package zhy2002.leetcode.solutions.palindromepermutation;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/palindrome-permutation/
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class Solution {

    public boolean canPermutePalindrome(String s) {

        HashSet<Character> cache = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(cache.contains(ch)){
                cache.remove(ch);
            } else {
                cache.add(ch);
            }
        }

        return cache.size() <= 1;
    }
}
