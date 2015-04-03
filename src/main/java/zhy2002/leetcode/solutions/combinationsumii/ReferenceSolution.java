package zhy2002.leetcode.solutions.combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Also recursive but shorter.
 * This solution is from an internet dude.
 */
public class ReferenceSolution implements Solution {

    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length == 0)
            return new ArrayList<>();

        Arrays.sort(candidates);
        ArrayList<Integer> index = new ArrayList<Integer>();
        index.add(-1);
        List<List<Integer>> ret = new ArrayList<>();
        combinationSum(candidates, target, 0, index, ret);
        return ret;
    }

    void combinationSum(int[] candidates, int target, int sum, List<Integer> index, List<List<Integer>> ans) {
        int n = candidates.length;
        int k = index.size();
        if (sum > target) {//pruning
            return;
        }
        if (sum == target) {
            ans.add(generateCombination(candidates, index));
            return;//pruning
        }

        for (int i = index.get(k - 1) + 1; i < n; ) {//avoid duplicates
            index.add(i);
            combinationSum(candidates, target, sum + candidates[i], index, ans);
            index.remove(k);
            int prev = candidates[i];
            while (i < n && candidates[i] == prev) i++;
        }
    }

    List<Integer> generateCombination(int[] candidates, List<Integer> index) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int k = index.size();
        for (int i = 1; i < k; i++) {
            ret.add(candidates[index.get(i)]);
        }
        return ret;
    }
}
