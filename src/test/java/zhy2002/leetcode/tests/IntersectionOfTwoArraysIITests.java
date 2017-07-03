package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/#/description
 */
public class IntersectionOfTwoArraysIITests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.intersect(new int[]{1}, new int[]{1,1}), equalTo(new int[]{1}));
    }

    public class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : nums1) {
                Integer count = counts.get(num);
                count = count == null ? 1 : count + 1;
                counts.put(num, count);
            }

            List<Integer> result = new ArrayList<>();
            for (int num : nums2) {
                Integer count = counts.get(num);
                if (count != null) {
                    result.add(num);
                    count--;
                    if (count == 0) {
                        counts.remove(num);
                    } else {
                        counts.put(num, count);
                    }

                }
            }

            int[] array = new int[result.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = result.get(i);
            }
            return array;
        }
    }

}
