package zhy2002.leetcode.solutions.verifypreordersequenceinbst;

import java.util.Stack;

/**
 * https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * <p>
 * You may assume each number in the sequence is unique.
 * <p>
 * Follow up:
 * Could you do it using only constant space complexity?
 */
public class Solution {

    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int leftBound = Integer.MIN_VALUE;
        for(int val : preorder){
            if(val < leftBound){
                return false;
            }
            while (!stack.isEmpty() && val > stack.peek()){
                leftBound = stack.pop();
            }
            stack.push(val);
        }
        return true;
    }
}
