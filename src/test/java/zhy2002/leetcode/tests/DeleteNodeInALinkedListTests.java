package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.deletenodeinalinkedlist.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DeleteNodeInALinkedListTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();

        ListNode list = Utils.createLinkedList();
        solution.deleteNode(list);
        assertThat(Utils.linkedListToString(list), equalTo(""));

        list = Utils.createLinkedList(1, 2, 3);
        solution.deleteNode(list);
        assertThat(Utils.linkedListToString(list), equalTo("2 3"));

        list = Utils.createLinkedList(1, 2, 3);
        solution.deleteNode(list.next);
        assertThat(Utils.linkedListToString(list), equalTo("1 3"));

        list = Utils.createLinkedList(1, 2, 3, 4, 5);
        solution.deleteNode(list.next.next);
        assertThat(Utils.linkedListToString(list), equalTo("1 2 4 5"));

        list = Utils.createLinkedList(1, 2, 3, 4, 5);
        solution.deleteNode(list.next.next.next);
        assertThat(Utils.linkedListToString(list), equalTo("1 2 3 5"));
    }
}
