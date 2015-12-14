package zhy2002.leetcode.solutions.meetingroomsii;

import zhy2002.leetcode.common.Interval;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
public interface Solution {

    int minMeetingRooms(Interval[] intervals);
}
