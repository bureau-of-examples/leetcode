package zhy2002.leetcode.solutions.palindromepartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 */
public class Solution {

    public List<List<String>> partition(String s) {

        if(s == null)
            return null;

        List<List<String>> result = new ArrayList<>();
        List<Integer> partition = new ArrayList<>();
        partition.add(0);//split before i; 0 serves as a sentinel.
        enumerate(result, s, partition);
        return result;
    }

    private void enumerate(List<List<String>> result, String s, List<Integer> partition){
        int lastSplit = partition.get(partition.size() - 1);
        if(lastSplit  == s.length()){//partition is complete
            ArrayList<String> item = new ArrayList<>();
            for(int i=1; i<partition.size();i++){
                item.add(s.substring(partition.get(i-1), partition.get(i)));
            }
            result.add(item);
            return;
        }

        for(int end = lastSplit; end < s.length(); end++) {
            if (isPalindrome(s, lastSplit, end)) {
                partition.add(end + 1);
                enumerate(result, s, partition);
                partition.remove(partition.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end){
        while (start < end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++; end--;

        }
        return true;
    }
}
