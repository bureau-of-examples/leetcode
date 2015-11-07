package zhy2002.leetcode.solutions.largenumber;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-number/
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 */
public class Solution {

    /*
        Given the transitivity, it is easier to envisage why this works with bubble sort.
        Starting from an arbitrary order, each time we place the most suitable number to be the first.
        If that largest number is not the first, we can always bubble it up to obtain greater results.
    */
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            strings[i] = String.valueOf(nums[i]);
        }
        /* Proof of transitivity:
Assume we have three numbers in string format a, b, and c and a | b | c is the largest result can be obtained.
then we know (a | b) > (b | a) and (b | c) > (c | b).
Assume (c | a) > (a | c) (no transitivity), then we have:
(c | a | b) > (a | c | b) > (a | b | c). This contradicts a | b | c is the largest.
        */

        Arrays.sort(strings, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        StringBuilder result = new StringBuilder();
        for(int i=strings.length - 1; i>=0; i--){
            result.append(strings[i]);
            if(i==strings.length - 1 && strings[i].equals("0"))//avoid "0000"
                break;
        }
        return result.toString();
    }
}
