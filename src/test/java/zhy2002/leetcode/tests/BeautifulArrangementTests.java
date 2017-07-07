package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/beautiful-arrangement/#/description
 */
public class BeautifulArrangementTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.countArrangement(2), equalTo(2));
    }

    public class Solution {
        private int sum;

        public int countArrangement(int N) {
            Set<Integer> used = new HashSet<>();
            sum = 0;
            find(used, 0, N);
            return sum;
        }

        private void find(Set<Integer> used, int start, int n) {
            if (start == n) {
                sum++;
                return;
            }

            for (int i = 1; i <= n; i++) {
                if (used.contains(i))
                    continue;
                if (i % (start + 1) == 0 || (start + 1) % i == 0) {
                    used.add(i);
                    find(used, start + 1, n);
                    used.remove(i);
                }
            }
        }
    }
}
