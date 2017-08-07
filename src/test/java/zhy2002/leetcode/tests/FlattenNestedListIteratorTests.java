package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.NestedInteger;
import zhy2002.leetcode.common.SimpleNestedInteger;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class FlattenNestedListIteratorTests {

    @Test
    public void test() {
        NestedIterator nestedIterator = new NestedIterator(
                Arrays.asList(
                        new SimpleNestedInteger(
                                new SimpleNestedInteger(5),
                                new SimpleNestedInteger(4),
                                new SimpleNestedInteger(
                                        new SimpleNestedInteger(8),
                                        new SimpleNestedInteger(
                                                new SimpleNestedInteger(9)
                                        )
                                )
                        ),
                        new SimpleNestedInteger(1),
                        new SimpleNestedInteger(2)
                )
        );

        assertThat(nestedIterator.hasNext(), equalTo(true));
        assertThat(nestedIterator.next(), equalTo(5));
        assertThat(nestedIterator.next(), equalTo(4));
        assertThat(nestedIterator.next(), equalTo(8));
        assertThat(nestedIterator.next(), equalTo(9));
        assertThat(nestedIterator.next(), equalTo(1));
        assertThat(nestedIterator.next(), equalTo(2));
        assertThat(nestedIterator.hasNext(), equalTo(false));

        nestedIterator = new NestedIterator(new ArrayList<>());
        assertThat(nestedIterator.hasNext(), equalTo(false));
    }

    public class NestedIterator implements Iterator<Integer> {

        private Stack<List<NestedInteger>> listStack;
        private Stack<Integer> indexStack;

        public NestedIterator(List<NestedInteger> nestedList) {
            listStack = new Stack<>();
            indexStack = new Stack<>();
            pushNext(nestedList, 0);
        }

        private void pushNext(List<NestedInteger> nestedList, int index) {
            if ((nestedList == null || index == nestedList.size())) {
                if (!indexStack.isEmpty()) {
                    List<NestedInteger> list = listStack.pop();
                    int i = indexStack.pop();
                    pushNext(list, i);
                }
                return;
            }
            if (nestedList.get(index).isInteger()) {
                listStack.push(nestedList);
                indexStack.push(index);
                return;
            }

            listStack.push(nestedList);
            indexStack.push(index + 1);
            pushNext(nestedList.get(index).getList(), 0);
        }

        @Override
        public Integer next() {
            List<NestedInteger> list = listStack.pop();
            int index = indexStack.pop();
            NestedInteger integer = list.get(index);
            pushNext(list, index + 1);
            return integer.getInteger();
        }

        @Override
        public boolean hasNext() {
            return !indexStack.isEmpty();
        }
    }
}
