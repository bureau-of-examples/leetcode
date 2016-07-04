package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.countnumberswithuniquedigits.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */
public class CountNumbersWithUniqueDigitsTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertThat(solution.countNumbersWithUniqueDigits(0), equalTo(0));
        assertThat(solution.countNumbersWithUniqueDigits(1), equalTo(10));
        assertThat(solution.countNumbersWithUniqueDigits(2), equalTo(91));
        assertThat(solution.countNumbersWithUniqueDigits(3), equalTo(739));
        assertThat(solution.countNumbersWithUniqueDigits(4), equalTo(5275));
        assertThat(solution.countNumbersWithUniqueDigits(10), equalTo(8877691));
    }
}
