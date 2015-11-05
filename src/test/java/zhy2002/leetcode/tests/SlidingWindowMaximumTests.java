package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.slidingwindowmaximum.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SlidingWindowMaximumTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        int[] result = solution.maxSlidingWindow(new int[]{3,2,1}, 1);
        assertThat(result, equalTo(new int[]{3,2,1}));

        result = solution.maxSlidingWindow(new int[]{3,2,1}, 2);
        assertThat(result, equalTo(new int[]{3,2}));

        result = solution.maxSlidingWindow(new int[]{3,2,1}, 3);
        assertThat(result, equalTo(new int[]{3}));

        result = solution.maxSlidingWindow(new int[]{3,2,1,5,7,6,8,3}, 3);
        assertThat(result, equalTo(new int[]{3,5,7,7,8,8}));

        result = solution.maxSlidingWindow(new int[]{1,2,3,4,5,6,7,8}, 4);
        assertThat(result, equalTo(new int[]{4,5,6,7,8}));

        result = solution.maxSlidingWindow(new int[]{8,7,6,5,4,3,2,1}, 3);
        assertThat(result, equalTo(new int[]{8,7,6,5,4,3}));

        result = solution.maxSlidingWindow(new int[]{8,8,7,7,6,6,6,7,8,9}, 3);
        assertThat(result, equalTo(new int[]{8,8,7,7,6,7,8,9}));



    }




    @Test
    public void failedOjTest(){
        Solution solution = new Solution();

        int[] result = solution.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
        assertThat(result, equalTo(new int[]{3,3,2,5}));
    }
}
