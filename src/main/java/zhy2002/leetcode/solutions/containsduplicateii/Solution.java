package zhy2002.leetcode.solutions.containsduplicateii;

import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> values = new HashSet<>();
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                values.remove(nums[j++]);
            }

            if(values.contains(nums[i]))
                return true;
            values.add(nums[i]);
        }

        return false;
    }

}
