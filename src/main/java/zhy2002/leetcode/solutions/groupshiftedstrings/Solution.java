package zhy2002.leetcode.solutions.groupshiftedstrings;

import java.util.*;

/**
 * https://leetcode.com/problems/group-shifted-strings/
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 *
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return:
 *
 * [
 * ["abc","bcd","xyz"],
 * ["az","ba"],
 * ["acef"],
 * ["a","z"]
 * ]
 * Note: For the return value, each inner list's elements must follow the lexicographic order.
 */
public class Solution {

    //Use a hash table to determine which group the string belongs.
    //Calc hash key: in the same group iff char-wise distance is the same (mod 26)
    //shift the first char to 'a', then the rest chars are shifted the same distance then we get a key.
    public List<List<String>> groupStrings(String[] strings) {

        HashMap<String, ArrayList<String>> groups = new HashMap<>();
        for (String str: strings) {
            if(str.length() == 0){
                addValue(groups, str, str);
                continue;
            }
            String key = calcKey(str);
            addValue(groups, key, str);
        }
        List<List<String>> result = new ArrayList<>(groups.values());
        result.forEach(list -> list.sort(Comparator.naturalOrder()));
        return result;
    }

    private String calcKey(String str) {
        char[] keyChars = new char[str.length() - 1];
        char firstChar = str.charAt(0);
        for(int i=1; i<str.length(); i++){
            keyChars[i - 1] = (char) ('a' + ((str.charAt(i) - firstChar) + 26) % 26);
        }
        return new String(keyChars);
    }

    private void addValue(HashMap<String, ArrayList<String>> groups, String key, String str) {
        if(!groups.containsKey(key)){
            groups.put(key, new ArrayList<>());
        }
        groups.get(key).add(str);
    }
}
