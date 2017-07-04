package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/#/description
 */
public class SerializeAndDeserializeBinaryTreeTests {

    @Test
    public void test() {
        Codec codec = new Codec();
        assertThat(Utils.binaryTreeToString(codec.deserialize("5,2,3,null,null,2,4,3,1")), equalTo("5 2 3 # # 2 4 3 1"));
        assertThat(Utils.binaryTreeToString(codec.deserialize("")), equalTo(""));
        assertThat(Utils.binaryTreeToString(codec.deserialize("234")), equalTo("234"));
        assertThat(Utils.binaryTreeToString(codec.deserialize("234,44,null,25")), equalTo("234 44 # 25"));
        assertThat(codec.serialize(Utils.stringToBinaryTree("5,2,3,null,null,2,4,3,1")), equalTo("5,2,3,null,null,2,4,3,1"));
        assertThat(codec.serialize(new TreeNode(10)), equalTo("10"));
        assertThat(codec.serialize(null), equalTo(""));
        assertThat(codec.serialize(Utils.stringToBinaryTree("4,1,2,null,5")), equalTo("4,1,2,null,5"));
        assertThat(codec.serialize(Utils.stringToBinaryTree("4,1,2,null,5,6,7")), equalTo("4,1,2,null,5,6,7"));
    }

    public class Codec {

        private TreeNode sentinel = new TreeNode(-1);

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "";

            Queue<TreeNode> queue = new ArrayDeque<>();
            StringBuilder stringBuilder = new StringBuilder();
            queue.add(root);
            int notNullCount = 1;
            while (notNullCount > 0) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(",");
                }
                TreeNode node = queue.poll();
                if (node == sentinel) {
                    stringBuilder.append("null");
                } else {
                    stringBuilder.append(String.valueOf(node.val));
                    notNullCount--;
                    if (node.left != null) {
                        queue.add(node.left);
                        notNullCount++;
                    } else {
                        queue.add(sentinel);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        notNullCount++;
                    } else {
                        queue.add(sentinel);
                    }
                }
            }
            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0)
                return null;
            String[] values = data.split(",\\s*");
            int index = 0;
            Queue<TreeNode> queue = new ArrayDeque<>();
            TreeNode root = new TreeNode(Integer.parseInt(values[index++]));
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (index == values.length)
                    break;
                if (!"null".equals(values[index])) {
                    node.left = new TreeNode(Integer.parseInt(values[index]));
                    queue.add(node.left);
                }
                index++;

                if (index == values.length)
                    break;
                if (!"null".equals(values[index])) {
                    node.right = new TreeNode(Integer.parseInt(values[index]));
                    queue.add(node.right);
                }
                index++;
            }
            return root;
        }
    }
}
