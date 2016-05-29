package zhy2002.leetcode.solutions.bestmeetingpoint;

/**
 * A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 * For example, given three people living at (0,0), (0,4), and (2,2):
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 */
public class Solution {

    public int minTotalDistance(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        int[] countToTheLeft = new int[colCount];
        int[] countToTheTop = new int[rowCount];
        int distTo00 = 0;
        int total = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 1) {
                    countToTheTop[i]++;
                    countToTheLeft[j]++;
                    distTo00 += i + j;
                    total++;
                }
            }
        }

        for (int i = 1; i < countToTheTop.length; i++) {
            countToTheTop[i] += countToTheTop[i - 1];
        }
        for (int j = 1; j < countToTheLeft.length; j++) {
            countToTheLeft[j] += countToTheLeft[j - 1];
        }

        int minDist = Integer.MAX_VALUE;
        int currentDist = distTo00;
        boolean flip = false;
        int i = 0, j = 0;
        while (i < rowCount) {

            while (j >= 0 && j < colCount) {

                if (flip) {
                    if (j < colCount - 1) {
                        currentDist += (total - countToTheLeft[j]) - countToTheLeft[j];
                    }
                } else {
                    if (j > 0) {
                        currentDist += countToTheLeft[j - 1] - (total - countToTheLeft[j - 1]);
                    }
                }

                if (/*grid[i][j] == 0 &&*/ currentDist < minDist) {
                    minDist = currentDist;
                }

                if (flip) {
                    j--;
                } else {
                    j++;
                }
            }
            flip = !flip;
            i++;
            j = flip ? colCount - 1 : 0;
            currentDist += countToTheTop[i - 1] - (total - countToTheTop[i - 1]);
        }

        return minDist;
    }
}
