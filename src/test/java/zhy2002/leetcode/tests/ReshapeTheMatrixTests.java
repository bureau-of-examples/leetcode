package zhy2002.leetcode.tests;

import org.junit.Test;

/**
 * https://leetcode.com/problems/reshape-the-matrix/#/description
 */
public class ReshapeTheMatrixTests {

    @Test
    public void test() {
        Solution solution = new Solution();

        solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
    }

    public class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int or = nums.length;
            if (or == 0)
                return nums;

            int oc = nums[0].length;
            if (or * oc != r * c)
                return nums;

            int[][] result = new int[r][c];
            int orIndex = 0, ocIndex = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    result[i][j] = nums[orIndex][ocIndex];
                    ocIndex++;
                    if (ocIndex == oc) {
                        ocIndex = 0;
                        orIndex++;
                    }
                }
            }

            return result;
        }
    }
}
