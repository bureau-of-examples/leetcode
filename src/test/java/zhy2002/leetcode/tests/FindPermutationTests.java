package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/find-permutation/#/description
 */
public class FindPermutationTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        //assertThat(solution.findPermutation("DDDIIIIIDDIDIIDDDDIIDDDDIDDIIDDIIDIDDDDDDIDIDDIDIDDDIIIIIIIDIIDIDDDIIDIDDDDIDIDDDIDDDDDIDIIDDIIIIDIIDDDIDIDDIIDDDDDIIDIIIDIIDIDIIIIDIIDDDIDDIDIDIIIDDIIIDDIDDIDIDIDIIIIIIIIIDIIIIDDDDDIDDDIDDIIIDDDIIDDIIDIIIDDDDDDDDIIDIDDDDIDIDDIDIDIIIIDDDDDDIDDIDIIIDDIIIDDDDDDIDDDIDDIIDDDDIIIDIIIIIIIDIDIDIDDDDDDDDIDIDIIIIIIDIIDDDIIIDDIIDDDDIIDDDIDDDIIIIIDDIIDIDIIIDDDIDIIIDDDDDIDDDDDDDDDDIDIDIIIIDDDIIDIDIIDIDIIIIDIIDIDDIDDIIDIDDIIDIDIIIIIDIIIDIDDDDIIIDDIDIDIDIIIDDDIIIDDDIIDIDDIIDDDDIDDDIIDIDDIDDIDDDDIIIIIIIIIDIDIDDIDDIDDDIIIDDIDDIDDDDDIIIDIDDDDIIIDDIIDDDIDDDDIIDIDDIIIIDIIDIIDIIIIDDDIIDIIDIDIIIIDDIDDIIIDDDIDIIDDDDDDDDIDDDDIDIDIDIIDIIDDIDIDDDDIIDIIDDDDIDDDDDIIDIDDDDDIDDIIIDIIDIDDIDDDIDDIIIDDIDDDIIDDIDIIDDIDDIIDIIIIDDIDIDDDIIDIIDDDDDDIIDDDIIDDDIDIDIDDIDIIDIIIIIDDDDIDIDDDIIIIDDDIIDIDDIIDIDIIIIIIIIDDDDDDDDIIDDDDIDDDIIDIIDDDIDDIIDIIIIIIIIIDDIDDIIDIDDDDDDDIIDIIIDIIIIIDDIIIDIDDDIDIIIIDDIIDIDIDIIDDDDIDDDIDDDIDDIIDDIIIDIDIDIIIDDIDIDDIIIIIDIDIDIDIIIIIIDIDIDDIDIIDIIDDDDIDDDDIIIIDIIDDIDIDDIDIDDDDDIIDDIIIIDDDIIDIDIDDIDDIIIDIIIIIDDDIIDDDIDIIDIIIIDDIDIIDIIIIIIIIDDDDDIDDIIIIDIIDIDDDIIDDDIDDIDIIIIIIDDIIDDIDIIIDIIDIIDIDDDIIIDDDIDIIIIIDIDIDDIDDDIDIDIDDDDDDIIIIDDIIDIIIIDIIIDIIDIDIDIIIIIIDIIDIDDIDDDIDDDDDIIIIIIDDIDDIIDDIDDIIDIDDDDIIDIDIDDIDIDDDDDDIDDIDDIIDIIDDIDIDIIIIDIDIDDDDIIIDDIIDIIIDDDIIIDIDIIDDIIIDDIDIDIIDDIIIDDDDIDIDDDDIIIDDDIIIIIIDDDDDDDDIIDDIDIDIDIDIDIIDDIIDIIDDDIIIIDIDIDDIIIIIDDIIDDIIDIDDIDDDDDIIIIDIDDIIDIIDIIIIDIDDIIIDDDIDIDIIIIDDDIDIDDDIDIDDIDDIDDDIIIDDIIDDDDDIDIDIIDIIDIIDDIDIDIIIIDIDIIIDDDDDIIDDDDIDIDDIIIDDIDIIDIDIIIDDDIDIIDDIIDDIDIDDDDIIDDIIIDDIIDDDIIDIDIDIDDIIIIDDIDIDIDIIDDDIDIDDIIDIIIDDDDIDDIDDDIIDIDDDDIIIIIDDDIIIDIDDIIDIDDDIDDDIDDIDIIDDDIDDIIIDDIDIIDIDIIIIIIIDDDDIIIDDDIIDIDDDDIDDDDDDDDIIIDDIIDIIDDDDDDIDIIIIDDDDDDDIIIIDDDIDDDIDIIIDIIIDDIIDDDDDIIIDDIDDDDDIDIDDDDIIIDIIDDDDDDDIIDIIDDIDIIIDDDIIIIDIIIIDIIIDDIIIIIDIIIDDIDDDDDDDDIIDIDIIIIDDIDIIIIIIDDIDDDIDIIDDIIIIIDDDDDDIIDDIDIIIIDDDDDIIIDDDDIIIIIDIIDIDIIIDDDIIIDIDIDIIIDIIIDDIIDDDIIIIDIIDIDDDIDDDDDDIIDDDDDDDDIIDDIDIDDIIIDIIDDIDIDDIDIIIDDDDDIIIDDDIIDDDIDIIIIIIDIIDDIIDDIIDIDDDDDIDDIIDIDIDIDIDDDIIDIIIDDIIIDDDIIDDIIDDDDDIDDDIIIDIIDDDDIIIDIDIDDDIDDDIIIIDDDDDIIDIIDIDDDIDDIDIDDIIDIIDDIIDDDIDIDIIIIIDIIDIDDDIDIIIDIIDIDIDIDDIIDDDDIDIIIDDIDIDIIDDDIIIIIDDDIDIIIDDDDIIIDDDIIIDDIDDDIIDIDDIIIIDIIIDIIDIIIIDIIIDIIDIIIIIDDDIDIIIIIDDIDIDIDIDDDDDDIDIDDDDDDIIDIDDDIDIIDIDDIDDIIDDDDDDIDIIIIIIDDDDDIDIIDDDDDIDDDIDIDDDIDIIIIIDDIDIIIDDIIDDIDIDDDIIDIDDIDDDDIIDDDIIDIIIDDIIIIDDIIDIDIDDDIIDIIDIIIDDIIDDIIIDDDDIDIDIIDIIDDDIIIDDDDDDIIDDIIIIDDIDDIIDDDDDDDDDDDIDIDDDIIDDIIDIIIDIIIIIIIIDDDDDDIDDDDIIDIDIDIIDIDDIIDDIIIDDDDIDDIDDDDIDDIIDDDIDIDIIDDDDIDDDDDDDIDIDDDDIIIDIIIIDDIIIIIDIDDDDDIIDIDDDDDDDIIIIDDDIIDIIDIDDDDDIDDDDDDDIIDDDDDIDIIIIIDDIDIDIIDIDIDIDDIIIIIIDIDIIIDIDIDDIIIDDDIDDIDDDDIDIIDDDIIDIDDDDIIDIIDIDDDDIDDIDIDDIIIIDDIIIIDIIIDDIDDIIDDDDIIDIDDIDDDDDDIIIIIIDIIDDDDDIIIIDIIIDIDIIIIIDDDIIDIDDIDDIIDIIDDIDDIDDDIDIDIIIIIDDDIDDIDIDDDIIDIDDIDIDIIIDDIDIDIIDDIIDDIDIDDDIIIIDIDDDDIIIIDIDIIDDIIIDIDDIIDIIDDDDDIDIIDDDDDDIDIDDIDIDIDDDDIDIDDIIDDIDDDIIIDIIDIDDDIDIIDIIDDDIIDDIIIIIDDIIDDDIDDDDDIDIIDDIDIIDIIIIDIIIDDIIDDIIIDDIIIIIDDIDIDIIIDIDDIIIDIIIDDIIIDDDDIIDDIDDDIDIIDIDIDDIDDIDDIDIDIDDDIDIDIIDDDDDIDDIIIDDIIIIIIDDDDDDIDDIDIIIIDDIIDDIDDIIIDIIIIIIDIDDDDDIIDIDIIIDDDDIIIDIDDDDDDIDDIIDIDDIIDDIDDDDIIDDDIIDIIDIDDDIDIDIDDIDIIDDDIDIDDIDDIIIIIDIIDIIDIIDDIDDIIDIDDDIDIDIDDIDIDIIDIIIDIIIDDIDIDIIDIIIDDDDIIIIIIIDDDDIIIDIIIIDDIIIDIIDDDDIIIIIIDDDDIIIDIIDDDDIIIDIIDDDIIDDDDDDIIIDDDDDIDIIIIIIIIIIIDIIDIIIDDDDDIDIIIIDIIIIIDDDIIIDIIIIDDIDDIIDIDDIIDIIIIIDDDDDDIIIDIDIIIDIIDIDDIDDIDDDIIDIIDIIIDDIDDIIIIIIDIIIIDDDDDDDDDDDDDIDIIDIDIIDDDIDIIIDDDDDDIDIDDDDIDIIIIIDDDDIIIDIDIIDDDIIIIDDIDIDDIDDIIIDDDIDDDDDDIIDDIIDIIIIDDIDDIDIIDIDDDDDDIDDIDDIDDDIDIIIIIDDIIIDIDDDDDDIDDDIIDDIDIDDDIDDDIIIIIDIIIIDIDDDIDDDDDDIIDIDIDDDDIDDIIDIDIIDDDIIIDDDIDIIIIIIIDIDIIDIDDIIDIIDIIIDIDDIDIDIIIDDDDDDIIDDIDIDDDDDDDDIIIIIDDDDDIDDDDIDDDDDDIDDDDDIIIDDDIIIDIDDIIIIIDIDIDIDDDDIIDDDIIDIDIDIIIIIDDDDDIIDDIDDIDDIIDDIIDIIDIDIIDDIIIIIIDDDIIDIIDIIIIIDDIIDDDDDDIIIIIIDDDIDDDDDIIDDIIIDDDDIDDDDIIDDIDDIIIIIDIIIIIIDDIDDIDDIDIIDDIIDIDIDIDIIDIIDIDIDIIIIDIIIDIDDIIIIIDIDDDDDDIIDDIIDDDDIIIDIDIIDDDDDIIDIDDIDDIIDDIIDDDIIIIDIDIDDIDIDIIDDIIDIDIIDDDDDDDDIIDIIDDDIDIDIDDIDIDDDIDDDIDIIDDIIIDIDIIIIDIDDDIIDIIDDDDDIIIDDDDDDIIIDIIDIDDIIIDDDDDDDIIDDDDIDDIDDIDIDDIDDIIDDIIIIIDIIIDDIIIDIDIIIIIDIDDDIIIDDIIDIDIDIDDIDDDIDIDDDDDIIDDIDDDIIIIIDDDIIDIIDDIIIIDIDDIDDIDDIDDDDDIIIDIIDDIDIDIDIIDIDDDIDDIIIIDDIIDIIDDDDDDIDIDIDDIIDDIIDDIDIIIIDDIDIDDDDDDDDDDDIDIDDDDIDIDDDIIIDIDIIIIDDIIIDIDDIDDDIDIIIIDDIIDDIIDIIIIDIDIIIIIIDDIDIDDIDIDDIDIDIDDIIDIIDDIDDIIDDDIDDDDDDIDDDIIIDIIIDDDDDIIIDIIDDIIIIIIIIDDDIDIDDDDDDDDDDDIIDDDIIDDIDDDDIDIIDIIIDIDDDIIIIIIIIIIDIIIIIDDIDDDIIIDIDIIIDIIDDDDIIIIDIDIIDIIIDIIIDDDDDDDDDDDIDIIDDIDDDDDIDIIDDIDDDIDIIDIIDDIDDDIDIIDIDDDDIDDIDDDIDDIIIDDIIIIIDDIDIIDIIDIIDIDIIIIIIIDDIIDIIIIDIDDIDIIIDDDDIIIIDIIDDDIIIIIIIDIDIDIIDIDIDIIDDIIDIDDIDIDDIDDDIDIIIDDIDDDIDDDIIIIDIDDDDDIIDIIIDIDDDDIDDDDIDIIDIIDIDDIIIIDDDDDIIIIDDDDIIDDIDDDIIDDDDDDDDIDDDIDIIDDDDIIIIDDIDDIIIIIIDDIDIIIDDDDDDIIIDDIIDDDDIIDDDIDDIDDIDDIIIDIDIDDDIIDDDIIIIIIIIIDIDIDDIIDIDIIIIDIIDDIDIDDDDDIDDDIIDDDDIIIDDDIDIIDIIIDIIIDIIDDDDDIDDDIIIDDDDIDIDIDDDDIIIDDIDDIIDDDIDDDIDIDIIIDIIDIDDDDIDDDIIDDIDDDIIDIIDDDIIIDDIDIIIDIDIIDIDDDDDDIDDDIDDIIDIIIDIDDDIDIIDDDIIDIIDDDIDIDDIIIIIIIDDIIDIIDIIDIDIDIDIIIIIIDIDDIDDDDIDIIIDIDDIDIDIDIIDIIIIDIDDIDIDIDIDDIDDIDDDIIIDDIIDIIIIDDDIIDIDDDIDDIIIDIDDIDDDDIIIIDIIIDIDDIIDDIIDDDDDIIIIDDDDDDIIDIDDIIIIIDDIDDIIIIIDDIIDIIIIDIIDIDIDIIIIIIIDDIIDIIDIIDIIIDDIDIIDDDIIIDIIIDDDDDIIIIDDDIDDDIIIDDDDDIIIIIIDIDIIDDDIIIIIIDIIDDDDIDDDIIIIDIIIDDDDDIDDDDDDDDIDIDDIDDIDIDDDDDDIIDIDDDDIDDIIIDDDDIDIDDIIIDDDIIIDDDIDDIIDDIIIDDDDIDDDDDDIIDIIIIIDDIDIDIIDDDIIIIIIIDDIDDDIIIIDIIIDDIIIIIIDDDDIDDIIDDIDIIIDDIIDDIIIIDDIIIIDIDDIIIIDDDDIDIDIDDDDDDDDDDDDDIIDIIIDDDIDIIIIIIDDIDDDIIIIIDIIIIDDDDIDIIDDDDIDDIDIDIDDIIIDDIDIIIDDDIIIIDIIDDIDIDIIIDDIIIIDDDIDIIIIDIIDDIDDDDDDDDIIDDIDDIDDDDIIIDIDDIIIDDDDDIIIDIDDIDIIDIDIIIDDIDIDDDIIIIIIDIIIDIIDIIIDDDIIIDIIIIDDDIIIIDDIIIDDIIDDDIDIIIIDIDDDIDIDDDIDDDDIIDIIDIIDIDIIDIIIIIIIIDIIIIIIIIIDDIIIDDIDDDDDDDDIIIDDDIIDDDDIIIDDDDDIDIIDIIDIIIDDDIDDDIIDIDDIIIIIDIDDDDDDIIIDDDIIIDDDDIIIDDDDDDIDDIIIDIDIDDIIIIIDIIDDDIDDIIDDDIDIIIIDDIIIDIIIDDIDIDDDDIDDDDIDDDDIDIIIIIIIDIDDIDIDIIDDIIDDIIDIIIIDDIIDIDDDDIIDDIDDIIIIDIDDIIDIIIIDDDIDDIIIIIDIDDDIDDIDDIIIDDIIIIDDIIDDDDDIIDIIDIDDIDIIDDDIDDIDDDIIDDIDIIDDDDDDIIDDIIIDIIDDIDIDIDDIDDDDDDIIDIDIIIDIDIDDDDIDIDIDDDDIIIDIIDIIIDIIDIDIDIIIDIIIDDDDIDIDIDDDIDIIDIDIIIDIIDIDIIDDIDIDDDDDDIIIIIDIIDDIDDIDDIIIDDIDDIIIDDIDIDDIDIDIDDDIIIIIIDDDIDDIDIIDIIDDIDIDIIIDIIDDDIDIDIDDDIIDDIIDIIDIIIIIIDDIDDDIIDIIDIDDIDDIIIDDIIIDDIIDIIDIDIDIIDDIIDIIIIIIIDDDDDIIIDDDDIIDDIDDIDDDDDDIIIIDIDIDDDDDIIDIIDIIDDDDDDDIIIIIIDIDDDDIDIIIIIDIDDIDDIIIDIDIDDIDDIDDIDDDIIIIIDDDDDDDDDDIDIIIIDIIDDIIIDIDDIDDIDDIIDIDIIIDDIIDIDIDDIIDDIIDDIDDDIDDDIIDDIIIIDIIIIDDIDDIIDDIIIDIDDIDIIDDIDDDIDDIDDIDDDDDIDIIDIIDIDDDDDDDIIIIDIDDDDDDIIDIDIIDIDDDIIDIDDIIIDIDDDDIIIDDDIDIDDIIIIIDDDIDDDIIIIIIIIIIIIDDDIIIDDIDIIDDDIIDDIIDIDDIIDIDDIIDDIDDDIIIDIIIIIIDDIDIIDIDDDIIDDIDDDDIDIIIIDDDIIDIDIDDDDDIDDIDDDIDDDIIDDIIDIIDIDIIDDDIIIDDDIIDDDIIDDDIDIIIIIIDDIDIIIIDDDIDDIDIDIDDDIDIIIIDDIDDDIIDIDDDDIIIIDIIDDDDIIDDIIDIIDDDIIDDDDDDIIIIDIDIDIDDIIDIIDDDDDIDDDIDDDDDDDIDDDDIIIDDIDIDIIDDIIIDDIIIDDIIDDIDIIIIDDDDIDIDDDDDDIIIDIIDDIIIIIIDIIIDIDIIDDIIDIDIDDDDDIDDIIDIDDDDDDDIIDDDDIDIIIDDDDIIDDDDIIDIDDDIIDDIDIIDIDIDDIIIIDDIIDDDIDDIIDDIDIDIIDIDDIDDIDDIIDDIIIIDIDIDIDIDDDIDDDDDDIIDIIDIIDIDIIIIIDIIIDIDIDDDIDDIIDDIIIDIDIIDDIDIDDDDDDDDDIDDIIIDDIDIDIIDDIIDDIIIIDDIIDIIIIIIIIDIDDIDIIIIDIIDDIDIIDIDIDDDIDIDIIIIDIIIDDDIIIIIDIIIDDDDDDDDIIDDIDIIDIIDIDDIIIIIDDIIDDDIDIIIIIIIIIDIIIDIDIDIIIIDDDIIDDDIDIDIDDIDDIIIIIDIIIIDIIIIIIDDIDDDDDDDIIIIDIDIIIIDDDDIDIDIDIIIIIDIIDDIIDIIDDIIDDIDIDIDDIIIIDDIDDDIIIIIIIIIIDIIIDDIDDIIIIIDIIIDDIIIDIIIDIDDIDIIDIIDIIDDIDDDDDIDDDDIIIDDDDDDDDIIDDDDDIIDDDIDIDDIIDDIIDIDIIIIDDDDIIDDDDIDIDIIIIIIDIIDDIDIIIDDIDIDDDDDIDIIIIDIDIIIDIIIDDIDIIDIIIIDDDDDDDDDIDIDDIIIDIIIDDDIIDDIDIIDDDDIDIIIDIDIIIDIDIIIDIDDDIIIDIIIDIIDIDIDIIIIDIDIIDIIIIIIDIDIIIIDIIDIDDIDIIIDIDIIDIDIIDIIDIDIIIIDDDIIIIIDDIDDIDDIIIIDDIIIDDDIDIIDIDIDIDDDDDDIDIIDDIIDIIIDDDDIIIIDDDIIIIIDDDIIIIIDIIIDIDIDDDDDDIIIIIDDIDIIDDDDDDIDDIDIDDDDIDIIDIDIIIIDDIDDDIIDDDDIDIIIDDDIDDDIIIDDDIDIIDDIIIIIDDIDDIIIDIIDDDIIIIDDDDIIIDIDIDIIDDDIDIDIIIIIIIDDIDIIDDDDIDIDDIDDDDIIIIIDIDDIDIDIDDIDIDDDIDDDIIIDIDDIIIDDDDDDDDDDDDIIDDDDIIIIDDDDDIIIDDIDIDDIDIIIIIDIDDDDDIDDIIDIDIDDDDIDDDDIDIDIDDDIDIDIDIIIIDIIDIIIDDIDDDIIDIIDIDIIDDIIDIDDIDDDIDIIDIDIIIIIDDDIIDDIDDIDDIDDDDDDDDIIDDDDDDDIIDIDDDIIIDIIIIDDDIDIIDIIIDDIIDDDDIIIIIDDDDIDIIIDDDIIDDDIIDDDIIDIDDIDDIDIIDIIDDDDDIDDDIIDIIDDIIDIDDIIDIIDIDIIIDDDDIIIIDIIDIDDDDDDDIDDIIIDDDIIIDIIDDIDDDIIDDDIDIDDDDIDDIIIIIDDIIIDDDDIDDIIDIIDDIIDIIDDIDIDDDDIDDDDDDIIDDIDIIDIIDDIDIDDDDIDIIDDDDIDIIIDDIIIIDIIIDIIDIIDDDIDDIIIDDDDDDIDIIIIIDDIIDDDIDIDIIDDDDIDDIIDDDIIIIDIDIIIIIIDDDIIIIDDIDIIDIDIDDIIDIIIDIDDIIIDDIIIDDDIIDIDIIDIIIIIIDDDDIDIDDDIDDDDDDDDDIIDDIDDIIIIDIIDIDDDIDIDIIIIDIIIIIIDDDIDDIIDIIIDIIDDDDDDIIDDDDIIDDDIIDDDDIDIDDIIIIIDIIIIDIIIDIIIIIIIDDDDDIDIIDIDDIIDDDDIIIDIIDIIDIIIIIIDDDIDDIIDIDDDDDDDIDDIIDIIIDIDDIIDDDDDIIIIIIDIIIDDIDDDDIIDDIIIDIDDIDDDIDDDIIDDIIDIIIIDIDDIDIIDIDIDDIIDDIDIDDDDDIIDDDIIDIDIIIIDIDIDIIDIDDDDDIIIDDDIDIIIIIIIIIDIDDDIDIIDIIIIDIDIDIDDIDDDDDDDDIDDIDDDIIIDIIIDDIDIDIIDIDDDIIIIIDDDIIDDIIIDDDDDIDDDDDIIIDDDIIDIIIDIDDDIIDDIIIIDIIDIDDIIIIDIDDDDDDIDIIDIDIDIDIDIDIDIDIIIDDIDIDIIDIIDDDIIDDIIDIIIDIIIDIIIIDIDDDDDIDIDIDIIDDDDDIIDDIDIDDIDDIIDIDIIIIDDDIDIIDIDDDDDDDIDDDIDIIIDDIIDIIDIDIIIIIDDIIIIIIDIIIIIDDDDDIIDDDIDDDIIDIIIDIIIDIDDIIIDIDIIIIDIDDDIDIDIIDIDIDIIIIDDDDIDDIDDIIDIIDIDIDIDIIDIIIIIDDDDIDIDDDDDIIIIDDIIIDIDIIIIIIDDDIIIDIIDIDIIIDIDIDIDDDDIDIIDIIDIIIIDIDIIIDIIIDIIDIIDIDIIDDDDIDDIDIIIDDDDIDIIDIIIIDIDIDIIDDIIDIIIIDIDIIIIIDDDDDIDDIDIDIDDIDIDDDDIIDDIDDDDIDDIDIDDIDDIIDIDDIIDIIIDDDIDIDIDDDDDIIDDDDIIDIIDIDDIIDIIIIIDIIIDDDDIIDDDIDDDDIIDIIDIIDIDDDDDDIIDDIIIDIIIIDIDDDDDDDIIIIIDDDDDDDDIIIIIIDIIDDDIDIIIDIDIIIDDIIIDDIIDIIDDIDDDDDIDDIIIDIDDIIDIDDDIDDDDIIIIIDIDDDIIIIIDDDDDDIDDIDDIDDIIIIIIIDIDDDDDIDDIDIDIIIIDDIDIDIIDDIDIDDIIDDIDIIIDDIIDDIDIIIDDDIIIDIIIDDIIIDDIIIDIIIIDIIIDIIIDIIDDIDIIIDIIDDDDIIIDIIDDIIDDIDDDIDIIDDIIDDDIDDDIIIIIIIDDDIIDDIIDDIIIDIDDIIDDDIDIDIDIDDDDDDDIIIDIIDIDDDDIIDDIDDDDDIDDDIDIDIIIIIIDIDDDIDIIIIDIIDIIDIDDDIIDDDIDDDDIDIDDIDDDD"), equalTo(new int[]{1, 2, 6, 5, 4, 3}));
        assertThat(solution.findPermutation("IIDDD"), equalTo(new int[]{1, 2, 6, 5, 4, 3}));
        assertThat(solution.findPermutation("DDD"), equalTo(new int[]{4, 3, 2, 1}));
        assertThat(solution.findPermutation("III"), equalTo(new int[]{1, 2, 3, 4}));
        assertThat(solution.findPermutation("ID"), equalTo(new int[]{1, 3, 2}));
        assertThat(solution.findPermutation("DI"), equalTo(new int[]{2, 1, 3}));
        assertThat(solution.findPermutation("D"), equalTo(new int[]{2, 1}));
        assertThat(solution.findPermutation("I"), equalTo(new int[]{1, 2}));
    }

    public class Solution {
        public int[] findPermutation(String s) {
            Deque<Integer> deque = new ArrayDeque<>();
            populate(deque, s, s.length());
            return toIntArray(deque);
        }

        private void populate(Deque<Integer> deque, String s, int remainingCount) {
            while (remainingCount > 0) {
                int n = remainingCount + 1;
                int count = 1;
                for (int i = remainingCount - 2; i >= 0; i--) {
                    if (s.charAt(i) == s.charAt(i + 1)) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (s.charAt(remainingCount - 1) == 'D') {
                    if (!deque.isEmpty()) {
                        deque.pollFirst();
                    }
                    for (int i = count; i >= 0; i--) {
                        deque.addFirst(n - i);
                    }
                } else {
                    assert s.charAt(remainingCount - 1) == 'I';
                    for (int i = deque.isEmpty() ? 0 : 1; i <= count; i++) {
                        deque.addFirst(n - i);
                    }
                }
                remainingCount -= count;
            }
        }

        private int[] toIntArray(Deque<Integer> deque) {
            int[] result = new int[deque.size()];
            int index = 0;
            while (!deque.isEmpty()) {
                result[index++] = deque.poll();
            }
            return result;
        }
    }

}
