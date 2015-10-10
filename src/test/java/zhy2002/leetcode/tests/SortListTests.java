package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.sortlist.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class SortListTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        ListNode head = solution.sortList(null);
        assertThat(head, nullValue());

        head = Utils.createLinkedList(2);
        head = solution.sortList(head);
        assertThat(Utils.linkedListToString(head), equalTo("2"));

        head = Utils.createLinkedList(2, 0);
        head = solution.sortList(head);
        assertThat(Utils.linkedListToString(head), equalTo("0 2"));

        head = Utils.createLinkedList(5, 2, 3);
        head = solution.sortList(head);
        assertThat(Utils.linkedListToString(head), equalTo("2 3 5"));

        head = Utils.createLinkedList(-10,15, 22, 71);
        head = solution.sortList(head);
        assertThat(Utils.linkedListToString(head), equalTo("-10 15 22 71"));

        head = Utils.createLinkedList(2, 8, -5, 4, 16, 8, 7, 3);
        head = solution.sortList(head);
        assertThat(Utils.linkedListToString(head), equalTo("-5 2 3 4 7 8 8 16"));

    }
}
