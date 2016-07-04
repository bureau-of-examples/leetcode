package zhy2002.leetcode.solutions.verifypreorderserializationofabinarytree;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
 * <p>
 * * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p>
 *    _9_
 *   /   \
 *  3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 * <p>
 * Example 2:
 * "1,#"
 * Return false
 * <p>
 * Example 3:
 * "9,#,#,1"
 * Return false
 */
public class Solution {

    private static class Node {
        String value;
        int childrenCount;

        Node(String value) {
            this.value = value;
        }
    }

    public boolean isValidSerialization(String preorder) {
        String[] values = preorder.split(",");
        //edge cases
        if(values.length == 0)
            return false;
        if(values[0].equals("#"))
            return values.length == 1;

        //init
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(new Node(values[0]));

        //check
        for(int i=1; i<values.length;i++) {
            if(stack.isEmpty())
                return false;
            Node top = stack.peek();
            top.childrenCount++;
            if(top.childrenCount == 2)
                stack.pop();
            if(!values[i].equals("#")) {
                stack.push(new Node(values[i]));
            }
        }

        return stack.size() == 0;
    }
}
