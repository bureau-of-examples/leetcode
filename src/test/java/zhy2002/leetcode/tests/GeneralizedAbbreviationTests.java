package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.generalizedabbreviation.Solution;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GeneralizedAbbreviationTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        List<String> result = solution.generateAbbreviations("word");
        assertThat(result, hasSize(16));
        assertThat(result.get(0), equalTo("word"));
        assertThat(result.get(result.size() - 1), equalTo("4"));
        System.out.println(result);

        result = solution.generateAbbreviations("hello");
        assertThat(result, hasSize(32));
        assertThat(result.get(0), equalTo("hello"));
        assertThat(result.get(result.size() - 1), equalTo("5"));

        result = solution.generateAbbreviations("tomcat");
        assertThat(result, hasSize(64));
        assertThat(result.get(0), equalTo("tomcat"));
        assertThat(result.get(result.size() - 1), equalTo("6"));

        result = solution.generateAbbreviations("");
        assertThat(result, hasSize(1));
        assertThat(result.get(0), equalTo(""));
    }
}
