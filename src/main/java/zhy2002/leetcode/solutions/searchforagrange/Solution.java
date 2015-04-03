package zhy2002.leetcode.solutions.searchforagrange;

/**
 * https://leetcode.com/problems/search-for-a-range/
 * binary search twice.
 */
public class Solution {

    public int[] searchRange(int[] A, int target) {
        if (A == null)
            return new int[]{-1, -1};

        //search for left border
        int start = 0, end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (A[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int leftBound = end + 1;
        if (leftBound >= A.length || A[leftBound] != target)
            return new int[]{-1, -1};

        //search for right border
        start = leftBound + 1;
        end = A.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[]{leftBound, start - 1};
    }

}
