package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.shortestworddistanceiii.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ShortestWordDistanceIIITests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        int result = solution.shortestWordDistance(new String[]{"A", "A"}, "A", "A");
        assertThat(result, equalTo(1));

        result = solution.shortestWordDistance(new String[]{"A", "B", "A"}, "A", "A");
        assertThat(result, equalTo(2));

        result = solution.shortestWordDistance(new String[]{"A", "B", "A", "C", "B", "B", "C"}, "C", "A");
        assertThat(result, equalTo(1));

        result = solution.shortestWordDistance(new String[]{"D", "T", "F", "B", "C", "A", "T", "D", "C"}, "T", "T");
        assertThat(result, equalTo(5));

        result = solution.shortestWordDistance(new String[]{"D", "T", "F", "B", "C", "A", "T", "D", "C"}, "T", "C");
        assertThat(result, equalTo(2));

        result = solution.shortestWordDistance(new String[]{"D", "T", "F", "B", "C", "A", "T", "D", "C"}, "A", "F");
        assertThat(result, equalTo(3));

    }
}
