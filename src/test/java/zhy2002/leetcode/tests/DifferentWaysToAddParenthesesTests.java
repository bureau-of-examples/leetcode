package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.differentwaystoaddparentheses.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DifferentWaysToAddParenthesesTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        List<Integer> result = solution.diffWaysToCompute("2-1-1");
        result.sort(Comparator.<Integer>naturalOrder());
        assertThat(result, equalTo(Arrays.asList(0,2)));

        result = solution.diffWaysToCompute("2");
        result.sort(Comparator.<Integer>naturalOrder());
        assertThat(result, equalTo(Arrays.asList(2)));

        result = solution.diffWaysToCompute("2*3-4*5");
        result.sort(Comparator.<Integer>naturalOrder());
        assertThat(result, equalTo(Arrays.asList(-34, -14, -10, -10, 10)));

        result = solution.diffWaysToCompute("");
        result.sort(Comparator.<Integer>naturalOrder());
        assertThat(result, equalTo(new ArrayList<>()));

        result = solution.diffWaysToCompute("3*6");
        result.sort(Comparator.<Integer>naturalOrder());
        assertThat(result, equalTo(Arrays.asList(18)));

        result = solution.diffWaysToCompute("3*6-2");
        result.sort(Comparator.<Integer>naturalOrder());
        assertThat(result, equalTo(Arrays.asList(12, 16)));

        result = solution.diffWaysToCompute("3+5*2-6");
        result.sort(Comparator.<Integer>naturalOrder());
        assertThat(result, equalTo(Arrays.asList(-32,-17,7,7,10)));
    }
}
