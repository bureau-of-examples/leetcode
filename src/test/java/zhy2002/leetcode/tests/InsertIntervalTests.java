package zhy2002.leetcode.tests;


import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.Interval;
import zhy2002.leetcode.solutions.insertinterval.Solution;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InsertIntervalTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 5));
        intervals.add(new Interval(6, 8));
        Interval newInterval = new Interval(5, 6);
        List<Interval> result = solution.insert(intervals, newInterval);

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).start);
        assertEquals(8, result.get(0).end);

        intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(5,6));
        intervals = solution.insert(intervals, new Interval(3, 4));
        assertEquals("[[1,2],[3,4],[5,6]]", Utils.intervalsToString(intervals));
        intervals = solution.insert(intervals, new Interval(2, 3));
        assertEquals("[[1,4],[5,6]]", Utils.intervalsToString(intervals));
        intervals = solution.insert(intervals, new Interval(3,8));
        assertEquals("[[1,8]]", Utils.intervalsToString(intervals));
        intervals = solution.insert(intervals, new Interval(9, 12));
        assertEquals("[[1,8],[9,12]]", Utils.intervalsToString(intervals));
        intervals = solution.insert(intervals, new Interval(0, 2));
        assertEquals("[[0,8],[9,12]]", Utils.intervalsToString(intervals));
        intervals = solution.insert(intervals, new Interval(7, 10));
        assertEquals("[[0,12]]", Utils.intervalsToString(intervals));
        intervals = solution.insert(intervals, new Interval(24, 26));
        assertEquals("[[0,12],[24,26]]", Utils.intervalsToString(intervals));
        intervals = solution.insert(intervals, new Interval(-10, -9));
        assertEquals("[[-10,-9],[0,12],[24,26]]", Utils.intervalsToString(intervals));
        intervals = solution.insert(intervals, new Interval(-6, -3));
        assertEquals("[[-10,-9],[-6,-3],[0,12],[24,26]]", Utils.intervalsToString(intervals));
        intervals = solution.insert(intervals, new Interval(17, 19));
        assertEquals("[[-10,-9],[-6,-3],[0,12],[17,19],[24,26]]", Utils.intervalsToString(intervals));
        intervals = solution.insert(intervals, new Interval(19, 20));
        assertEquals("[[-10,-9],[-6,-3],[0,12],[17,20],[24,26]]", Utils.intervalsToString(intervals));
    }

}
