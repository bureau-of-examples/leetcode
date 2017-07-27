package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/#/description
 */
public class KthSmallestElementInASortedMatrixTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(
                solution.kthSmallest(new int[][]{{-5}}, 1),
                equalTo(-5)
        );
        assertThat(
                solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8),
                equalTo(13)
        );
        assertThat(
                solution.kthSmallest(new int[][]{{1, 3, 5}, {6, 7, 12}, {11, 14, 14}}, 5),
                equalTo(7)
        );
    }

    public class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int start = matrix[0][0], end = matrix[n-1][n-1];
            while(start <= end) {
                int mid = start + (end - start) / 2;
                int leCount = getLessOrEqual(matrix, mid);
                if (leCount < k) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return start;
        }

        private int getLessOrEqual(int[][] matrix, int target) {
            int n = matrix.length;
            int count = 0;
            int i = n - 1, j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] <= target) {
                    count += i + 1;
                    j++;
                } else {
                    i--;
                }
            }
            return count;
        }
    }
}
