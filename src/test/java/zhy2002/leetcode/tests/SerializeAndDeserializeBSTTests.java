package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/#/description
 */
public class SerializeAndDeserializeBSTTests {

    @Test
    public void test() {
        Codec codec = new Codec();
        assertThat(
                codec.serialize(Utils.stringToBinaryTree("3")),
                equalTo("3")
        );
        assertThat(
                codec.serialize(Utils.stringToBinaryTree("3,1")),
                equalTo("3(1)")
        );
        assertThat(
                codec.serialize(Utils.stringToBinaryTree("3,1,5")),
                equalTo("3(1,5)")
        );
        assertThat(
                codec.serialize(Utils.stringToBinaryTree("3,1,5,0")),
                equalTo("3(1(0),5)")
        );
        assertThat(
                codec.serialize(Utils.stringToBinaryTree("3,1,5,0,null,4,6")),
                equalTo("3(1(0),5(4,6))")
        );

        assertThat(
                codec.serialize(codec.deserialize("3(1(0),5(4,6))")),
                equalTo("3(1(0),5(4,6))")
        );

        assertThat(
                codec.serialize(codec.deserialize("3(1(0),5)")),
                equalTo("3(1(0),5)")
        );
        assertThat(
                codec.serialize(codec.deserialize("3(1,5)")),
                equalTo("3(1,5)")
        );
        assertThat(
                codec.serialize(codec.deserialize("3(1)")),
                equalTo("3(1)")
        );
        assertThat(
                codec.serialize(codec.deserialize("3")),
                equalTo("3")
        );
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "";

            StringBuilder sb = new StringBuilder();
            build(sb, root);
            return sb.toString();
        }

        private void build(StringBuilder sb, TreeNode node) {
            if (node == null)
                return;

            sb.append(String.valueOf(node.val));
            if (node.left != null || node.right != null) {
                sb.append("(");
                if (node.left != null) {
                    build(sb, node.left);
                }
                if (node.right != null) {
                    if (node.left != null) {
                        sb.append(",");
                    }
                    build(sb, node.right);
                }
                sb.append(")");
            }


        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0)
                return null;
            TreeNode root = new TreeNode(0);
            restore(data, root, 0);
            return root.left == null ? root.right : root.left;
        }

        //returns pos after this node
        private int restore(String data, TreeNode parent, int start) {
            if (data.charAt(start) == ')')
                return start;
            int index = start + 1;
            while (index < data.length()) {
                char ch = data.charAt(index);
                if (ch == '(' || ch == ',' || ch == ')')
                    break;
                index++;
            }
            TreeNode node = new TreeNode(Integer.parseInt(data.substring(start, index)));
            if (node.val < parent.val) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            if (index == data.length())
                return index;
            char ch = data.charAt(index);
            if (ch == ')' || ch == ',')
                return index;
            assert ch == '('; //parse children
            index = restore(data, node, index + 1);
            ch = data.charAt(index);
            if (ch == ',') {
                index = restore(data, node, index + 1);
                return index + 1;
            } else {
                assert ch == ')';
                return index + 1;
            }
        }
    }
}
