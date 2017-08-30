package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


class Point {
    int[] range;
    boolean isStart;

    public Point(int[] range, boolean isStart) {
        this.range = range;
        this.isStart = isStart;
    }

    int getValue() {
        return isStart ? range[0] : range[1];
    }
}

class Pair {
    int time;
    int count;

    public Pair(int time, int count) {
        this.time = time;
        this.count = count;
    }
}

public class ScheduleTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.construct(new int[][]{{1, 3}, {2, 4}, {3, 4}, {-1, 10}});
        assertThat(solution.query(0), equalTo(1));
        assertThat(solution.query(1), equalTo(2));
        assertThat(solution.query(2), equalTo(3));
        assertThat(solution.query(3), equalTo(3));
        assertThat(solution.query(4), equalTo(1));

        solution.construct(new int[][]{{1, 3}, {2, 4}, {3, 4}});
        assertThat(solution.query(0), equalTo(0));
        assertThat(solution.query(1), equalTo(1));
        assertThat(solution.query(2), equalTo(2));
        assertThat(solution.query(3), equalTo(2));
        assertThat(solution.query(4), equalTo(0));

        solution.construct(new int[][]{{1, 3}, {2, 4}});
        assertThat(solution.query(0), equalTo(0));
        assertThat(solution.query(1), equalTo(1));
        assertThat(solution.query(2), equalTo(2));
        assertThat(solution.query(3), equalTo(1));
        assertThat(solution.query(4), equalTo(0));

        solution.construct(new int[][]{{1, 2}, {2, 3}});
        assertThat(solution.query(0), equalTo(0));
        assertThat(solution.query(1), equalTo(1));
        assertThat(solution.query(2), equalTo(1));
        assertThat(solution.query(3), equalTo(0));

        solution.construct(new int[][]{{1, 2}});
        assertThat(solution.query(0), equalTo(0));
        assertThat(solution.query(1), equalTo(1));
        assertThat(solution.query(2), equalTo(0));
    }

    public class Solution {
        private List<Pair> pairs;

        public void construct(int[][] ranges) {
            List<Point> points = new ArrayList<>();
            for (int[] range : ranges) {
                points.add(new Point(range, true));
                points.add(new Point(range, false));
            }

            Collections.sort(points, (p1, p2) -> p1.getValue() - p2.getValue()); //bug Arrays
            pairs = new ArrayList<>();
            int count = 0;
            Point prevPoint = null;
            for (Point point : points) {
                if (prevPoint == null) {
                    pairs.add(new Pair(point.getValue(), 0)); //bug missing
                    prevPoint = point;
                } else if (prevPoint.getValue() != point.getValue()) {
                    pairs.add(new Pair(point.getValue(), count));
                    prevPoint = point;
                }
                if (point.isStart) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        public int query(int time) {
            Pair pair = new Pair(time, 0);
            int pos = Collections.binarySearch(pairs, pair, (p1, p2) -> p1.time - p2.time);
            if (pos >= 0) {
                pos++;
                if (pos >= pairs.size())
                    return 0;
                return pairs.get(pos).count;
            }
            pos = -pos - 1;
            if (pos >= pairs.size())
                return 0;
            return pairs.get(pos).count;
        }
    }
}
