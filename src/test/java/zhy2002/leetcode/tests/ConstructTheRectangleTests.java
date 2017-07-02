package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/construct-the-rectangle/#/description
 */
public class ConstructTheRectangleTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.constructRectangle(120), equalTo(new int[]{12,10}));
        assertThat(solution.constructRectangle(100), equalTo(new int[]{10,10}));
    }

    public class Solution {
        public int[] constructRectangle(int area) {
            int width = (int)Math.sqrt(area);
            while (area % width != 0)
                width--;
            return new int[]{area / width, width};
        }
    }
}
