package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeLinkNode;
import zhy2002.leetcode.solutions.populatingnextrightpointersineachnodeii.Solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class PopulatingNextRightPointersInEachNodeTestsII {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        TreeLinkNode node = createNode();
        solution.connect(node);
        assertEquals(node.right.left.right, node.right.left.left.next);
        assertEquals(node.right.left.left, node.left.right.right.next);

        node.right.left.left = null;
        solution.connect(node);
        assertEquals(node.right.left.right, node.left.right.right.next);

        node.right.left.right = null;
        solution.connect(node);
        assertEquals(node.right.right.left, node.left.right.right.next);

        node.right.right.left = null;
        solution.connect(node);
        assertEquals(node.right.right.right, node.left.right.right.next);

        node.right.right.right = null;
        solution.connect(node);
        assertNull(node.left.right.right.next);

        node = createNode();
        node.right = null;
        solution.connect(node);
        assertNull(node.left.right.right.next);
    }

    private TreeLinkNode createNode(){

        TreeLinkNode node = new TreeLinkNode(1);

        node.left = new TreeLinkNode(2);
        node.right = new TreeLinkNode(3);

        node.left.left = new TreeLinkNode(4);
        node.left.right = new TreeLinkNode(5);
        node.right.left = new TreeLinkNode(6);
        node.right.right = new TreeLinkNode(7);

        node.left.left.left = new TreeLinkNode(8);
        node.left.left.right = new TreeLinkNode(9);
        node.left.right.left = new TreeLinkNode(10);
        node.left.right.right = new TreeLinkNode(11);
        node.right.left.left = new TreeLinkNode(12);
        node.right.left.right = new TreeLinkNode(13);
        node.right.right.left = new TreeLinkNode(14);
        node.right.right.right = new TreeLinkNode(15);
        return node;
    }
}
