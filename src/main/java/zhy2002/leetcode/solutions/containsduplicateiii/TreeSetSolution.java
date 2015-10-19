package zhy2002.leetcode.solutions.containsduplicateiii;

import java.util.TreeSet;

/**
 * Maintain a window of sorted elements, then search in the window for a value close enough with the target value. This can be done with a TreeSet.
 * http://www.programcreek.com/2014/06/leetcode-contains-duplicate-iii-java/
 */
public class TreeSetSolution implements Solution {

    @Override
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k < 1 || t < 0)
            return false;

        TreeSet<Integer> window = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            //check if there is a value in the window which is in the range of [v-t, v+t]
            Integer v = nums[i];
            long min = (long)nums[i] - t;     //avoid overflow
            long max = (long)nums[i] + t;
            Integer leftNeighbour = window.floor(v);
            if(leftNeighbour != null && leftNeighbour >= min && leftNeighbour <= max) {
                return true;
            }

            Integer rightNeighbour = window.ceiling(v);
            if(rightNeighbour != null && rightNeighbour >= min && rightNeighbour <= max){
                return true;
            }

            window.add(v);
            if(i >= k){
                window.remove(nums[i - k]);//keep at most t elements in the window
            }
        }

        return false;
    }
}
