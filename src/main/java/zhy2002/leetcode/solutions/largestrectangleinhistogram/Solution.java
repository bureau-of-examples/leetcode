package zhy2002.leetcode.solutions.largestrectangleinhistogram;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class Solution {

    public int largestRectangleArea(int[] height) {

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();//stack of bar index
        for(int i=0; i<=height.length; i++){

            if(i< height.length && (stack.isEmpty() || height[i] >= height[stack.peek()]))
                stack.push(i);
            else{
                if(stack.isEmpty())
                    break;
                int leftRectHeight = height[stack.pop()];
                int leftRectWidth = stack.isEmpty() ? i : i - stack.peek() - 1;
                int leftRectArea = leftRectHeight * leftRectWidth;
                if(leftRectArea > maxArea)
                    maxArea = leftRectArea;
                i--;//one more round
            }
        }
        return maxArea;
    }
}
