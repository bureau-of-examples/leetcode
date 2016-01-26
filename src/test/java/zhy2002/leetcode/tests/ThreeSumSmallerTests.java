package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.threesumsmaller.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ThreeSumSmallerTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        int result = solution.threeSumSmaller(new int[]{-2, 0, 1, 3}, 2);
        assertThat(result, equalTo(2));

        result = solution.threeSumSmaller(new int[]{-2, 0, 1, 3}, 1);
        assertThat(result, equalTo(1));

        result = solution.threeSumSmaller(new int[]{}, 1);
        assertThat(result, equalTo(0));

        result = solution.threeSumSmaller(new int[]{1,2,3,4,5,6}, 4);
        assertThat(result, equalTo(0));

        result = solution.threeSumSmaller(new int[]{1,2,3,4,5,6}, 7);
        assertThat(result, equalTo(1));

        result = solution.threeSumSmaller(new int[]{1,2,3,4,5,6}, 8);
        assertThat(result, equalTo(2));

        result = solution.threeSumSmaller(new int[]{3,1,0,-2}, 4);
        assertThat(result, equalTo(3));
    }
}
