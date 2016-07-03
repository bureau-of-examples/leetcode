package zhy2002.leetcode.additional.enumeratesubsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * CCI question 8.3:
 * Enumerate all subsets.
 */
public class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> enumerateSubsets(List<Integer> list) {
        result = new ArrayList<>((int)Math.pow(2, list.size()));
        LinkedList<Integer> buffer = new LinkedList<>();
        enumerateSubsets(list, list.size() - 1, buffer);
        return result;
    }

    private void enumerateSubsets(List<Integer> list, int index, LinkedList<Integer> buffer) {
        if (index < 0) {
            result.add(new ArrayList<>(buffer));
            return;
        }

        enumerateSubsets(list, index - 1, buffer);
        buffer.addLast(list.get(index));
        enumerateSubsets(list, index - 1, buffer);
        buffer.removeLast();
    }
}
