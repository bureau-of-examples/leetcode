package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ClosestLeafInABinaryTreeTests {

    @Test
    public void test() {
        //System.out.println(findClosestLeaf(Utils.stringToBinaryTree("1,2,3,4,null,null,null,5,null,6"), 2));
        System.out.println(findClosestLeaf(Utils.stringToBinaryTree("1,2,3,4,5"), 1));
    }

    private int result;
    private int minDist;

    public int findClosestLeaf(TreeNode root, int k) {
        minDist = Integer.MAX_VALUE;
        List<TreeNode> path = new ArrayList<>();
        getPath(root, k, path);
        search(path.get(path.size() - 1), 0, 1);
        for (int i = path.size() - 2; i >= 0; i--) {
            TreeNode node = path.get(i);
            if (node.left == path.get(i + 1)) {
                search(node.right, path.size() - i, 1);
            } else {
                search(node.left, path.size() - i, 1);
            }
        }
        return result;
    }

    private void search(TreeNode root, int prefix, int level) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            int dist = prefix + level;
            if (dist < minDist) {
                minDist = dist;
                result = root.val;
            }
        }

        search(root.left, prefix, level + 1);
        search(root.right, prefix, level + 1);
    }

    private boolean getPath(TreeNode root, int k, List<TreeNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.val == k) {
            return true;
        }

        if (getPath(root.left, k, path)) {
            return true;
        }
        if (getPath(root.right, k, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
