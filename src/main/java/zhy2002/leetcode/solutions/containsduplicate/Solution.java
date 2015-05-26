package zhy2002.leetcode.solutions.containsduplicate;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(Integer num : nums){
            if(hashSet.contains(num))
                return true;
            hashSet.add(num);
        }
        return false;
    }
}
