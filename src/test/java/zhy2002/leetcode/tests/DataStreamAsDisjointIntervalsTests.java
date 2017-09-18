package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/description/
 */
public class DataStreamAsDisjointIntervalsTests {

    /**
     * Definition for an interval.
     * public class Interval {
     * int start;
     * int end;
     * Interval() { start = 0; end = 0; }
     * Interval(int s, int e) { start = s; end = e; }
     * }
     */
    class SummaryRanges {

        private boolean dirty;
        private List<Interval> intervals = new ArrayList<>();
        private final PriorityQueue<Integer> values = new PriorityQueue<>();

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
        }

        public void addNum(int val) {
            dirty = true;
            values.add(val);
        }

        public List<Interval> getIntervals() {
            if (dirty) {
                merge();
                dirty = false;
            }
            return intervals;
        }

        private void merge() {
            if (values.isEmpty())
                return;

            List<Interval> newIntervals = new ArrayList<>();
            int index = 0;
            Integer previous = null;
            while (!values.isEmpty()) {
                Integer val = values.poll();
                if (previous != null && previous.equals(val))
                    continue;
                previous = val;
                while (index < intervals.size() && intervals.get(index).end < val) {
                    appendInterval(newIntervals, intervals.get(index++));
                }
                if (index == intervals.size() || intervals.get(index).start > val) {
                    appendInterval(newIntervals, new Interval(val, val));
                }
            }
            while (index < intervals.size()) {
                appendInterval(newIntervals, intervals.get(index++));
            }
            intervals = newIntervals;
        }

        private void appendInterval(List<Interval> newIntervals, Interval interval) {
            if (newIntervals.isEmpty() || newIntervals.get(newIntervals.size() - 1).end < interval.start - 1) {
                newIntervals.add(interval);
            } else {
                newIntervals.get(newIntervals.size() - 1).end = interval.end;
            }
        }
    }

    @Test
    public void test() {
        SummaryRanges ranges = new SummaryRanges();
        ranges.addNum(403);
        ranges.addNum(405);
        ranges.addNum(392);
        assertThat(Utils.intervalsToString(ranges.getIntervals()), equalTo("[[392,392],[403,403],[405,405]]"));
        ranges.addNum(391);
        ranges.addNum(402);
        assertThat(Utils.intervalsToString(ranges.getIntervals()), equalTo("[[391,392],[402,403],[405,405]]"));
        ranges.addNum(406);
        assertThat(Utils.intervalsToString(ranges.getIntervals()), equalTo("[[391,392],[402,403],[405,406]]"));
    }

}
