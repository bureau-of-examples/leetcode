package zhy2002.leetcode.solutions.binarytreepostordertraversal;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Solve the problem recursively.
 */
public class RecursiveSolution implements Solution {

    @Override
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        visit(result, root);
        return result;
    }

    private void visit(List<Integer> result, TreeNode root) {
        if(root == null){
            return;
        }

        visit(result, root.left);
        visit(result, root.right);
        result.add(root.val);
    }
}
