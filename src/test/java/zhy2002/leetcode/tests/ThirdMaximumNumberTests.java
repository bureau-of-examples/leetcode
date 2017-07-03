package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/third-maximum-number/#/description
 */
public class ThirdMaximumNumberTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int thirdMax(int[] nums) {
            Set<Integer> distinct = new HashSet<>();
            for (int num : nums) {
                distinct.add(num);
            }

            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            for (Integer num : distinct) {
                if (minQueue.size() < 3) {
                    minQueue.add(num);
                } else {
                    if (num > minQueue.peek()) {
                        minQueue.poll();
                        minQueue.add(num);
                    }
                }
            }

            if (minQueue.size() == 3) {
                return minQueue.poll();
            }

            while (true) {
                int val = minQueue.poll();
                if (minQueue.isEmpty())
                    return val;
            }
        }
    }

}
