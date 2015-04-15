package zhy2002.leetcode.solutions.binarytreelevelordertraversalii;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode sentinel = new TreeNode(-1);
        queue.add(root);
        queue.add(sentinel);
        do{
            List<Integer> item = new ArrayList<>();
            while (true){
                TreeNode node = queue.poll();
                if(node == sentinel){
                    if(!queue.isEmpty()){
                        queue.add(sentinel);
                    }
                    break;
                }
                item.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(item);
        }while (!queue.isEmpty());

        int i = 0, j = result.size() - 1;
        while(i < j){//reverse
            List<Integer> temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
            i++; j--;
        }
        return result;
    }
}
