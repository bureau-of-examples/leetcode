package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.containsduplicateiii.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContainsDuplicateIIITests {


    @Test
    public void basicTest() {
        TreeSetSolution solution = new TreeSetSolution();

        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{1,2,3,5,6,2,7}, 1000, 0), equalTo(true));
        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{9,1,12,3,5,6,2,7}, 1000, 0), equalTo(false));
        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{9,1,2,12,3,5,6,2,7}, 4, 0), equalTo(false));
        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{9,1,2,12,3,5,6,2,7}, 5, 0), equalTo(true));
        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{9,1,8,12,3,5,6,2,7}, 5, 0), equalTo(false));
        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{9,1,8,12,3,5,6,2,7}, 5, 1), equalTo(true));
        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{9, 15, 20, 5, 17, 10}, 3, 1), equalTo(false));
        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{9, 15, 20, 5, 17, 10}, 3, 5), equalTo(true));
        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{9, 15, 20, 5, 28, 10}, 2, 4), equalTo(false));
        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{9, 15, 20, 5, 28, 10}, 2, 5), equalTo(true));
    }

    @Test
    public void failOjTest(){
        TreeSetSolution solution = new TreeSetSolution();
        assertThat(solution.containsNearbyAlmostDuplicate(new int[]{0,2147483647}, 1, 2147483647), equalTo(true));
    }
}

