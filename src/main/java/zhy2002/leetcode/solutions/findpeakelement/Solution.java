package zhy2002.leetcode.solutions.findpeakelement;

/**
 * https://leetcode.com/problems/find-peak-element/
 */
public class Solution {

    public int findPeakElement( int[] num) {
        if (num == null || num.length == 0)
            throw new IllegalArgumentException("num");

        int start = 0;
        int end = num.length - 1;

        while (start < end) {
            int mid = (start + end) >>> 1;
            if (mid > 0 && num[mid - 1] > num[mid]) {//there must be a peak in [start, mid-1] because if a) mid-1 to start always increases, start is a peak; b) otherwise there is a peak
                end = mid - 1;
                continue;
            }

            if (mid < num.length - 1 && num[mid + 1] > num[mid]) {//there must be a peak in [mid+1, end] because if a)mid+1 to end always increases, end is a peak; otherwise there is a peak
                start = mid + 1;
                continue;
            }

            //if mid is not the first nor the last, it is a peak
            //if mid is first but is not last, it is a peak
            //if mid is not first but is last, it is a peak
            //if mid is first and last, it is a peak
            return mid;

        }
        return start;

    }

}
