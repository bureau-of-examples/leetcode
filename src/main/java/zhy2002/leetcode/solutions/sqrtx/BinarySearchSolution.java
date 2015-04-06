package zhy2002.leetcode.solutions.sqrtx;

/**
 * Binary search in the range of Math.min(x, maxRoot).
 */
public class BinarySearchSolution implements Solution {

    @Override
    public int sqrt(int x) {
        if (x <= 1)
            return x;

        int maxRoot = 46340;//floor(sqrt(2^31-1))

        int start = 1, end = Math.min(x, maxRoot);
        while (start <= end) {
            int mid = (start + end) >>> 1;
            int square = mid * mid;
            if (square == x)
                return mid;
            if (square > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }
}
