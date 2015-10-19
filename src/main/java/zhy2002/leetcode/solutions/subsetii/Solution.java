package zhy2002.leetcode.solutions.subsetii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/subsets-ii/
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        if (num == null)
            return null;
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); //empty set

        //add element num[i] to each subset
        int previousStart = 0, previousEnd = 0;
        for (int i = 0; i < num.length; i++) {//non-ascending order: for (int i = num.length - 1; i >= 0; i--) {
            if (i != 0 && num[i] != num[i - 1]) //not dup //non-ascending order: if (i != num.length - 1 && num[i] != num[i + 1])
                previousStart = 0;

            for (int j = previousStart; j <= previousEnd; j++) { //form a new subset by putting num[i] in each of the existing subsets, which are all subsets of [num[0], num[i-1]]
                ArrayList<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(num[i]);
                result.add(subset);
            }
            previousStart = previousEnd + 1;
            previousEnd = result.size() - 1;
        }
        return result;
    }
}
