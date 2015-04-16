package zhy2002.leetcode.tests;
import org.junit.Test;
import zhy2002.leetcode.common.TreeLinkNode;
import zhy2002.leetcode.solutions.populatingnextrightpointersineachnode.Solution;
import static org.junit.Assert.*;


public class PopulatingNextRightPointersInEachNodeTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        solution.connect(null);

        TreeLinkNode node = new TreeLinkNode(1);
        solution.connect(node);
        assertNull(node.next);

        node.left = new TreeLinkNode(2);
        node.right = new TreeLinkNode(3);
        solution.connect(node);
        assertNull(node.next);
        assertEquals(node.right, node.left.next);
        assertNull(node.right.next);

        node.left.left = new TreeLinkNode(4);
        node.left.right = new TreeLinkNode(5);
        node.right.left = new TreeLinkNode(6);
        node.right.right = new TreeLinkNode(7);
        solution.connect(node);
        assertNull(node.next);
        assertEquals(node.right, node.left.next);
        assertNull(node.right.next);
        assertEquals(node.left.right, node.left.left.next);
        assertEquals(node.right.left, node.left.right.next);
        assertEquals(node.right.right, node.right.left.next);
        assertNull(node.right.right.next);

        node.left.left.left = new TreeLinkNode(8);
        node.left.left.right = new TreeLinkNode(9);
        node.left.right.left = new TreeLinkNode(10);
        node.left.right.right = new TreeLinkNode(11);
        node.right.left.left = new TreeLinkNode(12);
        node.right.left.right = new TreeLinkNode(13);
        node.right.right.left = new TreeLinkNode(14);
        node.right.right.right = new TreeLinkNode(15);
        solution.connect(node);
        assertNull(node.next);
        assertEquals(node.right, node.left.next);
        assertNull(node.right.next);
        assertEquals(node.left.right, node.left.left.next);
        assertEquals(node.right.left, node.left.right.next);
        assertEquals(node.right.right, node.right.left.next);
        assertNull(node.right.right.next);
        assertEquals(node.left.left.right, node.left.left.left.next);
        assertEquals(node.left.right.left, node.left.left.right.next);
        assertEquals(node.left.right.right, node.left.right.left.next);
        assertEquals(node.right.left.left, node.left.right.right.next);
        assertEquals(node.right.right.right, node.right.right.left.next);
        assertNull(node.right.right.right.next);

    }
}
