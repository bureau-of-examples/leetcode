package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray2Tests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals(1, solution.search(new int[]{3, 1}, 1));
    }

    public class Solution {
        public int search(int[] A, int target) {
            int start = 0, end = A.length - 1;
            while (start <= end) {
                int mid = (start + end) >>> 1;
                if (A[mid] == target)
                    return mid;

                if (A[start] <= A[mid]) { //left is sorted
                    if (target >= A[start] && target < A[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else { //right is sorted
                    if (target > A[mid] && target <= A[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

}
