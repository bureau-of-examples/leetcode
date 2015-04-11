package zhy2002.leetcode.solutions.uniquebinarysearchtreesii;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {

        @SuppressWarnings("unchecked")
        List<TreeNode>[] cells = (List<TreeNode>[]) new ArrayList[(1 + n) * n / 2];
        List<TreeNode> emptySubTree = new ArrayList<>();
        emptySubTree.add(null);
        if(n == 0)
            return emptySubTree;

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int cellIndex = findCellIndex(i, j, n);
                if (cells[cellIndex] == null)
                    cells[cellIndex] = new ArrayList<>();

                for (int r = i; r <= j; r++) {

                    List<TreeNode> leftSubTree = emptySubTree;
                    if (r - 1 >= i) {
                        leftSubTree = cells[findCellIndex(i, r - 1, n)];
                    }
                    List<TreeNode> rightSubTree = emptySubTree;
                    if(r + 1 <= j){
                        rightSubTree = cells[findCellIndex(r + 1, j, n)];
                    }

                    for(TreeNode left : leftSubTree){
                        for(TreeNode right : rightSubTree){
                            TreeNode root = new TreeNode(r);
                            root.left = left;
                            root.right = right;
                            cells[cellIndex].add(root);
                        }
                    }
                }
            }
        }

        return cells[n - 1]; //i=1, j=n
    }

    private static int findCellIndex(int i, int j, int n) {
        return (i - 1) * (n + (n - i + 2)) / 2 + (j - i);
    }
}
