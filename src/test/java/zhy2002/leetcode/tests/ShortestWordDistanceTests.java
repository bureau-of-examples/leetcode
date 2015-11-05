package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.shortestworddistance.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShortestWordDistanceTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        int result = solution.shortestDistance(new String[]{"a", "b", "c", "d"}, "a", "b");
        assertThat(result, equalTo(1));

        result = solution.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice");
        assertThat(result, equalTo(3));

        result = solution.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding");
        assertThat(result, equalTo(1));

        result = solution.shortestDistance(new String[]{"a", "a", "b", "d"}, "a", "b");
        assertThat(result, equalTo(1));

        result = solution.shortestDistance(new String[]{"a", "a", "b", "d", "b","c", "a"}, "a", "b");
        assertThat(result, equalTo(1));

        result = solution.shortestDistance(new String[]{"a", "a", "b", "c", "b","c", "a", "a", "b"}, "a", "c");
        assertThat(result, equalTo(1));


    }
}
