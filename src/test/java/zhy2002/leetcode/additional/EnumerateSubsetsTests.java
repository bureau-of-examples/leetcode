package zhy2002.leetcode.additional;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import zhy2002.leetcode.Utils;
import zhy2002.leetcode.additional.enumeratesubsets.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Playground for recursion techniques.
 */
public class EnumerateSubsetsTests {

    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }
    @Test
    public void basicTest() {
        testcase("[[]]");
        testcase("[[],[1]]", 1);
        testcase("[[],[1],[2],[2,1]]", 1,2);
        testcase("[[],[1],[2],[2,1],[3],[3,1],[3,2],[3,2,1]]", 1,2,3);
        testcase("[[],[1],[2],[2,1],[3],[3,1],[3,2],[3,2,1],[4],[4,1],[4,2],[4,2,1],[4,3],[4,3,1],[4,3,2],[4,3,2,1]]", 1,2,3,4);

    }

    public void testcase(String expected, Integer ...values) {
        List<List<Integer>> result = solution.enumerateSubsets(Arrays.asList(values));
        assertThat(Utils.listOfListToString(result), equalTo(expected));
    }

}
