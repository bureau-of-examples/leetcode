package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.NestedInteger;
import zhy2002.leetcode.solutions.nestedlistweightsumii.Solution;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NestedListWeightSumIITests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        NestedInteger nestedInteger1 = new NestedListIntegerImpl(1);
        NestedInteger nestedInteger2 = new NestedListIntegerImpl(2);
        NestedInteger nestedInteger3 = new NestedListIntegerImpl(3);

        int sum = solution.depthSumInverse(Arrays.asList(nestedInteger1, nestedInteger2, nestedInteger3));
        assertThat(sum, equalTo(6));

        NestedInteger nestedList1 = new NestedListIntegerImpl(Arrays.asList(nestedInteger2, nestedInteger3));
        sum = solution.depthSumInverse(Arrays.asList(nestedInteger1, nestedList1, nestedInteger3));
        assertThat(sum, equalTo(13));

        NestedInteger nestedList2 = new NestedListIntegerImpl(Arrays.asList(nestedInteger1, nestedList1));
        sum = solution.depthSumInverse(Arrays.asList(nestedInteger1, nestedList1, nestedList2));
        assertThat(sum, equalTo(20));
    }
}
