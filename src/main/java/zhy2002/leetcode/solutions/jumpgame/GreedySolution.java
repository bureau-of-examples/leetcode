package zhy2002.leetcode.solutions.jumpgame;

/**
 * At each step, we calculate the furthest reach (jumpEnd).
 * If current tile is beyond jumpEnd, return false.
 */
public class GreedySolution implements Solution{

    @Override
    public boolean canJump(int[] A) {

        int jumpEnd = 0;
        for (int i = 0; i < A.length && i <= jumpEnd; i++) {
            jumpEnd = Math.max(jumpEnd, i + A[i]);
            if (jumpEnd >= A.length - 1)
                return true;
        }
        return false;
    }
}
