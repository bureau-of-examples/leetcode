package zhy2002.leetcode.solutions.twosum;

import java.util.HashMap;

/**
 * https://leetcode.com/discuss/27634/java-solution-using-hash-table
 */
public class ReferenceSolution implements Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.length; i++) {
            if (table.containsKey(numbers[i])) {//this number is the required number by a previous number
                result[0] = table.get(numbers[i]) + 1;
                result[1] = i + 1;
            }
            table.put(target - numbers[i], i);
        }

        return result;
    }
}
