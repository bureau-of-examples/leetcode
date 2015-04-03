package zhy2002.leetcode.solutions.searchinrotatedsortedarray;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * Binary search.
 */
public class Solution {

    public int search(int[] A, int target) {
        if (A == null)
            return -1;

        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;

            if (A[mid] == target)
                return mid;


            if (A[start] <= A[mid]) {//first part in order
                if (target < A[start] || target > A[mid]) {//not in first part
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < A[mid] || target > A[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

}
