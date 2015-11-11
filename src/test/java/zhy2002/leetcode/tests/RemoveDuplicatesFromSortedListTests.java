package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.removeduplicatesfromsortedlist.Solution;

public class RemoveDuplicatesFromSortedListTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();
        ListNode result = solution.deleteDuplicates(null);
        assertThat(result, nullValue());

        ListNode head = new ListNode(1);
        head = solution.deleteDuplicates(head);
        assertThat(Utils.linkedListToString(head), equalTo("1"));

        head.next = new ListNode(1);
        head = solution.deleteDuplicates(head);
        assertThat(Utils.linkedListToString(head), equalTo("1"));

        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(3);
        head = solution.deleteDuplicates(head);
        assertThat(Utils.linkedListToString(head), equalTo("1 2 3"));
    }
}
