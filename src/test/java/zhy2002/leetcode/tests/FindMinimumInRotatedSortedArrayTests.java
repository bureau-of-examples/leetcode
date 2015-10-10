package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.findminimuminrotatedsortedarray.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class FindMinimumInRotatedSortedArrayTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        assertThat(solution.findMin(new int[]{1}), equalTo(1));
        assertThat(solution.findMin(new int[]{1,2}), equalTo(1));
        assertThat(solution.findMin(new int[]{1,2,3}), equalTo(1));
        assertThat(solution.findMin(new int[]{6,1,2,3,4,5}), equalTo(1));
        assertThat(solution.findMin(new int[]{5,6,1,2,3,4}), equalTo(1));
        assertThat(solution.findMin(new int[]{5,6,7,1,2,3,4}), equalTo(1));
        assertThat(solution.findMin(new int[]{5,6,7,8,9,1}), equalTo(1));
    }
}
