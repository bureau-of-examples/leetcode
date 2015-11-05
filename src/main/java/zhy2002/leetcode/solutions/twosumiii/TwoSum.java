package zhy2002.leetcode.solutions.twosumiii;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 */
public class TwoSum {

    HashMap<Integer, Boolean> numbers = new HashMap<>(); //all numbers added are stored as key.
    // The boolean value indicate: false -> there has been only one such value; true -> at least added twice

    public void add(int number) {
        Integer num = number;
        Boolean hasMoreThan1 = numbers.get(num);
        if (hasMoreThan1 == null)
            numbers.put(num, Boolean.FALSE);
        else if (hasMoreThan1 == Boolean.FALSE)
            numbers.put(num, Boolean.TRUE);
    }

    public boolean find(int value) {
        for (Integer num : numbers.keySet()) {
            Boolean hasMoreThan1 = numbers.get(num);
            Integer target = value - num;
            if (target.equals(num))
                return hasMoreThan1 == Boolean.TRUE;
            else if (numbers.containsKey(target))
                return true;
        }
        return false;
    }
}