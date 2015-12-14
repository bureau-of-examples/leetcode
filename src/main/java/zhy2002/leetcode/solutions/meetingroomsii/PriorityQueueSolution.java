package zhy2002.leetcode.solutions.meetingroomsii;

import zhy2002.leetcode.common.Interval;

import java.util.PriorityQueue;

/**
 * See the start time and end time as opening and closing brackets.
 * Closing bracket is applied before opening bracket.
 * At each time point check the number of opening brackets, which is the number of ongoing meetings.
 * We want to find the maximum number of parallel on going meetings.
 */
public class PriorityQueueSolution implements Solution {

    @Override
    public int minMeetingRooms(Interval[] intervals) {
        //sort time points by time and end brackets before start brackets at the same time point
        PriorityQueue<Interval> timePoints = new PriorityQueue<>((x, y) -> x.start == y.start ? x.end - y.end : x.start - y.start);
        for(Interval interval : intervals){
            Interval startBracket = new Interval();
            startBracket.start = interval.start;
            startBracket.end = 1;
            timePoints.add(startBracket);
            Interval endBracket = new Interval();
            endBracket.start = interval.end;
            endBracket.end = -1;
            timePoints.add(endBracket);
        }

        int openCount = 0;
        int maxOpenCount = 0;
        while (!timePoints.isEmpty()) {
            Interval point = timePoints.poll();
            openCount += point.end;
            maxOpenCount = openCount > maxOpenCount ? openCount : maxOpenCount;
        }
        return maxOpenCount;
    }
}
