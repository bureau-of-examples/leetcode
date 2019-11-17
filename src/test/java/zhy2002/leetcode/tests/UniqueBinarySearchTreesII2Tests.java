package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII2Tests {

    @Test
    public void test() {
        List<TreeNode> result = generateTrees(3);
        for (TreeNode tree : result) {
            System.out.println(Utils.binaryTreeToString(tree));
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        if (start > end) {
            return Collections.singletonList(null);
        }

        List<TreeNode> result = new ArrayList<>();
        for (int i = start; i<=end; i++) {
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        return result;
    }
}
