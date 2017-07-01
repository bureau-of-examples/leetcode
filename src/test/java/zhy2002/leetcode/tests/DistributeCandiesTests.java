package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/distribute-candies/#/description
 */
public class DistributeCandiesTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}), equalTo(3));
        assertThat(solution.distributeCandies(new int[]{1, 1, 2, 3}), equalTo(2));
    }

    public class Solution {
        public int distributeCandies(int[] candies) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int cand : candies) {
                Integer count = counts.get(cand);
                if (count == null) {
                    count = 1;
                } else {
                    count++;
                }
                counts.put(cand, count);
            }
            int share = candies.length / 2;
            return Math.min(counts.size(), share);
        }
    }
}
