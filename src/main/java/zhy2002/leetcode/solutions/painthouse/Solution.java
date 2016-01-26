package zhy2002.leetcode.solutions.painthouse;

/**
 * https://leetcode.com/problems/paint-house/
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 * <p>
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 * <p>
 * Note:
 * All costs are positive integers.
 */
public class Solution {

    //dynamic programming
    public int minCost(int[][] costs) {
        int[][] minCosts = new int[costs.length + 1][3]; //minCosts[i][j] is the min cost of painting from house i and choose color j
        for (int i = costs.length - 1; i >= 0; i--) {

            for (int j = 0; j < 3; j++) {
                minCosts[i][j] = costs[i][j] + Math.min(minCosts[i + 1][(j + 1) % 3], minCosts[i + 1][(j + 2) % 3]);
            }
        }
        return Math.min(minCosts[0][0], Math.min(minCosts[0][1], minCosts[0][2]));
    }

}
