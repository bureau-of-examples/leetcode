package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.common.TreeNode;
import zhy2002.leetcode.solutions.binarysearchtreeiterator.BSTIterator;

import static org.junit.Assert.*;

public class BinarySearchTreeIteratorTests {

    @Test
    public void basicTest(){
        BSTIterator iterator = new BSTIterator(null);
        assertFalse(iterator.hasNext());

        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(30);
        iterator = new BSTIterator(root);
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(15, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(30, iterator.next());
        assertFalse(iterator.hasNext());

        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(3);
        iterator = new BSTIterator(root);
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next());



    }
}
