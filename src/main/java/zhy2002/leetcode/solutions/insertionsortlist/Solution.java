package zhy2002.leetcode.solutions.insertionsortlist;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;

        ListNode headPrev = new ListNode(0);
        headPrev.next = head;
        ListNode pointerPrev = head;
        while (pointerPrev.next != null){
            ListNode insertionPrev = headPrev; //find insertion point by checking from the beginning.
            while (insertionPrev != pointerPrev && insertionPrev.next.val <= pointerPrev.next.val){
                insertionPrev = insertionPrev.next;
            }
            if(insertionPrev != pointerPrev) {
                ListNode temp = insertionPrev.next;
                insertionPrev.next = pointerPrev.next;
                pointerPrev.next = pointerPrev.next.next;
                insertionPrev.next.next = temp;
            } else {
                pointerPrev = pointerPrev.next;
            }
        }

        return headPrev.next;
    }

}
