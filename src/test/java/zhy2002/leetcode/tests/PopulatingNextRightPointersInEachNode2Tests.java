package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeLinkNode;



public class PopulatingNextRightPointersInEachNode2Tests {

    @Test
    public void test() {

        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.left.left = new TreeLinkNode(8);
        root.left.left.right = new TreeLinkNode(9);
        root.left.right = new TreeLinkNode(5);
        root.left.right.left = new TreeLinkNode(10);
        root.left.right.right = new TreeLinkNode(11);
        root.right.left = new TreeLinkNode(6);
        root.right.left.left = new TreeLinkNode(12);
        root.right.left.right = new TreeLinkNode(13);
        root.right.right = new TreeLinkNode(7);
        root.right.right.left = new TreeLinkNode(14);
        root.right.right.right = new TreeLinkNode(15);

        connect(root);

        System.out.println();


    }

    private TreeLinkNode prev;

    public void connect(TreeLinkNode root) {
        prev = null;

        wireup(root);

        while (prev != null) {
            TreeLinkNode next = prev.next;
            prev.next = null;
            prev = next;
        }
    }

    public void wireup(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }

        root.left.next = root.right;
        if (prev != null) {
            TreeLinkNode next = prev.next;
            prev.next = root.left;
            prev = next;
        }

        wireup(root.left);
        wireup(root.right);

        if (prev != null) {
            root.right.next = prev;
        }
        prev = root.right;
    }

}
