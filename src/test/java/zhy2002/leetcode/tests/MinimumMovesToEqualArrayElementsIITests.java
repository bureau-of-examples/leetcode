package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/#/description
 */
public class MinimumMovesToEqualArrayElementsIITests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int minMoves2(int[] nums) {
            int count = (nums.length + 1) / 2;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int num : nums) {
                queue.add(num);
            }

            for (int i = 1; i < count; i++) {
                queue.poll();
            }

            int median = queue.poll();
            int sum = 0;
            for(int num : nums) {
                sum += Math.abs(num - median);
            }
            return sum;
        }
    }
}
