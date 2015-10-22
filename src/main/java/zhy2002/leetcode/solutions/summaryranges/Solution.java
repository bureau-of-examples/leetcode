package zhy2002.leetcode.solutions.summaryranges;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/
 * <p>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();
        int start = 0, end = -1;
        for (int num : nums) {
            if (end < start) {
                start = end = num;
            } else {
                if (num == end + 1) {
                    end = num;
                } else {
                    addEntry(result, start, end);
                    start = end = num;
                }
            }
        }
        addEntry(result, start, end);

        return result;
    }

    private void addEntry(List<String> result, int start, int end) {
        if (start == end) {
           result.add(String.valueOf(start));
        } else if(start < end){
            result.add(String.valueOf(start) + "->" + String.valueOf(end));
        }
    }
}
