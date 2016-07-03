package zhy2002.leetcode.solutions.longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Use a list minEndElements where:
 * minEndElements[i] is the minimum end element of a sub sequence with length = i.
 * In another word, in the sub-list [0, i], of all the sub-sequences which has a length j,
 * we find the one with minimum end element and give its value to minEndElements[j].
 * See https://leetcode.com/discuss/67565/simple-java-o-nlogn-solution
 */
public class NLogNSolution implements Solution {

    @Override
    public int lengthOfLIS(int[] nums) {
        List<Integer> minEndElements = new ArrayList<>();
        for (int num : nums) {
            if (minEndElements.isEmpty() || minEndElements.get(minEndElements.size() - 1) < num) {
                minEndElements.add(num);
            } else {
                //find which element num can replace.
                int pos = Collections.binarySearch(minEndElements, num);
                if (pos < 0)
                    minEndElements.set(-pos - 1, num); //sub-sequence with length (-pos-1) can be smaller.
            }
        }
        return minEndElements.size();
    }
}
