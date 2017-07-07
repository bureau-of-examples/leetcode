package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/arithmetic-slices/#/description
 */
public class ArithmeticSlicesTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}),
                equalTo(3)
        );
    }

    public class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int count = 0;
            int start = 0;
            int end = 1;
            int diff = -1;
            while (end < A.length) {
                int relativeIndex = end - start;
                if (relativeIndex == 1) {
                    diff = A[end++] - A[start];
                } else {
                    if (A[end] - A[end - 1] == diff) {
                        end++;
                    } else { //add count
                        int len = end - start;
                        if (len > 2) {
                            count += (len - 2) * (len - 1) / 2;
                        }
                        start = end - 1;
                    }
                }
            }
            int len = end - start;
            if (len > 2) {
                count += (len - 2) * (len - 1) / 2;
            }
            return count;
        }
    }
}
