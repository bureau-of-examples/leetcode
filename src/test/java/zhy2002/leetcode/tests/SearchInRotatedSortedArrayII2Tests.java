package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArrayII2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(false, solution.search(new int[]{4, 4, 4}, 3));
        assertEquals(false, solution.search(new int[]{}, 3));
        assertEquals(true, solution.search(new int[]{3}, 3));
        assertEquals(true, solution.search(new int[]{4, 4, 3}, 3));
        assertEquals(true, solution.search(new int[]{3, 3, 3, 3, 3, 1, 2, 3, 3}, 3));
        assertEquals(false, solution.search(new int[]{3, 3, 3, 3, 3, 1, 2, 3, 3}, 0));
        assertEquals(true, solution.search(new int[]{3, 3, 3, 3, 3, 1, 2, 3, 3}, 1));
        assertEquals(false, solution.search(new int[]{3, 3, 3, 3, 3, 1, 2, 3, 3}, 4));
        assertEquals(false, solution.search(new int[]{3, 3, 3, 3, 3, 1, 2}, 4));
        assertEquals(true, solution.search(new int[]{3, 3, 3, 3, 3, 1, 2}, 1));
        assertEquals(true, solution.search(new int[]{3, 1, 2}, 2));
        assertEquals(false, solution.search(new int[]{3, 1, 3}, 2));
        assertEquals(true, solution.search(new int[]{3, 1, 3}, 1));
        assertEquals(true, solution.search(new int[]{3, 1, 3}, 3));
        assertEquals(true, solution.search(new int[]{4, 5, 1, 2, 3}, 2));
        assertEquals(true, solution.search(new int[]{4, 5, 1, 2, 3}, 4));
        assertEquals(true, solution.search(new int[]{4, 5, 1, 2, 3}, 3));
        assertEquals(false, solution.search(new int[]{4, 5, 1, 2, 3}, 0));
    }

    public class Solution {
        public boolean search(int[] A, int target) {
            if (A.length == 0)
                return false;

            return doSearch(A, target, 0, A.length - 1) != -1;
        }

        private int doSearch(int[] A, int target, int start, int end) {
            if (start > end)
                return -1;

            int mid = (start + end) >>> 1;
            if (A[mid] == target)
                return mid;

            while (A[start] == A[mid] && start < mid) {
                start++;
            }
            while (A[end] == A[mid] && end > mid) {
                end--;
            }

            if (start == mid) {
                if (end == mid)
                    return -1;
                return doSearch(A, target, mid + 1, end);
            }
            if (end == mid) {
                return doSearch(A, target, start, mid - 1);
            }

            if (A[start] < A[mid]) { //left is sorted
                if (target >= A[start] && target < A[mid]) {
                    return doSearch(A, target, start, mid - 1);
                } else {
                    return doSearch(A, target, mid + 1, end);
                }
            } else { //right is sorted
                if (target <= A[end] && target > A[mid]) {
                    return doSearch(A, target, mid + 1, end);
                } else {
                    return doSearch(A, target, start, mid - 1);
                }
            }
        }
    }
}
