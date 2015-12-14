package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.factorcombinations.Solution;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FactorCombinationsTests {

    @Test
    public void basicTests(){

        Solution solution = new Solution();

        List<List<Integer>> result = solution.getFactors(7);
        assertThat(result, hasSize(0));

        result = solution.getFactors(37);
        assertThat(result, hasSize(0));

        result = solution.getFactors(63);
        assertThat(result, hasSize(3));

        result = solution.getFactors(12);
        assertThat(result, hasSize(3));

        result = solution.getFactors(2);
        assertThat(result, hasSize(0));

        result = solution.getFactors(32);
        assertThat(result, hasSize(6));

    }
}
