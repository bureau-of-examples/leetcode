package zhy2002.leetcode.solutions.twosum;

import java.util.HashMap;

/**
 * For each number in the array, check if there is a previous number which equals target - number.
 * Use a hash map to achieve O(1) lookup of a matching previous number.
 */
public class HashMapSolution implements Solution {

    @Override
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer otherNumber = target - numbers[i];
            if (valueToIndex.containsKey(otherNumber))
                return new int[]{valueToIndex.get(otherNumber) + 1, i + 1};
            else
                valueToIndex.put(numbers[i], i);
        }
        return null;
    }
}
