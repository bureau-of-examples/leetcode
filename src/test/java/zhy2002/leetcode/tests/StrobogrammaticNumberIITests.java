package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.strobogrammaticnumberii.Solution;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StrobogrammaticNumberIITests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        List<String> result = solution.findStrobogrammatic(2);
        assertThat(result, equalTo(Arrays.asList("11", "69", "88", "96")));

        result = solution.findStrobogrammatic(3);
        assertThat(result, equalTo(Arrays.asList("101", "609", "808", "906", "111", "619", "818", "916", "181", "689", "888", "986")));

    }

}
