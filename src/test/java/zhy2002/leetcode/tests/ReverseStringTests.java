package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.reversestring.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReverseStringTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        assertThat(solution.reverseString(""), equalTo(""));
        assertThat(solution.reverseString("a"), equalTo("a"));
        assertThat(solution.reverseString("ab"), equalTo("ba"));
        assertThat(solution.reverseString("abc"), equalTo("cba"));
    }
}
