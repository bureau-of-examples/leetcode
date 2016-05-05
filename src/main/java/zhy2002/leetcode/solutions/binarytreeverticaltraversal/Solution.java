package zhy2002.leetcode.solutions.binarytreeverticaltraversal;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *      3
 *     /\
 *    /  \
 *   9  20
 *  /\
 * /  \
 * 15   7
 * return its vertical order traversal as:
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 */
public class Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> leftList = new ArrayList<>();  //(,0)
        List<List<Integer>> rightList = new ArrayList<>(); //[0,)
        traverseBFS(leftList, rightList, root);
        //traverseDFS(leftList, rightList, 0, root);
        Collections.reverse(leftList);
        leftList.addAll(rightList);
        return leftList;
    }

    private static class Wrapper {
        public TreeNode node;
        public int position;

        public Wrapper(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    private void traverseBFS(List<List<Integer>> leftList, List<List<Integer>> rightList, TreeNode root) {
        LinkedList<Wrapper> queue = new LinkedList<>();
        queue.add(new Wrapper(root, 0));
        while (!queue.isEmpty()) {
            Wrapper wrapper = queue.poll();
            int pos = wrapper.position;
            TreeNode node = wrapper.node;
            if(pos >= 0) { //add to right
                if(pos == rightList.size()) {
                    rightList.add(new ArrayList<>());
                } else {
                    assert pos < rightList.size();
                }
                rightList.get(pos).add(node.val);
            } else { //add to left
                int leftPos = -pos - 1;
                if(leftPos == leftList.size()) {
                    leftList.add(new ArrayList<>());
                } else {
                    assert leftPos < leftList.size();
                }
                leftList.get(leftPos).add(node.val);
            }
            if(node.left != null)
                queue.add(new Wrapper(node.left, pos - 1));
            if(node.right != null)
                queue.add(new Wrapper(node.right, pos + 1));
        }
    }

    /*
    private void traverseDFS(List<List<Integer>> leftList, List<List<Integer>> rightList, int pos, TreeNode node) {
        if(pos >= 0) { //add to right
            if(pos == rightList.size()) {
                rightList.add(new ArrayList<>());
            } else {
                assert pos < rightList.size();
            }
            rightList.get(pos).add(node.val);
        } else { //add to left
            int leftPos = -pos - 1;
            if(leftPos == leftList.size()) {
                leftList.add(new ArrayList<>());
            } else {
                assert leftPos < leftList.size();
            }
            leftList.get(leftPos).add(node.val);
        }

        if(node.left != null)
            traverseDFS(leftList, rightList, pos - 1, node.left);
        if(node.right != null)
            traverseDFS(leftList, rightList, pos + 1, node.right);
    }
    */
}
