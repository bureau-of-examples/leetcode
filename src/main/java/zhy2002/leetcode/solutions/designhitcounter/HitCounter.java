package zhy2002.leetcode.solutions.designhitcounter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * <p>
 * Each function accepts a timestamp parameter (in seconds granularity) and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 * <p>
 * It is possible that several hits arrive roughly at the same time.
 * <p>
 * Example:
 * <p>
 * HitCounter counter = new HitCounter();
 * <p>
 * // hit at timestamp 1.
 * counter.hit(1);
 * <p>
 * // hit at timestamp 2.
 * counter.hit(2);
 * <p>
 * // hit at timestamp 3.
 * counter.hit(3);
 * <p>
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 * <p>
 * // hit at timestamp 300.
 * counter.hit(300);
 * <p>
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 * <p>
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 * <p>
 * Follow up:
 * What if the number of hits per second could be very large? Does your design scale?
 */
public class HitCounter {

    interface House {
        default String getAddress() {
            return "101 Main Str";
        }
    }

    interface Office {
        static String getAddress() {
            return "101 Smart Str";
        }
    }

    class WFH implements House, Office {

        public void f1() {
            getAddress();
        }

    }

    private static class CountNode {
        int selfCount; //just this second
        int accumulatedCount; //300 from here.

        CountNode(int selfCount, int accumulatedCount) {
            this.selfCount = selfCount;
            this.accumulatedCount = accumulatedCount;
        }

        void increase() {
            this.selfCount++;
            this.accumulatedCount++;
        }
    }

    private static final int PERIOD = 300;
    private TreeMap<Integer, CountNode> index = new TreeMap<>();

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        hit(timestamp, true);
    }

    private void hit(int timestamp, boolean hit) {

        Map.Entry<Integer, CountNode> last = index.lastEntry();
        if (last == null) {
            if (hit)
                index.put(timestamp, new CountNode(1, 1));
        } else {
            if (last.getKey() == timestamp) {
                if (hit)
                    last.getValue().increase();
            } else {
                int minKey = timestamp - PERIOD + 1; //inclusive
                if (last.getKey() < minKey) {
                    index.clear();
                    if (hit)
                        index.put(timestamp, new CountNode(1, 1));
                } else {
                    int totalSoFar = last.getValue().accumulatedCount;
                    while (index.firstKey() < minKey) {
                        totalSoFar -= index.pollFirstEntry().getValue().selfCount;
                    }
                    int val = hit ? 1 : 0;
                    index.put(timestamp, new CountNode(val, totalSoFar + val));
                }
            }
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        hit(timestamp, false); //push timestamp forward
        Map.Entry<Integer, CountNode> entry = index.floorEntry(timestamp);
        if (entry == null)
            return 0;
        return entry.getValue().accumulatedCount;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */