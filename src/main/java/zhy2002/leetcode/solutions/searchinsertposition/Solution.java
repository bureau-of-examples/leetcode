package zhy2002.leetcode.solutions.searchinsertposition;

/**
 * https://leetcode.com/problems/search-insert-position/
 * Binary Search.
 */
public class Solution {

    //target will be inserted before the returned index.
    public int searchInsert(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            int midVal = A[mid];
            if (midVal == target)
                return mid;
            else if (midVal > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }


}
