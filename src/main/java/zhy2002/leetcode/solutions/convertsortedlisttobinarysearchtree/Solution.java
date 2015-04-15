package zhy2002.leetcode.solutions.convertsortedlisttobinarysearchtree;

import zhy2002.leetcode.common.ListNode;
import zhy2002.leetcode.common.TreeNode;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class Solution {

    public TreeNode sortedListToBST(ListNode head) {

        if (head == null)
            return null;

        if (head.next == null)
            return new TreeNode(head.val);

        int len = 0;
        ListNode current = head;
        while (current != null) {
            len++;
            current = current.next;
        }

        class BSTAssembler {
            private ListNode nextNode;

            public BSTAssembler(ListNode head) {
                nextNode = head;
            }

            public TreeNode assemble(int start, int end) {
                if (start > end)
                    return null;

                int mid = (start + end) >>> 1;
                TreeNode left = assemble(start, mid - 1);
                TreeNode parent = new TreeNode(nextNode.val);
                nextNode = nextNode.next;
                parent.left = left;
                parent.right = assemble(mid + 1, end);
                return parent;
            }
        }

        return new BSTAssembler(head).assemble(0, len - 1);
    }

}
