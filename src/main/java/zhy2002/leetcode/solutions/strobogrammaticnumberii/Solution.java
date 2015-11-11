package zhy2002.leetcode.solutions.strobogrammaticnumberii;

import java.util.*;

/**
 * https://leetcode.com/problems/strobogrammatic-number-ii/
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 * For example,
 * Given n = 2, return ["11","69","88","96"].
 */
public class Solution {

    public List<String> findStrobogrammatic(int n) {
        return findAll(n, true);
    }

    private List<String> findAll(int n, boolean topLevel) {
        ArrayList<String> result = new ArrayList<>();

        if (n == 0) {
            result.add("");
        } else if (n == 1) {
            result.add("0");
            result.add("1");
            result.add("8");
        } else if (n > 1) {
            result = new ArrayList<>();
            List<String> subResult = findAll(n - 2, false);
            for (String value : subResult) {
                if (!topLevel) {
                    result.add("0" + value + "0");
                }
                result.add("1" + value + "1");
                result.add("6" + value + "9");
                result.add("8" + value + "8");
                result.add("9" + value + "6");
            }
        }
        return result;
    }

}
