package zhy2002.leetcode.solutions.binarytreerightsideview;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solve with DFS.
 */
public class DFSSolution implements Solution {

    private List<Integer> result;

    @Override
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root != null)
            dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int level) {
        if(level == result.size()){
           result.add(node.val);
        }
        if(node.right != null){
            dfs(node.right, level + 1);
        }
        if(node.left != null){
            dfs(node.left, level + 1);
        }
    }
}
