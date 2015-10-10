package zhy2002.leetcode.solutions.findminimuminrotatedsortedarray;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution {

    public int findMin(int[] num) {
        if (num == null || num.length == 0)
            throw new IllegalArgumentException("num");

        //trivial case
        if (num[0] <= num[num.length - 1])
            return num[0];

        //bin search min point
        int start = 0;
        int end = num.length - 1;
        int mid;
        do {
            mid = (start + end) >>> 1;
            if (num[mid] < num[end])
                end = mid;
            else
                start = mid;

        } while (start + 1 < end);
        return num[end];

    }

}
