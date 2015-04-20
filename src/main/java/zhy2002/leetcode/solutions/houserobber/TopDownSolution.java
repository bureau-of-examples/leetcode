package zhy2002.leetcode.solutions.houserobber;

import java.util.Arrays;

/**
 *
 * Top down dp.
 */
public class TopDownSolution implements Solution{

    private int[] cache;

    @Override
    public int rob(int[] num) {

        cache = new int[num.length];
        Arrays.fill(cache, -1);
        return rob(num, 0);
    }

    private int rob(int[] num, int i) {
        if (i >= num.length)
            return 0;
        if (cache[i] == -1) {
            cache[i] = Math.max(rob(num, i + 1), num[i] + rob(num, i + 2));
        }
        return cache[i];
    }

}
