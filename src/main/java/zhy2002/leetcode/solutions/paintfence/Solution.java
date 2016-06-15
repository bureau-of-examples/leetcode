package zhy2002.leetcode.solutions.paintfence;

/**
 * https://leetcode.com/problems/paint-fence/
 * <p>
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * <p>
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * <p>
 * Return the total number of ways you can paint the fence.
 * <p>
 * Note:
 * n and k are non-negative integers.
 */
public class Solution {

    public int numWays(int n, int k) {
        if (n == 0 || k == 0)
            return 0;
        int sameCount = 0; //number of ways to paint to the ith post where i and i-1 have the same color.
        int diffCount = k; //number of ways to paint to the ith post where i and i-1 have different color.

        for (int i = 1; i < n; i++) {
            int sameCountDiff = sameCount * (k - 1);
            int diffCountSame = diffCount;
            int diffCountDiff = diffCount * (k - 1);

            sameCount = diffCountSame;
            diffCount = sameCountDiff + diffCountDiff;
        }

        return sameCount + diffCount;
    }
}
