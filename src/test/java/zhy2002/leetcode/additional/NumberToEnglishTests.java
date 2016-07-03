package zhy2002.leetcode.additional;
import org.junit.Before;
import org.junit.Test;
import zhy2002.leetcode.additional.numbertoenglish.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberToEnglishTests {

    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void basicTest() {
        testcase(1, "ONE");
        testcase(10, "TEN");
        testcase(16, "SIXTEEN");
        testcase(20, "TWENTY");
        testcase(21, "TWENTY ONE");
        testcase(50, "FIFTY");
        testcase(59, "FIFTY NINE");
        testcase(100, "ONE HUNDRED");
        testcase(200, "TWO HUNDRED");
        testcase(201, "TWO HUNDRED AND ONE");
        testcase(235, "TWO HUNDRED AND THIRTY FIVE");
        testcase(1000, "ONE THOUSAND");
        testcase(1001, "ONE THOUSAND AND ONE");
        testcase(1021, "ONE THOUSAND AND TWENTY ONE");
        testcase(1100, "ONE THOUSAND AND ONE HUNDRED");
        testcase(1101, "ONE THOUSAND, ONE HUNDRED AND ONE");
        testcase(99101, "NINETY NINE THOUSAND, ONE HUNDRED AND ONE");
        testcase(199101, "ONE HUNDRED NINETY NINE THOUSAND, ONE HUNDRED AND ONE");
    }

    private void testcase(int number, String expected) {
        String text = solution.numberToEnglish(number);
        assertThat(text, equalTo(expected));
    }
}
