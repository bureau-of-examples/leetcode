package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree2Tests {

    @Test
    public void test() {
        //System.out.println(boundaryOfBinaryTree(Utils.stringToBinaryTree("1,null,2,3,4")));
        System.out.println(boundaryOfBinaryTree(Utils.stringToBinaryTree("1,2,3,4,5,6,null,null,null,7,8,9,10")));
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            getLeft(root, result);
            getLeaf(root.left, result);
            getLeaf(root.right, result);
            getRight(root.right, result);
        }
        return result;
    }

    private void getLeft(TreeNode root, List<Integer> result) {
        result.add(root.val);
        TreeNode node = root.left;
        while (node != null && (node.left != null || node.right != null)) {
            result.add(node.val);
            node = node.left == null ? node.right : node.left;
        }
    }

    private void getLeaf(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        getLeaf(root.left, result);
        getLeaf(root.right, result);
    }

    private void getRight(TreeNode node, List<Integer> result) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        getRight(node.right == null ? node.left : node.right, result);
        result.add(node.val);
    }
}
