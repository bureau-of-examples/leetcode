package zhy2002.leetcode.solutions.meetingroomsii;

import zhy2002.leetcode.common.Interval;

import java.util.Arrays;

/**
 * Same idea as PriorityQueueSolution, but use merging to implement.
 */
public class MergeSolution implements Solution {

    @Override
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int openCount = 0;
        int maxOpenCount = 0;
        //do merge
        int nextStart = 0, nextEnd = 0;
        while (nextStart < start.length || nextEnd < end.length){
            if(nextStart < start.length && (nextEnd < end.length && start[nextStart] < end[nextEnd] || nextEnd >= end.length)){
                openCount++;
                nextStart++;
            } else {
                openCount--;
                nextEnd++;
            }
            maxOpenCount = openCount > maxOpenCount ? openCount : maxOpenCount;
        }

        return maxOpenCount;
    }
}
