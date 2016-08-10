package zhy2002.leetcode.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.plusonelinedlist.Solution;

public class PlusOneLinkedListTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        ListNode head = Utils.createLinkedList(1, 2, 3);
        head = solution.plusOne(head);
        assertThat(Utils.linkedListToString(head), equalTo("1 2 4"));

        head = Utils.createLinkedList(9);
        head = solution.plusOne(head);
        assertThat(Utils.linkedListToString(head), equalTo("1 0"));

        head = Utils.createLinkedList(1, 8, 9, 9, 9);
        head = solution.plusOne(head);
        assertThat(Utils.linkedListToString(head), equalTo("1 9 0 0 0"));
    }
}
