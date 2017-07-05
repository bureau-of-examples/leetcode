package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.common.TreeNode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-string/#/description
 */
public class ConstructBinaryTreeFromStringTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(Utils.binaryTreeToString(solution.str2tree("1(2(4)(5))(3(6))")), equalTo("1 2 3 4 5 6"));
        assertThat(Utils.binaryTreeToString(solution.str2tree("1(2(4))(3)")), equalTo("1 2 3 4"));
        assertThat(Utils.binaryTreeToString(solution.str2tree("1(2)(3)")), equalTo("1 2 3"));
        assertThat(Utils.binaryTreeToString(solution.str2tree("1(2)")), equalTo("1 2"));
        assertThat(Utils.binaryTreeToString(solution.str2tree("1")), equalTo("1"));
    }

    public class Solution {
        private int start;

        public TreeNode str2tree(String s) {
            start = 0;
            return build(s);
        }

        private boolean notSpecial(char ch) {
            return ch == '-' || ch >= '0' && ch <= '9';
        }

        private TreeNode build(String s) {
            if (start == s.length())
                return null;

            int numIndex = start;
            while (start < s.length() && notSpecial(s.charAt(start))) {
                start++;
            }
            TreeNode node = new TreeNode(Integer.parseInt(s.substring(numIndex, start)));
            if (start == s.length() || s.charAt(start) == ')') {
                return node;
            }
            //parse children
            assert s.charAt(start) == '(';
            start++;
            node.left = build(s);
            start++;
            if (start < s.length() && s.charAt(start) == '(') {
                start++;
                node.right = build(s);
                start++;
            }

            return node;
        }
    }


}
