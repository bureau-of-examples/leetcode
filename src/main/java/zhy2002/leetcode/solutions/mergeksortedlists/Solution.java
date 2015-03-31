package zhy2002.leetcode.solutions.mergeksortedlists;

import zhy2002.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Use a priority queue to extra the minimum in O(K) time.
 * When a node is polled its next is added.
 */
public class Solution {

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        ListNode result = null, current = null;
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (current == null) {
                result = node;
                current = node;
            } else {
                current.next = node;
                current = current.next;
            }
            if (node.next != null)
                pq.add(node.next);
        }

        return result;
    }

}
