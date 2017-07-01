package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class ShortestUnsortedContinuousSubarrayTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(
                solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}),
                equalTo(5)
        );

        assertThat(
                solution.findUnsortedSubarray(new int[]{0, 4, 3, 2, 1, 0}),
                equalTo(5)
        );
    }

    public class Solution {
        public int findUnsortedSubarray(int[] nums) {
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            for (int num : nums) {
                minQueue.add(num);
            }
            int minIndex = 0;
            while (minIndex < nums.length && nums[minIndex] == minQueue.peek()) {
                minIndex++;
                minQueue.poll();
            }
            if (minIndex == nums.length)
                return 0;

            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : nums) {
                maxQueue.add(num);
            }
            int maxIndex = nums.length - 1;
            while (maxIndex >= 0 && nums[maxIndex] == maxQueue.peek()) {
                maxIndex--;
                maxQueue.poll();
            }

            return maxIndex - minIndex + 1;
        }
    }

}
