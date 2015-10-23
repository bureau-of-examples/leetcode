package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.majorityelementii.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MajorityElementIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        List<Integer> result = solution.majorityElement(new int[]{});
        result.sort(Comparator.naturalOrder());
        assertThat(result, equalTo(new ArrayList<>()));

        result = solution.majorityElement(new int[]{1});
        result.sort(Comparator.naturalOrder());
        assertThat(result, equalTo(Arrays.asList(1)));

        result = solution.majorityElement(new int[]{1,2,3});
        result.sort(Comparator.naturalOrder());
        assertThat(result, equalTo(new ArrayList<>()));

        result = solution.majorityElement(new int[]{1,2,1,3,3,2});
        result.sort(Comparator.naturalOrder());
        assertThat(result, equalTo(new ArrayList<>()));

        result = solution.majorityElement(new int[]{1,1,2,2});
        result.sort(Comparator.naturalOrder());
        assertThat(result, equalTo(Arrays.asList(1,2)));

        result = solution.majorityElement(new int[]{1,2,2});
        result.sort(Comparator.naturalOrder());
        assertThat(result, equalTo(Arrays.asList(2)));

        result = solution.majorityElement(new int[]{1,2,2,1,3});
        result.sort(Comparator.naturalOrder());
        assertThat(result, equalTo(Arrays.asList(1,2)));

        result = solution.majorityElement(new int[]{1,2,2,1,3,0,1});
        result.sort(Comparator.naturalOrder());
        assertThat(result, equalTo(Arrays.asList(1)));

        result = solution.majorityElement(new int[]{1,2,2,1,3,0,1,3,3,3,3,3});
        result.sort(Comparator.naturalOrder());
        assertThat(result, equalTo(Arrays.asList(3)));

        result = solution.majorityElement(new int[]{-1,1,1,1,2,1});
        result.sort(Comparator.naturalOrder());
        assertThat(result, equalTo(Arrays.asList(1)));
    }

}
