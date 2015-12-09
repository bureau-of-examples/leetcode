package zhy2002.leetcode.solutions.meetingrooms;

import zhy2002.leetcode.common.Interval;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/meeting-rooms/
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 */
public class Solution {

    public boolean canAttendMeetings(Interval[] intervals) {
        //sort by start time
        Arrays.parallelSort(intervals, (o1, o2) -> o1.start - o2.start);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
    }

}
