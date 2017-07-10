package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/#/description
 */
public class TopKFrequentElementsTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {

        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : nums) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
            queue.addAll(counts.entrySet());

            List<Integer> result = new ArrayList<>();
            for (int i = 0; !queue.isEmpty() && i < k; i++) {
                result.add(queue.poll().getKey());
            }
            return result;
        }
    }
}
