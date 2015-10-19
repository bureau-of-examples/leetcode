package zhy2002.leetcode.solutions.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/combination-sum/
 */
public class Solution {

    private int[] candidates;
    private int target;
    private List<Integer> path; //current path
    int sum;
    List<List<Integer>> result;

    //assume there are not duplicates in candidates
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null)
            return null;

        //initialization
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        this.path = new ArrayList<>();
        sum = 0;
        result = new ArrayList<>();

        findCombinationSum(0);
        return result;
    }

    /**
     * Check if the current path is a solution. If not try add node.
     * When this is called sum is guaranteed to be <= target.
     * @param nodeIndex Index in candidates array. nodeIndex is the first index >= all indices in the current path.
     * @return return false if sum >= target.
     */
    private boolean findCombinationSum(int nodeIndex){

        if(sum > target)
            return false;

        if(sum == target){
            result.add(new ArrayList<>(path));
            return false;
        }

//        int diff = target - sum;
//        //binary search for the first bigger than diff
//        int start = 0, end = candidates.length - 1;
//        while (start <= end){
//            int mid = (start + end) >>> 1;
//            if(candidates[mid] <= diff){
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }

        for(int i=nodeIndex;/*avoid duplicates*/ i<candidates.length; i++){
            path.add(candidates[i]);
            sum += candidates[i];
            boolean continueExpand = findCombinationSum(i);
            path.remove(path.size() - 1);
            sum -= candidates[i];
            if(!continueExpand)
                break;
        }

        return true;
    }
}
