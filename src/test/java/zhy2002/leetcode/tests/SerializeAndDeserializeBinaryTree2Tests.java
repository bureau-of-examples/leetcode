package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

public class SerializeAndDeserializeBinaryTree2Tests {

    @Test
    public void test() {
        Codec c = new Codec();

        String s = c.serialize(Utils.stringToBinaryTree("1,2,3,null,null,4,5"));
        TreeNode root = c.deserialize(s);
    }

    private static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            save(root, sb);
            return sb.toString();
        }

        private void save(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val);
            if (root.left != null || root.right != null) {
                sb.append('(');
                save(root.left, sb);
                sb.append(',');
                save(root.right, sb);
                sb.append(')');
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            int[] index = new int[1];
            return load(data, index);
        }
        //33(25,56(,4))
        private TreeNode load(String sb, int[] index) {
            if (index[0] >= sb.length()) {
                return null;
            }

            int next = index[0];
            while (true) {
                if (next >= sb.length() || !numChar(sb.charAt(next))) {
                    break;
                }
                next++;
            }
            String numStr = sb.substring(index[0], next);
            index[0] = next;

            if (numStr.length() == 0) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.valueOf(numStr));
            char nextChar = index[0] < sb.length() ? sb.charAt(index[0]) : '?';

            boolean hasChildren = false;
            if (nextChar == '(') {
                hasChildren = true;
                index[0]++;
                node.left = load(sb, index);
                nextChar = index[0] < sb.length() ? sb.charAt(index[0]) : '?';
            }
            if (nextChar == ',' && hasChildren) {
                index[0]++;
                node.right = load(sb, index);
                nextChar = index[0] < sb.length() ? sb.charAt(index[0]) : '?';
            }
            if (nextChar == ')' && hasChildren) {
                index[0]++;
            }
            return node;
        }

        private boolean numChar(char ch) {
            return ch != '(' && ch != ',' && ch != ')';
        }
    }
}
