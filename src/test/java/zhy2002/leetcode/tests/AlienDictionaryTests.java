package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.aliendictionary.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AlienDictionaryTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        String result = solution.alienOrder(new String[]{});
        assertThat(result, equalTo(""));

        result = solution.alienOrder(new String[]{"a", "b", "c"});
        assertThat(result, equalTo("abc"));

        result = solution.alienOrder(new String[]{"ab", "ac", "b"});
        assertThat(result, equalTo("abc"));

        result = solution.alienOrder(new String[]{"ab", "ba"});
        assertThat(result, equalTo("ab"));

        result = solution.alienOrder(new String[]{"ac", "ab", "ba", "bb", "bb"});
        assertThat(result, equalTo("acb"));

        result = solution.alienOrder(new String[]{"c", "ab", "ac", "b"});
        assertThat(result, equalTo(""));

        result = solution.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
        assertThat(result, equalTo("wertf"));

        result = solution.alienOrder(new String[]{"des", "tba", "aac", "dtc", "cbc"});
        assertThat(result, equalTo(""));

        result = solution.alienOrder(new String[]{"ac", "ab", "ae", "bf", "bc", "bg"});
        assertThat(result, equalTo("afcbeg"));

        result = solution.alienOrder(new String[]{"bsusz","rhn","gfbrwec","kuw","qvpxbexnhx","gnp","laxutz","qzxccww"});
        assertThat(result, equalTo(""));
    }
}
