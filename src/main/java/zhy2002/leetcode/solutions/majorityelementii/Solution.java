package zhy2002.leetcode.solutions.majorityelementii;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
 */
public class Solution {

    //count the frequency of the integers.
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        //there will be at most 2 such elements
        int number1 = 0, number2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {
            if (count1 <= 0 && (count2 == 0 || number2 != num)) {
                number1 = num;
                count1 = 1;
            } else if (number1 == num) {
                count1++;
            } else if (count2 <= 0) {
                number2 = num;
                count2 = 1;
            } else if (number2 == num) {
                count2++;
            } else {
                //if number is majority, count will > 0 if we throw away three different values
                count1--;
                count2--;
            }
        }

        //now get the frequency of the top 2 most frequent elements
        int realFrequency1 = 0, realFrequency2 = 0;
        for(int num : nums){
            if(num == number1){
                realFrequency1++;
            }
            if(num == number2){
                realFrequency2++;
            }
        }
        if(count1 > 0 && realFrequency1 > nums.length / 3){
            result.add(number1);
        }
        if(count2 > 0 && realFrequency2 > nums.length / 3){
            result.add(number2);
        }
        return result;

    }
}
