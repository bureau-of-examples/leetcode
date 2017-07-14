package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/#/description
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal2Tests {

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(new int[]{1, 2, 4, 3}, new int[]{4, 3, 2, 1});

        assertThat(Utils.binaryTreeToString(root), equalTo("1 # 2 # 3 4"));
    }

    public class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder.length == 0)
                return null;

            Map<Integer, Integer> inorderIndexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderIndexMap.put(inorder[i], i);
            }

            return build(postorder, inorderIndexMap, postorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode build(int[] postorder, Map<Integer, Integer> inorderIndexMap, int postorderIndex, int inorderStart, int inorderEnd) {
            TreeNode node = new TreeNode(postorder[postorderIndex]);
            int inorderIndex = inorderIndexMap.get(node.val);
            int rightSize = inorderEnd - inorderIndex;
            if (rightSize > 0) {
                node.right = build(postorder, inorderIndexMap, postorderIndex - 1, inorderIndex + 1, inorderEnd);
            }
            int leftSize = inorderIndex - inorderStart;
            if (leftSize > 0) {
                node.left = build(postorder, inorderIndexMap, postorderIndex - rightSize - 1, inorderStart, inorderIndex - 1);
            }
            return node;
        }
    }
}
