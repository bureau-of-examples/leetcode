package zhy2002.leetcode.solutions.movingaveragefromdatastream;

import java.util.LinkedList;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 */
public class MovingAverage {

    private long sum = 0;
    private final LinkedList<Integer> window = new LinkedList<>();
    private final int windowSize;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.windowSize = size;
    }

    public double next(int val) {
        sum += val;
        window.addLast(val);
        int size = window.size();
        if(size > windowSize) {
            sum -= window.pollFirst();
            size = windowSize;
        }
        return (double) sum / size;
    }
}
