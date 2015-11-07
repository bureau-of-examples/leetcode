package zhy2002.leetcode.solutions.repeateddnasequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class Solution {

    //hash code for char a to t
    private int[] CHAR_HASH = {0,0,1,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,3};

    //convert each 10 chars long substring to a integer for fast checking using a hash map.
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        //if(s.length() < 20) //uncomment this is the requirement is the repeated substring cannot overlap
        if (s.length() < 11)
            return result;

        int hash = 0;
        int i = 0; //one pass pointer
        for (; i < 10; i++) {//calculate the hash code for the first substring.
            hash = (hash << 2) | CHAR_HASH[s.charAt(i) - 'A'];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(hash, i - 1);
        while (i < s.length()) {
            hash = (hash << 2) & 0x000FFFFF | CHAR_HASH[s.charAt(i) - 'A'];
            Integer firstPosition = map.get(hash); //first position of the last char
            if (firstPosition == null) {
                map.put(hash, i);
            } else {
//                if(previousPos <= i - 10){  //uncomment this is the requirement is the repeated substring cannot overlap
//                    result.add(s.substring(i-9, i + 1));
//                    map.put(hash, Integer.MAX_VALUE);
//                }
                if(firstPosition > 0){//-1 if already added
                    result.add(s.substring(i - 9, i + 1));
                    map.put(hash, -1); //don't add again
                }
            }
            i++;
        }
        return result;
    }

}
