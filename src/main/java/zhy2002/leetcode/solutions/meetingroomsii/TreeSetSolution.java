package zhy2002.leetcode.solutions.meetingroomsii;

import zhy2002.leetcode.common.Interval;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * A slow TreeSet based solution.
 */
public class TreeSetSolution implements Solution {

    @Override
    public int minMeetingRooms(Interval[] intervals) {

        int nextRoomId = -1;
        Arrays.sort(intervals, (x, y) -> x.start - y.start); //sort meetings by start time
        //A binary search tree which contains all allocated meeting rooms:
        //A meeting room = meeting room id + meeting room end time.
        //Because TreeSet cannot have duplicates, we need to have unique meeting room id.
        //The order is by meeting end time then by reverse allocation order
        TreeSet<Interval> rooms = new TreeSet<>((x, y) -> x.end == y.end ? x.start - y.start : x.end - y.end);
        for (Interval interval : intervals) {
            Interval query = new Interval();
            query.start = query.end = interval.start;
            Interval room = rooms.floor(query); //find the last available room (biggest end time and if end time is the same then use one allocated the first)
            if (room == null) {
                room = new Interval(); //allocate a room
                room.start = nextRoomId--;
                room.end = interval.end;
                rooms.add(room);
            } else {
                if (room.end < interval.end) {
                    rooms.remove(room);
                    room.end = interval.end; //update room
                    rooms.add(room);
                }
            }
        }
        return rooms.size();
    }
}
