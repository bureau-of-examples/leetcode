package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.oddevenlinkedlist.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OddEvenLinkedListTests {

    @Test
    public void basicTest(){

        Solution solution = new Solution();

        assertThat(solution.oddEvenList(null), nullValue());
        assertThat(Utils.linkedListToString(Utils.createLinkedList(1)), equalTo("1"));
        assertThat(Utils.linkedListToString(solution.oddEvenList(Utils.createLinkedList(1, 2))), equalTo("1 2"));
        assertThat(Utils.linkedListToString(solution.oddEvenList(Utils.createLinkedList(1, 2, 3))), equalTo("1 3 2"));
        assertThat(Utils.linkedListToString(solution.oddEvenList(Utils.createLinkedList(1, 2, 3, 4))), equalTo("1 3 2 4"));
        assertThat(Utils.linkedListToString(solution.oddEvenList(Utils.createLinkedList(1, 2, 3, 4, 5))), equalTo("1 3 5 2 4"));
    }
}
