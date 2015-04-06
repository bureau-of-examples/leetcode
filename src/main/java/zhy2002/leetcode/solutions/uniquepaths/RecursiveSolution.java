package zhy2002.leetcode.solutions.uniquepaths;

/**
 * Naive recursion. You get TLE in online judge.
 */
public class RecursiveSolution implements Solution {

    private int width, height;

    private int countRecursive(int x, int y) {
        int total = 0;

        if(x == width - 1)
            return 1;

        if (y == height - 1)
            return 1;

        total += countRecursive(x + 1, y);
        total += countRecursive(x, y + 1);
        return total;

    }

    @Override
    public int uniquePaths(int m, int n) {
        this.width = m;
        this.height = n;
        return countRecursive(0, 0);
    }
}
