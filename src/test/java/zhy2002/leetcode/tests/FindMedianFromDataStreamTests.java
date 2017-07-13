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
        MedianFinder solution = new MedianFinder();
        solution.addNum(100);
        assertThat(solution.findMedian(), equalTo(100d));
        solution.addNum(120);
        assertThat(solution.findMedian(), equalTo(110d));
        solution.addNum(50);
        assertThat(solution.findMedian(), equalTo(100d));
        solution.addNum(140);
        assertThat(solution.findMedian(), equalTo(110d));
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
