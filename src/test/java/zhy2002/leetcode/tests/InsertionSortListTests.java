package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.insertionsortlist.Solution;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class InsertionSortListTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        ListNode head = solution.insertionSortList(null);
        assertThat(head, nullValue());

        head = Utils.createLinkedList(3,2,1);
        head = solution.insertionSortList(head);
        assertThat(Utils.linkedListToString(head), equalTo("1 2 3"));

        head = Utils.createLinkedList(1,2,-1,3,0);
        head = solution.insertionSortList(head);
        assertThat(Utils.linkedListToString(head), equalTo("-1 0 1 2 3"));

        head = Utils.createLinkedList(-2, 1);
        head = solution.insertionSortList(head);
        assertThat(Utils.linkedListToString(head), equalTo("-2 1"));

        head = Utils.createLinkedList(2, -10);
        head = solution.insertionSortList(head);
        assertThat(Utils.linkedListToString(head), equalTo("-10 2"));

        head = Utils.createLinkedList(15, 7, 2, 30, -10, 9);
        head = solution.insertionSortList(head);
        assertThat(Utils.linkedListToString(head), equalTo("-10 2 7 9 15 30"));

    }
}
