package zhy2002.leetcode.solutions.mergeintervals;

import zhy2002.leetcode.common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null)
            return null;

        List<Interval> result = new ArrayList<>();
        if (intervals.size() > 0) {
            quickSortByStart(intervals, 0, intervals.size() - 1);
            int startIndex = 0, endIndex = 0;
            int maxEnd = intervals.get(startIndex).end;
            do {
                if (endIndex < intervals.size() && intervals.get(endIndex).start <= maxEnd) {
                    maxEnd = Math.max(maxEnd, intervals.get(endIndex).end);
                    endIndex++;
                    continue;
                }
                result.add(new Interval(intervals.get(startIndex).start, maxEnd));
                startIndex = endIndex;
                if (startIndex < intervals.size()) {
                    maxEnd = intervals.get(startIndex).end;
                }
            } while (startIndex < intervals.size());
        }

        return result;
    }

    private static void quickSortByStart(List<Interval> intervals, int start, int end) {
        if (start >= end)
            return;

        int mid = (start + end) >>> 1;
        swap(intervals, start, mid);
        mid = start; //partition point
        int partitionVal = intervals.get(start).start;

        for (int i = start + 1; i <= end; i++) {
            if (intervals.get(i).start < partitionVal) {
                swap(intervals, ++mid, i);
            }
        }
        swap(intervals, start, mid);
        quickSortByStart(intervals, start, mid - 1);
        quickSortByStart(intervals, mid + 1, end);
    }

    private static void swap(List<Interval> intervals, int i, int j) {
        if (i == j)
            return;

        Interval temp = intervals.get(i);
        intervals.set(i, intervals.get(j));
        intervals.set(j, temp);
    }

}
