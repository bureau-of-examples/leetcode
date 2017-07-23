package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class LargestRectangleInHistogram2Tests {

    @Test
    public void testSolve2() {
        System.out.println(solve2(new int[]{65, 30, 7, 90, 1, 9, 8}));
    }

    private static int solve2(int[] array) {
        Set<Integer> pairs = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int pair = array[i] + array[j];
                if (pairs.contains(pair))
                    return 1;
                pairs.add(pair);
            }
        }
        return 0;
    }

    @Test
    public void testSolve() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(solve(i));
        }
    }

    private static String solve(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        for (int i = 1; i < n; i++) {
            int count = queue.size();
            int currentNumber = -1;
            int currentCount = 0;
            for (int j = 0; j <= count; j++) {
                int value = -1;
                if (j < count) {
                    value = queue.poll();
                }
                if (currentCount > 0 && value != currentNumber) {
                    queue.add(currentCount);
                    queue.add(currentNumber);
                    currentCount = 0;
                }
                if (value == currentNumber || currentCount == 0) {
                    currentNumber = value;
                    currentCount++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.largestRectangleArea(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 2147483647}),
                equalTo(2147483647)
        );
        assertThat(
                solution.largestRectangleArea(new int[]{0, 1, 0, 1}),
                equalTo(1)
        );
        assertThat(
                solution.largestRectangleArea(new int[]{6, 2, 5, 15, 8, 12, 4, 5, 1, 6}),
                equalTo(24)
        );
    }

    public class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> heightStack = new Stack<>();
            Stack<Integer> indexStack = new Stack<>();
            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                int num = heights[i];
                if (heightStack.isEmpty() || num > heightStack.peek()) {
                    heightStack.push(num);
                    indexStack.push(i);
                } else if (num <= heightStack.peek()) {
                    while (!heightStack.isEmpty() && num <= heightStack.peek()) {
                        int height = heightStack.pop();
                        indexStack.pop();
                        int right = i - 1;
                        int left = indexStack.isEmpty() ? 0 : (indexStack.peek() + 1);
                        int area = height * (right - left + 1);
                        maxArea = Math.max(maxArea, area);
                    }
                    if (heightStack.isEmpty() || num > heightStack.peek()) {
                        heightStack.push(num);
                        indexStack.push(i);
                    }
                }
            }

            while (!heightStack.isEmpty()) {
                int height = heightStack.pop();
                indexStack.pop();
                int right = heights.length - 1;
                int left = indexStack.isEmpty() ? 0 : indexStack.peek() + 1;
                int area = height * (right - left + 1);
                maxArea = Math.max(maxArea, area);
            }

            return maxArea;
        }
    }


}
