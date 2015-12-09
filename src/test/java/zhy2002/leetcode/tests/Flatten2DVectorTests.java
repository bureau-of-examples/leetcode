package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.flatten2dvector.Vector2D;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Flatten2DVectorTests {

    @Test
    public void basicTest() {

        Integer[][] input = {{1, 2}, {3}, {4, 5, 6}};

        Vector2D vector2D = new Vector2D(Utils.arrayOfArrayToListOfList(input));
        for (int i = 0; i < 6; i++) {

            assertThat(vector2D.hasNext(), equalTo(true));
            assertThat(vector2D.next(), equalTo(i + 1));
        }

        assertThat(vector2D.hasNext(), equalTo(false));

        input = new Integer[][]{{}, {}};
        vector2D = new Vector2D(Utils.arrayOfArrayToListOfList(input));
        assertThat(vector2D.hasNext(), equalTo(false));

        input = new Integer[][]{{}, {1}, {}};
        vector2D = new Vector2D(Utils.arrayOfArrayToListOfList(input));
        assertThat(vector2D.hasNext(), equalTo(true));
        assertThat(vector2D.next(), equalTo(1));
        assertThat(vector2D.hasNext(), equalTo(false));

        input = new Integer[][]{{1}, {}, {2}, {}};
        vector2D = new Vector2D(Utils.arrayOfArrayToListOfList(input));
        assertThat(vector2D.hasNext(), equalTo(true));
        assertThat(vector2D.next(), equalTo(1));
        assertThat(vector2D.hasNext(), equalTo(true));
        assertThat(vector2D.next(), equalTo(2));
        assertThat(vector2D.hasNext(), equalTo(false));

    }
}
