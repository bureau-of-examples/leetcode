package zhy2002.leetcode.solutions.countingbits;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/counting-bits/
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class Solution {

    private static final Map<Integer, Integer> LEFT_ZERO_BITS;

    //from i to i+1 minus the bits that are set to 0 and add the bits that are set to 1.
    //for a much better solution see https://discuss.leetcode.com/topic/40162/three-line-java-solution.
    static {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i <= 30; i++) {
            map.put(1 << i, i);
        }
        LEFT_ZERO_BITS = Collections.unmodifiableMap(map);
    }

    public int[] countBits(int num) {

        int[] result = new int[num + 1];
        int previous = 0;
        for (int i = 1; i <= num; i++) {
            if (previous % 2 == 0) { //if the last bit is 0
                result[i] = result[previous] + 1;
            } else {
                int mask = i & -i; //isolate the right most 0 bit of previous and flip.
                result[i] = result[previous] + 1 - LEFT_ZERO_BITS.get(mask);
            }
            previous = i;
        }
        return result;
    }
}
