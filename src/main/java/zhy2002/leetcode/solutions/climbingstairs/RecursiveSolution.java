package zhy2002.leetcode.solutions.climbingstairs;

import java.util.HashMap;

/**
 * fibonacci with top down dp.
 */
public class RecursiveSolution {

    private final HashMap<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 1)
            return 1;
        Integer result = cache.get(n);
        if (result == null) {

            result = climbStairs(n - 2) + climbStairs(n - 1);
            cache.put(n, result);
        }

        return result;
    }
}
