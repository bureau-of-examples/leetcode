package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/rotate-image/#/description
 */
public class RotateImage2Tests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            int layerCount = n / 2;
            for (int i = 0; i < layerCount; i++) {
                int top, right, bottom, left;
                top = left = i;
                bottom = right = n - i - 1;
                for (int j = 0; j < n - i * 2 - 1; j++) {
                    int temp = matrix[top][left + j];
                    matrix[top][left + j] = matrix[bottom - j][left];
                    matrix[bottom - j][left] = matrix[bottom][right - j];
                    matrix[bottom][right - j] = matrix[top + j][right];
                    matrix[top + j][right] = temp;
                }
            }
        }
    }

}
