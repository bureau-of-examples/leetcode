package zhy2002.leetcode.solutions.binarytreepaths;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();
        dumpPaths(result, new LinkedList<>(), root);
        return result;
    }

    private void dumpPaths(List<String> result, LinkedList<Integer> buffer, TreeNode node) {

        if (node == null) {
            return;
        }

        buffer.addLast(node.val);
        if (node.left == null && node.right == null) {
            result.add(buildPath(buffer));
        } else {
            if (node.left != null) {
                dumpPaths(result, buffer, node.left);
            }
            if (node.right != null) {
                dumpPaths(result, buffer, node.right);
            }
        }
        buffer.removeLast();
    }

    private String buildPath(LinkedList<Integer> buffer) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (Integer val : buffer) {
            if (first) {
                first = false;
            } else {
                stringBuilder.append("->");
            }
            stringBuilder.append(val);
        }
        return stringBuilder.toString();
    }

}
