package zhy2002.leetcode.tests;

import org.junit.Test;

import zhy2002.leetcode.solutions.fractiontorecurringdecimal.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FractionToRecurringDecimailTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();

        assertThat(solution.fractionToDecimal(4,5), equalTo("0.8"));
        assertThat(solution.fractionToDecimal(14,5), equalTo("2.8"));
        assertThat(solution.fractionToDecimal(11,4), equalTo("2.75"));
        assertThat(solution.fractionToDecimal(10,3), equalTo("3.(3)"));
        assertThat(solution.fractionToDecimal(12,7), equalTo("1.(714285)"));
        assertThat(solution.fractionToDecimal(2,3), equalTo("0.(6)"));
        assertThat(solution.fractionToDecimal(2,1), equalTo("2"));
        assertThat(solution.fractionToDecimal(Integer.MAX_VALUE,1), equalTo("2147483647"));
        assertThat(solution.fractionToDecimal(Integer.MAX_VALUE,2), equalTo("1073741823.5"));
        assertThat(solution.fractionToDecimal(Integer.MIN_VALUE,1), equalTo("-2147483648"));
        assertThat(solution.fractionToDecimal(Integer.MIN_VALUE,3), equalTo("-715827882.(6)"));
        assertThat(solution.fractionToDecimal(0,3), equalTo("0"));
        assertThat(solution.fractionToDecimal(-1,3), equalTo("-0.(3)"));
        assertThat(solution.fractionToDecimal(-1,-3), equalTo("0.(3)"));
        assertThat(solution.fractionToDecimal(Integer.MIN_VALUE,-1), equalTo("2147483648"));

    }
}
