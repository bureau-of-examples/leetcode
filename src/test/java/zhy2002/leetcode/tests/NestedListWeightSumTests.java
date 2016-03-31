package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.NestedInteger;
import zhy2002.leetcode.solutions.nestedlistweightsum.Solution;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class NestedListIntegerImpl implements NestedInteger {

    private final Integer value;
    private final List<NestedInteger> nestedIntegers;

    NestedListIntegerImpl(Integer value) {
        this.value = value;
        this.nestedIntegers = null;
    }

    NestedListIntegerImpl(List<NestedInteger> nestedIntegers) {
        this.nestedIntegers = nestedIntegers;
        this.value = null;
    }

    @Override
    public boolean isInteger() {
        return this.value != null;
    }

    @Override
    public Integer getInteger() {
        return this.value;
    }

    @Override
    public List<NestedInteger> getList() {
        return this.nestedIntegers;
    }
}

public class NestedListWeightSumTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        NestedListIntegerImpl nestedListInteger1 = new NestedListIntegerImpl(1);
        NestedListIntegerImpl nestedListInteger2 = new NestedListIntegerImpl(2);

        int result = solution.depthSum(Arrays.asList(nestedListInteger1, nestedListInteger2));
        assertThat(result, equalTo(3));

        NestedListIntegerImpl nestedListInteger3 = new NestedListIntegerImpl(3);
        NestedListIntegerImpl nestedListInteger4 = new NestedListIntegerImpl(4);

        NestedListIntegerImpl nestedListIntegerList1 = new NestedListIntegerImpl(Arrays.asList(nestedListInteger1, nestedListInteger2));
        result = solution.depthSum(Arrays.asList(nestedListIntegerList1, nestedListInteger1, nestedListInteger2));
        assertThat(result, equalTo(9));

        NestedListIntegerImpl nestedListIntegerList2 = new NestedListIntegerImpl(Arrays.asList(nestedListInteger4, nestedListInteger1, nestedListIntegerList1));

        result = solution.depthSum(Arrays.asList(nestedListIntegerList1, nestedListInteger3, nestedListIntegerList2));
        assertThat(result, equalTo(28));
    }
}
