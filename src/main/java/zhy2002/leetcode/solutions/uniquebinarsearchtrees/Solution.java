package zhy2002.leetcode.solutions.uniquebinarsearchtrees;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * # trees = #left tree * #right tree
 * Classify into the following cases:
 * left 0 right n-1 nodes
 * left 1 right n-2 nodes
 * ...
 * left n-1 right 0 nodes
 * Note that for a valid binary search tree, if the left subtree and right subtree are determined, the root is also determined.
 */
public class Solution {

    public int numTrees(int n) {

        if (n < 2)
            return 1;

        int[] numbers = new int[n + 1];
        numbers[0] = numbers[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += numbers[j - 1] * numbers[i - j];
            }
            numbers[i] = sum;
        }

        return numbers[n];

    }

}
