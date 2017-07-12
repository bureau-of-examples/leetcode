package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/array-nesting/#/description
 */
public class ArrayNestingTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.arrayNesting(new int[] {5,4,0,3,1,6,2}), equalTo(4));
    }

    public class Solution {
        public int arrayNesting(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == -1)
                    continue;
                int count = 1;
                int lastIndex = i;
                int last = nums[i];
                while (true) {
                    nums[lastIndex] = -1;
                    int next = nums[last];
                    if (next == -1)
                        break;
                    count++;
                    lastIndex = last;
                    last = next;
                }
                max = Math.max(max, count);
            }
            return max;
        }
    }
}
