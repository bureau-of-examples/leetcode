package zhy2002.leetcode.solutions.binarytreezigzaglevelordertraversal;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        boolean leftToRight = true;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);

        do {
            int levelSize = deque.size();
            List<Integer> levelVal = new ArrayList<>();
            if (leftToRight) {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = deque.removeFirst();
                    levelVal.add(node.val);
                    if (node.left != null)
                        deque.addLast(node.left);
                    if (node.right != null)
                        deque.addLast(node.right);
                }
            } else {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = deque.removeLast();
                    levelVal.add(node.val);
                    if (node.right != null)//right before left
                        deque.addFirst(node.right);
                    if (node.left != null)
                        deque.addFirst(node.left);
                }
            }
            leftToRight = !leftToRight;
            result.add(levelVal);
        } while (!deque.isEmpty());

        return result;
    }
}
