package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.findminimuminrotatedsortedarrayii.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class FindMinimumInRotatedSortedArrayIITests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        assertThat(solution.findMin(new int[]{1,2,3,4}), equalTo(1));
        assertThat(solution.findMin(new int[]{5,5,5,5,5,5,5,5,1,2,3,4}), equalTo(1));
        assertThat(solution.findMin(new int[]{5,6,7,1,2,3,4,4,4,4,4,4,4,4,4,4}), equalTo(1));
        assertThat(solution.findMin(new int[]{5,6,7,1,2,3,4,4}), equalTo(1));
        assertThat(solution.findMin(new int[]{5,1,2,3,4}), equalTo(1));
        assertThat(solution.findMin(new int[]{5,1,2,3}), equalTo(1));
    }
}
