package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.mergeksortedlists.Solution;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeKSortedListsTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        ListNode head1 = Utils.createLinkedList(new int[]{1, 2, 3});
        ListNode head2 = Utils.createLinkedList(new int[]{7, 8, 9});
        ListNode head3 = Utils.createLinkedList(new int[]{4,6,11});
        ListNode result = solution.mergeKLists(Arrays.asList(head1, head2, head3));
        String str = Utils.linkedListToString(result);
        assertEquals("1 2 3 4 6 7 8 9 11", str);

        head1 = Utils.createLinkedList(new int[]{1,3,5,7,9});
        head2 = Utils.createLinkedList(new int[]{2,4,6,8});
        head3 = Utils.createLinkedList(new int[]{-1, 10});
        result = solution.mergeKLists(Arrays.asList(head1, head2, head3));
        str = Utils.linkedListToString(result);
        assertEquals("-1 1 2 3 4 5 6 7 8 9 10", str);
    }

}
