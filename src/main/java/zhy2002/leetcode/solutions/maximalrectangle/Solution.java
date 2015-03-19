package zhy2002.leetcode.solutions.maximalrectangle;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;

        int maxSize = 0;
        int[] histogram = new int[matrix[0].length];
        Stack<Integer> stack = new Stack<>();
        for (char[] row : matrix) {
            for (int j = 0; j <= row.length; j++) {
                //calculate bar height
                int height;
                if (j < row.length) {
                    if (row[j] == '1') {
                        histogram[j]++;
                    } else {
                        histogram[j] = 0;
                    }
                    height = histogram[j];
                } else {
                    height = -1;//signal for the last one
                }

                if (stack.isEmpty()) {
                    stack.push(j);
                } else {
                    if (height == 0 && histogram[stack.peek()] == 0) {
                        stack.pop();
                        stack.push(j);
                    } else {
                        if (height >= histogram[stack.peek()]) {
                            stack.push(j);
                        } else {
                            do {
                                int roofHeight = histogram[stack.pop()];
                                int width = stack.isEmpty() ? j : j - stack.peek() - 1;
                                int size = roofHeight * width;
                                if (size > maxSize)
                                    maxSize = size;
                            } while (!stack.isEmpty() && height < histogram[stack.peek()]);
                            if (height != -1) {
                                stack.push(j);
                            }
                        }
                    }
                }
            }
        }

        return maxSize;
    }
}
