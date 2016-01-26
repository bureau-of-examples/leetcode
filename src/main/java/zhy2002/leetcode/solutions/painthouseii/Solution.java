package zhy2002.leetcode.solutions.painthouseii;


/**
 * https://leetcode.com/problems/paint-house-ii/
 *
 * There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Follow up:
 * Could you solve it in O(nk) runtime?
 */
public class Solution {

    //use dp[i][j] - the minimum cost when paint starting house i with color j.
    public int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0)
            return 0;

        int k = costs[0].length;

        int[][] dp = new int[n + 1][k];
        int[] minWithout = new int[k];
        for(int i=n-1; i>= 0; i--){
            if(i < n - 1){
                calculateMinWithout(minWithout, dp[i+1]);
            }

            for(int j=0; j<k; j++){
                dp[i][j] = costs[i][j] + minWithout[j];
            }
        }

        int minCost = Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            if(dp[0][i] < minCost) {
                minCost = dp[0][i];
            }
        }
        return minCost;
    }

    //minWithout[j] is the min element in  [start...j) (j...end]
    private void calculateMinWithout(int[] minWithout, int[] costs) {
        int minIndex = 0, minIndex2 = -1;
        for(int j=1; j<costs.length; j++) {
            if(costs[j] <= costs[minIndex]) {
                minIndex2 = minIndex;
                minIndex = j;
            } else if(minIndex2 == -1 || costs[j] < costs[minIndex2]) {
                minIndex2 = j;
            }
        }

        for(int j=0; j<minWithout.length; j++){
            if(j == minIndex) {
                minWithout[j] = costs[minIndex2];
            } else {
                minWithout[j] = costs[minIndex];
            }
        }
    }
}
