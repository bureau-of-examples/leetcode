package zhy2002.leetcode.solutions.sumroottoleafnumbers;

import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * dfs.
 */
public class Solution {

    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<>();
        sumNumbers(root, new ArrayList<Integer>()/*cache digits from root to this node so far*/, values);//get value at each leaf
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        return sum;
    }

    private static void sumNumbers(TreeNode node, List<Integer> digits, List<Integer> values) {
        if (node == null)
            return;
        digits.add(node.val);
        if (node.left == null && node.right == null) {//leaf, create number
            int sum = 0;
            int pow = 1;
            for (int i = digits.size() - 1; i >= 0; i--) {
                sum += digits.get(i) * pow;
                pow *= 10;
            }
            values.add(sum);
        } else {
            sumNumbers(node.left, digits, values);
            sumNumbers(node.right, digits, values);
        }
        digits.remove(digits.size() - 1);
    }

}
