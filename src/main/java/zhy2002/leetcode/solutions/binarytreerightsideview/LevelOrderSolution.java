package zhy2002.leetcode.solutions.binarytreerightsideview;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solve with level order traversal.
 */
public class LevelOrderSolution implements Solution{

    @Override
    @SuppressWarnings("unchecked")
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode>[] levels = new LinkedList[]{new LinkedList<>(), new LinkedList<>()};
            int levelIndex = 0;
            levels[levelIndex].add(root);
            while (!levels[levelIndex].isEmpty()) {
                int nextLevelIndex = (levelIndex + 1) % 2;
                boolean first = true;
                while (!levels[levelIndex].isEmpty()) {

                    TreeNode node = levels[levelIndex].pollFirst();
                    if (first) {
                        result.add(node.val);
                        first = false;
                    }

                    if (node.right != null)
                        levels[nextLevelIndex].addLast(node.right);
                    if (node.left != null)
                        levels[nextLevelIndex].addLast(node.left);
                }
                levelIndex = nextLevelIndex;
            }
        }
        return result;
    }
}
