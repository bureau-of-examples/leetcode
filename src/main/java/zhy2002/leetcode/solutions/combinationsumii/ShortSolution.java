package zhy2002.leetcode.solutions.combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://blog.csdn.net/linhuanmars/article/details/20829099
 * A concise Java solution from the Internet.Idea is the same.
 * This might be slower than the other two solutions (319ms v.s. 284ms).
 */
public class ShortSolution implements Solution {

    @Override
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        helper(num, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] num, int start, int target, List<Integer> item, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        if (target < 0 || start >= num.length)
            return;
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1]) continue;
            item.add(num[i]);
            helper(num, i + 1, target - num[i], item, res);
            item.remove(item.size() - 1);
        }
    }
}
