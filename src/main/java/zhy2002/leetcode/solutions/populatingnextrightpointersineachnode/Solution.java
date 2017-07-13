package zhy2002.leetcode.solutions.populatingnextrightpointersineachnode;

import zhy2002.leetcode.common.TreeLinkNode;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class Solution {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        TreeLinkNode parentLevelHead = root;
        TreeLinkNode childLevelHead = root.left;

        while (childLevelHead != null) {//there is next level
            while (true) {
                parentLevelHead.left.next = parentLevelHead.right;
                if (parentLevelHead.next == null)
                    break;
                parentLevelHead.right.next = parentLevelHead.next.left;
                parentLevelHead = parentLevelHead.next;
            }
            parentLevelHead = childLevelHead;
            childLevelHead = parentLevelHead.left;
        }
    }
}
