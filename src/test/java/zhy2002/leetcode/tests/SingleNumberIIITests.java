package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.singlenumberiii.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SingleNumberIIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();
        int[] result = solution.singleNumber(new int[]{1,1,2,2,3,4});
        assertThat(result, equalTo(new int[]{3,4}));

        result = solution.singleNumber(new int[]{3, 7,1,1,2,2,3,4});
        assertThat(result, equalTo(new int[]{4,7}));

        result = solution.singleNumber(new int[]{1,5});
        assertThat(result, equalTo(new int[]{1,5}));
    }
}
