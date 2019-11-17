package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

public class LowestCommonAncestorOfABinaryTree3Tests {

    @Test
    public void test() {
        TreeNode lowestCommon = lowestCommonAncestor(
                Utils.stringToBinaryTree("3,5,1,6,2,0,8,null,null,7,4"),
                new TreeNode(5),
                new TreeNode(1)
        );
        System.out.println(lowestCommon.val);
    }

    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        result = null;
        postOrder(root, p, q);
        return result;
    }

    private int postOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        int rootFlag = root.val == p.val ? 1 : (root.val == q.val ? 2 : 0);
        int left = postOrder(root.left, p, q);
        if (left == 3) {
            return 3;
        }
        if ((left | rootFlag) == 3) {
            result = root;
            return 3;
        }
        int right = postOrder(root.right, p, q);
        if (right == 3) {
            return 3;
        }
        if ((right | rootFlag) == 3) {
            result = root;
            return 3;
        }
        if ((left | right) == 3) {
            result = root;
            return 3;
        }
        return left | right | rootFlag;
    }
}
