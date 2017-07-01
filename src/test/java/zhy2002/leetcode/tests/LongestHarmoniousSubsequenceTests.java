package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/#/description
 */
public class LongestHarmoniousSubsequenceTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        assertThat(
                solution.findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}),
                equalTo(5)
        );
        assertThat(
                solution.findLHS(new int[]{1, 1, 1, 1}),
                equalTo(0)
        );

    }

    public class Solution {
        public int findLHS(int[] nums) {
            Map<Pair, Integer> counts = new HashMap<>();
            Set<Integer> all = new HashSet<>();
            for (int num : nums) {
                all.add(num);
                Pair up = new Pair(num, num + 1);
                Integer upCount = counts.get(up);
                if (upCount == null) {
                    upCount = 1;
                } else {
                    upCount += 1;
                }
                counts.put(up, upCount);

                Pair down = new Pair(num - 1, num);
                Integer downCount = counts.get(down);
                if (downCount == null) {
                    downCount = 1;
                } else {
                    downCount += 1;
                }
                counts.put(down, downCount);
            }

            return counts.entrySet().stream()
                    .filter(entry -> all.contains(entry.getKey().left) && all.contains(entry.getKey().right))
                    .mapToInt(Map.Entry::getValue)
                    .max().orElse(0);

        }
    }

    class Pair {
        int left;
        int right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (left != pair.left) return false;
            return right == pair.right;
        }

        @Override
        public int hashCode() {
            int result = left;
            result = 31 * result + right;
            return result;
        }
    }

}
