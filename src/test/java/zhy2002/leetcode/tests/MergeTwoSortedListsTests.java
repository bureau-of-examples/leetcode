package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.solutions.mergetwosortedlists.Solution;
import static org.junit.Assert.*;

public class MergeTwoSortedListsTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        ListNode l1 = Utils.createLinkedList(0, 0);
        ListNode l2 = Utils.createLinkedList(1,2,3);

        ListNode result = solution.mergeTwoLists(l1, l2);
        assertEquals("0 0 1 2 3", Utils.linkedListToString(result));

         l1 = Utils.createLinkedList(1,4,8,9);
         l2 = Utils.createLinkedList(2,3,8);
        result = solution.mergeTwoLists(l1, l2);
        assertEquals("1 2 3 4 8 8 9", Utils.linkedListToString(result));
    }
}


