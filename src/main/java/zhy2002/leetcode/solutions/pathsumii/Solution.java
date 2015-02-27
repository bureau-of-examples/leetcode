package zhy2002.leetcode.solutions.pathsumii;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/path-sum-ii/
 */
public class Solution {
    private List<List<Integer>> result;
    private List<Integer> path;
    private int sum;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        result = new ArrayList<>();
        path = new ArrayList<>();
        this.sum = sum;
        findPath(root, 0);
        List<List<Integer>> returnValue = result;
        result = null;
        path = null;
        return returnValue;
    }

    private void findPath(TreeNode node, int sumSoFar){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            if(sumSoFar + node.val != sum){
                return;
            }
            List<Integer> finalPath = new ArrayList<>(this.path);
            finalPath.add(node.val);
            result.add(finalPath);
            return;
        }

        this.path.add(node.val);
        sumSoFar += node.val;
        findPath(node.left, sumSoFar);
        findPath(node.right, sumSoFar);
        this.path.remove(this.path.size() - 1);
    }
}
