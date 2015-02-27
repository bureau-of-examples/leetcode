package zhy2002.leetcode.solutions.insertinterval;

import zhy2002.leetcode.common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/insert-interval/
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //bin search first interval that is covered by new interval start
        int start = 0, end = intervals.size() - 1;
        while (start <= end){
            int mid = (start + end) >>> 1;
            if(intervals.get(mid).end < newInterval.start){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int coverStart = start;

        //bin search last interval that is covered new interval end
        start = 0; end = intervals.size() - 1;
        while (start <= end){
            int mid = (start + end) >>> 1;
            if(intervals.get(mid).start <= newInterval.end){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int coverEnd = end;

        //merge
        Interval merged = new Interval(newInterval.start, newInterval.end);
        if(coverStart <= coverEnd){
            merged.start = Math.min(intervals.get(coverStart).start, merged.start);
            merged.end = Math.max(intervals.get(coverEnd).end, merged.end);
        }
        List<Interval> result = new ArrayList<>();
        for(int i=0; i< coverStart; i++){
            result.add(intervals.get(i));
        }
        result.add(merged);
        for(int i=coverEnd + 1; i < intervals.size(); i++){
            result.add(intervals.get(i));
        }
        return result;
    }
}
