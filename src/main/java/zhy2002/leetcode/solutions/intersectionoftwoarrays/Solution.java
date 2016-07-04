package zhy2002.leetcode.solutions.intersectionoftwoarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p>
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hashArray;
        int[] otherArray;
        if(nums1.length >= nums2.length) {
            hashArray = nums1;
            otherArray = nums2;
        } else {
            hashArray = nums2;
            otherArray = nums1;
        }

        HashSet<Integer> hashSet = new HashSet<>(hashArray.length);
        for(int num : hashArray) {
            hashSet.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for(int num : otherArray) {
            if(hashSet.contains(num)) {
                result.add(num);
                hashSet.remove(num);
            }
        }

        int[] resultArray = new int[result.size()];
        for(int i=0; i<resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}
