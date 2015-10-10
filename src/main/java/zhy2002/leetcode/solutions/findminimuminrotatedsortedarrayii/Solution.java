package zhy2002.leetcode.solutions.findminimuminrotatedsortedarrayii;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class Solution {

    public int findMin(int[] num) {
        if (num == null || num.length == 0)
            throw new IllegalArgumentException();

        int minPos = 0;
        int start = 0;
        int end = num.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (num[start] < num[mid]) { //[start, mid] is sorted
                if (num[minPos] > num[start]) {
                    minPos = start;
                }
                start = mid + 1;
                continue;
            }

            if (num[mid] < num[end]) { //[mid, end] is sorted
                if (num[minPos] > num[mid]) {
                    minPos = mid;
                }
                end = mid - 1;
                continue;
            }
            //num[mid] <= num[start] && num[mid] >= num[end] and num[mid] >= num[start] || num[mid] <= num[end] <= because its a rotated sorted array
            /*
                Let a = num[start], b = num[mid], c = num[end]
                Then the above is (b<=a && b>=c) && (b>=a || b<=c) <=> a=b && b>=c || a<=b && b=c
                So we next we move a and/or c to skip duplicate values
            */
            if (num[minPos] > num[mid]) //compare with mid to get min
                minPos = mid;

            while (start < end && num[start] == num[mid]) //can skip these
                start++;

            while (end >= start && num[end] == num[mid]) //can skip these
                end--;

        }

        return num[minPos];
    }
}
