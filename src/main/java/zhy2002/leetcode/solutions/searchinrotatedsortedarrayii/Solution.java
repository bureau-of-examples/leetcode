package zhy2002.leetcode.solutions.searchinrotatedsortedarrayii;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class Solution {

    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0)
            return false;

        int start = 0;
        int end = A.length - 1;

        while (start <= end) {//binary search
            int mid = (start + end) >>> 1;
            if (A[mid] == target)
                return true;

            int newStart = start;
            while (newStart < mid && A[newStart] == A[mid])//skip
                newStart++;

            if (newStart == mid) {
                start = mid + 1;
                continue;
            }

            if (A[newStart] < A[mid] && (target < A[newStart] || target > A[mid])) {//target is no in [newStart, mid]
                start = mid + 1;
                continue;
            }

            start = newStart;

            int newEnd = end;
            while (newEnd > mid && A[newEnd] == A[mid])
                newEnd--;

            if (newEnd == mid) {
                end = mid - 1;
                continue;
            }

            if (A[mid] < A[newEnd] && (target < A[mid] || target > A[newEnd])) {//target is not in [mid, newEnd]
                end = mid - 1;
                continue;
            }
            end = newEnd;

            if (A[start] < A[mid] && target >= A[start] && target < A[mid]) {//[start, mid] is sorted and
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

}
