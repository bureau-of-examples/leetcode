package zhy2002.leetcode.solutions.rotateimage;

/**
 * https://leetcode.com/problems/rotate-image/
 * Rotate layer by layer, element by element.
 */
public class Solution {

    public void rotate(int[][] matrix) {

        if (matrix == null)
            return;

        int layer = 0;
        while (layer < matrix.length / 2) {
            int layerLen = matrix.length - 1 - (layer << 1);
            int layerEnd = layer + layerLen;
            for (int i = 0; i < layerLen; i++) {

                int temp = matrix[layer][layer + i];
                matrix[layer][layer + i] = matrix[layerEnd - i][layer];
                matrix[layerEnd - i][layer] = matrix[layerEnd][layerEnd - i];
                matrix[layerEnd][layerEnd - i] = matrix[layer + i][layerEnd];
                matrix[layer + i][layerEnd] = temp;
            }
            layer++;
        }
    }
}
