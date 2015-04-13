package zhy2002.leetcode.solutions.binarytreelevelordertraversal;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Solution {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode sentinel = new TreeNode(0);
        queue.add(root);
        queue.add(sentinel);//level separator
        List<Integer> buffer = null;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node != sentinel){
                if(buffer == null)
                    buffer = new ArrayList<>();

                buffer.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            } else {
                result.add(buffer);
                buffer = null;
                if(!queue.isEmpty())
                    queue.add(sentinel);
            }
        }

        return result;
    }

}
