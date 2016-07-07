package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.integertoenglishwords.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class IntegerToEnglishWordsTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertThat(solution.numberToWords(0), equalTo("Zero"));
        assertThat(solution.numberToWords(100), equalTo("One Hundred"));
        assertThat(solution.numberToWords(1000), equalTo("One Thousand"));
        assertThat(solution.numberToWords(5), equalTo("Five"));
        assertThat(solution.numberToWords(12), equalTo("Twelve"));
        assertThat(solution.numberToWords(20), equalTo("Twenty"));
        assertThat(solution.numberToWords(27), equalTo("Twenty Seven"));
        assertThat(solution.numberToWords(229), equalTo("Two Hundred Twenty Nine"));
        assertThat(solution.numberToWords(12345), equalTo("Twelve Thousand Three Hundred Forty Five"));
        assertThat(solution.numberToWords(1234567), equalTo("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"));
        assertThat(solution.numberToWords(99700625), equalTo("Ninety Nine Million Seven Hundred Thousand Six Hundred Twenty Five"));
        assertThat(solution.numberToWords(700001000), equalTo("Seven Hundred Million One Thousand"));
    }
}
