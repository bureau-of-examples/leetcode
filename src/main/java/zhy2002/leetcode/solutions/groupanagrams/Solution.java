package zhy2002.leetcode.solutions.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/group-anagrams/#/description
 * Given an array of strings, return all groups of strings that are groupanagrams.
 */
public class Solution {

    //Calculate groupanagrams signature and use it to create a hash key.
    public List<String> anagrams(String[] strs) {

        int[] letterCounts = new int[26];
        StringBuilder keyBuilder = new StringBuilder();
        HashMap<String, List<String>> buckets = new HashMap<>();

        for (String str : strs) {
            //calc key
            for (int i = 0; i < str.length(); i++) {
                letterCounts[str.charAt(i) - 'a']++;
            }
            for (int i = 0; i < letterCounts.length; i++) {
                if (letterCounts[i] > 0) {
                    keyBuilder.append((char) (i + 'a'));
                    keyBuilder.append(letterCounts[i]);
                }
            }
            String key = keyBuilder.toString();
            List<String> bucket = buckets.get(key);
            if (bucket == null) {
                bucket = new ArrayList<>();
                buckets.put(key, bucket);
            }
            bucket.add(str);

            Arrays.fill(letterCounts, 0); //clear
            keyBuilder.setLength(0);
        }

        List<String> result = new ArrayList<>();
        for (List<String> bucket : buckets.values()) {
            if (bucket.size() > 1) {
                result.addAll(bucket);
            }
        }

        return result;
    }
}
