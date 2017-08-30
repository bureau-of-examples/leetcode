package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/#/description
 */
public class FindMedianFromDataStreamTests {

    @Test
    public void test() {
        MedianFinder2 solution = new MedianFinder2();
        solution.addNum(100);
        assertThat(solution.findMedian(), equalTo(100d));
        solution.addNum(120);
        assertThat(solution.findMedian(), equalTo(110d));
        solution.addNum(50);
        assertThat(solution.findMedian(), equalTo(100d));
        solution.addNum(140);
        assertThat(solution.findMedian(), equalTo(110d));
    }

    private class MedianFinder2 {
        private PriorityQueue<Integer> left = new PriorityQueue<>((x, y) -> y - x);
        private PriorityQueue<Integer> right = new PriorityQueue<>();

        public void addNum(int num) {
            left.add(num);
            if (right.isEmpty()) {
                if (left.size() > 1) {
                    right.add(left.poll());
                }
                return;
            }
            if (left.peek() > right.peek()) {
                int l = left.poll();
                int r = right.poll();
                left.add(r);
                right.add(l);
            }
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            }
        }

        public double findMedian() {
            if (right.size() != left.size()) {
                return left.peek();
            }

            return ((double) left.peek() + right.peek()) / 2;
        }

    }

    public class MedianFinder {

        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Adds a number into the data structure.
        public void addNum(int num) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(num);
                return;
            }

            if (num > maxHeap.peek()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }

            while (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            while (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
        }

        // Returns the median of current data stream
        public double findMedian() {
            if (minHeap.size() != maxHeap.size()) {
                return maxHeap.peek();
            }

            return ((double) maxHeap.peek() + minHeap.peek()) / 2;
        }
    }
}
