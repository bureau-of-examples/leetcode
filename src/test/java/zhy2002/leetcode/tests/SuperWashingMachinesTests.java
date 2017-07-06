package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/super-washing-machines/#/description
 */
public class SuperWashingMachinesTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.findMinMoves(new int[]{0, 0, 4, 0, 5, 0, 5, 0, 4}),
                equalTo(4)
        );
        assertThat(
                solution.findMinMoves(new int[]{0, 0, 11, 5}),
                equalTo(8)
        );
        assertThat(
                solution.findMinMoves(new int[]{4, 0, 0, 4}),
                equalTo(2)
        );
        assertThat(
                solution.findMinMoves(new int[]{0, 3, 0}),
                equalTo(2)
        );
        assertThat(
                solution.findMinMoves(new int[]{8, 7, 17, 6, 12}),
                equalTo(7)
        );

    }

    public class Solution {

        public int findMinMoves(int[] machines) {
            //check valid
            long totalDresses = 0;
            for (int machine1 : machines) {
                totalDresses += machine1;
            }
            if (totalDresses % machines.length != 0)
                return -1;

            //calc delta
            int averageDresses = (int) (totalDresses / machines.length);

            int max = 0;
            int left = 0;//dresses moved to left from this machine
            int right;//dresses moved to right from this machine
            for (int i = 0; i < machines.length; i++) {
                int delta = machines[i] - averageDresses;
                right = delta - left;//delta - right - left = 0
                if (left > 0 && right > 0) {//flow outwards
                    max = Math.max(max, left + right);
                } else {//flow to left, flow to right or flow inwards
                    max = Math.max(max, Math.max(Math.abs(left), Math.abs(right)));
                }
                left = -right;
            }
            return max;
        }
    }

}
