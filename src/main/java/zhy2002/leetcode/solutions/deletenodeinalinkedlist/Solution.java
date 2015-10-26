package zhy2002.leetcode.solutions.deletenodeinalinkedlist;

import zhy2002.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class Solution {
    //move the data of next node to the current node
    public void deleteNode(ListNode node) {

        if(node == null || node.next == null) //can't do
            return;

        ListNode next = node.next;
        while (true){
            node.val = next.val;
            if(next.next == null) {
                node.next = null;
                break;
            } else {
                node = next;
                next = next.next;
            }
        }

    }

}
