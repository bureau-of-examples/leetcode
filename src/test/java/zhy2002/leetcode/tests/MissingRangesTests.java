package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.missingranges.Solution;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class MissingRangesTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        List<String> result = solution.findMissingRanges(new int[]{}, 1, 10);
        assertThat(result, equalTo(Arrays.asList("1->10")));
        result = solution.findMissingRanges(new int[]{3}, 1, 10);
        assertThat(result, equalTo(Arrays.asList("1->2","4->10")));
        result = solution.findMissingRanges(new int[]{1,3}, 1, 10);
        assertThat(result, equalTo(Arrays.asList("2", "4->10")));
        result = solution.findMissingRanges(new int[]{1,3, 10}, 1, 10);
        assertThat(result, equalTo(Arrays.asList("2", "4->9")));
        result = solution.findMissingRanges(new int[]{1,3, 6,7,8,9}, 1, 10);
        assertThat(result, equalTo(Arrays.asList("2", "4->5","10")));
        result = solution.findMissingRanges(new int[]{6,8,9}, 0, 9);
        assertThat(result, equalTo(Arrays.asList("0->5", "7")));
        result = solution.findMissingRanges(new int[]{-1000000000,-9999,0,1,2,10,100,1000,999999999,1000000000}, -1000000000, 1000000000);
        assertThat(result, equalTo(Arrays.asList("-999999999->-10000", "-9998->-1", "3->9", "11->99", "101->999", "1001->999999998")));
    }
}
