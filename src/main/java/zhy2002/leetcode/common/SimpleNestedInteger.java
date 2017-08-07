package zhy2002.leetcode.common;

import java.util.Arrays;
import java.util.List;

public class SimpleNestedInteger implements NestedInteger {

    private int val;
    private boolean isInteger;
    private List<NestedInteger> nestedIntegers;

    public SimpleNestedInteger(int val) {
        this.val = val;
        this.isInteger = true;
    }

    public SimpleNestedInteger(NestedInteger... nestedIntegers) {
        this.nestedIntegers = Arrays.asList(nestedIntegers);
    }

    @Override
    public boolean isInteger() {
        return isInteger;
    }

    @Override
    public Integer getInteger() {
        return isInteger ? val : null;
    }

    @Override
    public List<NestedInteger> getList() {
        return isInteger ? null : nestedIntegers;
    }
}
