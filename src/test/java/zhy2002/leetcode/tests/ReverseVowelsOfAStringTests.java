package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.solutions.reversevowelsofastring.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ReverseVowelsOfAStringTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertThat(solution.reverseVowels(""), equalTo(""));
        assertThat(solution.reverseVowels("ab"), equalTo("ab"));
        assertThat(solution.reverseVowels("hello"), equalTo("holle"));
        assertThat(solution.reverseVowels("leetcode"), equalTo("leotcede"));
        assertThat(solution.reverseVowels("the night is long"), equalTo("tho night is leng"));
    }
}
