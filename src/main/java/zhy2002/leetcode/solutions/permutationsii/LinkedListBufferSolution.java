package zhy2002.leetcode.solutions.permutationsii;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * use a linked list to avoid shifting elements in buffer like the {@link LinkedListBufferSolution}.
 */
public class LinkedListBufferSolution implements Solution{
    private List<List<Integer>> result;
    private ListNode buffer;

    @Override
    public List<List<Integer>> permuteUnique(int[] num) {

        Arrays.sort(num);
        result = new ArrayList<>();
        buffer = new ListNode(-1);//sentinel
        ListNode current = buffer;
        for (int number : num) {
            current.next = new ListNode(number);
            current = current.next;
        }
        permuteUnique(buffer);
        return result;
    }

    private void permuteUnique(ListNode head) {
        ListNode current;
        if (head.next == null) { //last node
            ArrayList<Integer> permutation = new ArrayList<>();
            current = buffer.next;
            while (current != null) {
                permutation.add(current.val);
                current = current.next;
            }
            result.add(permutation);
            return;
        }

        permuteUnique(head.next);

        ListNode headNext = head.next;
        ListNode previous = headNext;
        current = previous.next;
        while (current != null) {
            if (current.val != previous.val && current.val != head.next.val) {

                //move
                head.next = current;
                previous.next = current.next;
                current.next = headNext;

                permuteUnique(head.next);

                //restore
                head.next = headNext;
                current.next = previous.next;
                previous.next = current;

            }

            previous = current;
            current = current.next;
        }
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
