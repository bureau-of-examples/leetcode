package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.findthecelebrity.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FindTheCelebrityTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        solution.loadRelationMatrix(new boolean[][]{{true}});
        int result = solution.findCelebrity(1);
        assertThat(result, equalTo(0));

        solution.loadRelationMatrix(new boolean[][]{{false, true}, {true, false}});
        result = solution.findCelebrity(2);
        assertThat(result, equalTo(-1));

        solution.loadRelationMatrix(new boolean[][]{{false, false}, {true, false}});
        result = solution.findCelebrity(2);
        assertThat(result, equalTo(0));

        solution.loadRelationMatrix(new boolean[][]{
                {false, false, false},
                {false, false, false},
                {false, false, false}
        });
        result = solution.findCelebrity(3);
        assertThat(result, equalTo(-1));

        solution.loadRelationMatrix(new boolean[][]{
                {false, false, true},
                {false, false, true},
                {false, false, false}
        });
        result = solution.findCelebrity(3);
        assertThat(result, equalTo(2));

        solution.loadRelationMatrix(new boolean[][]{
                {false, true, true},
                {false, false, false},
                {false, true, false}
        });
        result = solution.findCelebrity(3);
        assertThat(result, equalTo(1));
    }
}
