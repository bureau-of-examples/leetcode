package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeIITests {

    @Test
    public void test() {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);

        connect(root);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode leftMostChild = null;
        TreeLinkNode node = root;
        while (node != null) {
            TreeLinkNode prevChild = new TreeLinkNode(-1);
            TreeLinkNode curr = node;
            while (curr != null) {
                if (leftMostChild == null) {
                    leftMostChild = curr.left == null ? curr.right : curr.left;
                }
                if (curr.left != null) {
                    prevChild.next = curr.left;
                    prevChild = curr.left;
                }
                if (curr.right != null) {
                    prevChild.next = curr.right;
                    prevChild = curr.right;
                }
                curr = curr.next;
            }
            node = leftMostChild;
            leftMostChild = null;
        }
    }
}
