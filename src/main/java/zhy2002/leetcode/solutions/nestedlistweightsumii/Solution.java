package zhy2002.leetcode.solutions.nestedlistweightsumii;

import zhy2002.leetcode.common.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/nested-list-weight-sum-ii/
 * <p>
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 * <p>
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
 * <p>
 * Example 2:
 * Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 */
public class Solution {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> levelSums = new ArrayList<>();
        calculateLevelSums(levelSums, nestedList, 1);
        return weightedSum(levelSums);
    }

    private void calculateLevelSums(List<Integer> levelSums, List<NestedInteger> nestedList, int currentLevel) {
        if(levelSums.size() < currentLevel) {
            levelSums.add(0);
        }
        int levelIndex = currentLevel - 1;
        for(NestedInteger item : nestedList) {
            if(item.isInteger()) {
                levelSums.set(levelIndex, item  .getInteger() + levelSums.get(levelIndex));
            } else {
                calculateLevelSums(levelSums, item.getList(), currentLevel + 1);
            }
        }
    }

    private int weightedSum(List<Integer> levelSums) {
        int sum = 0;
        int weight = levelSums.size();
        for(Integer levelSum : levelSums) {
            sum += levelSum * weight--;
        }
        return sum;
    }
}
