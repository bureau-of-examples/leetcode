package zhy2002.leetcode.solutions.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 * in turn generate subsets of size 0, 1, 2, ...
 */
public class Solution {

    public List<List<Integer>> subsets(int[] S) {
        if (S == null)
            return null;

        Arrays.sort(S);
        HashMap<Integer, Integer> valueIndex = new HashMap<>();
        for (int i = 0; i < S.length; i++)
            valueIndex.put(S[i], i);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());//seed
        int start = 0;
        int end = 0;
        while (true) {
            for (int j = start; j <= end; j++) {
                List<Integer> prevItem = result.get(j);
                if (prevItem.size() == S.length)
                    return result;
                int startIndex = prevItem.size() == 0 ? 0 : valueIndex.get(prevItem.get(prevItem.size() - 1)) + 1;
                for (int i = startIndex; i < S.length; i++) {
                    List<Integer> item = new ArrayList<>(prevItem);
                    item.add(S[i]);
                    result.add(item);
                }
            }
            start = end + 1;
            end = result.size() - 1;
        }

    }
}
