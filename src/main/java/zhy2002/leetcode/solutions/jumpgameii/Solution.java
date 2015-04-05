package zhy2002.leetcode.solutions.jumpgameii;

/**
 * https://leetcode.com/problemset/algorithms/
 */
public class Solution {

    //The list is partitioned into regions by the min steps to reach them: [0 step region] [1 step region] [2 step region] ...
    public int jump(int[] A) {
        if (A.length == 0)
            return -1;

        int minJump = 0;
        int minJumpReach = 0;
        int minJumpNextReach = A[0]; //how far we can reach in minStep + 1 steps.

        for (int i = 1; i < A.length; i++) {
            if (minJumpReach >= A.length - 1)
                break;
            if (i <= minJumpReach) {
                minJumpNextReach = Math.max(minJumpNextReach, i + A[i]);
            } else if (i <= minJumpNextReach) {
                minJump++;
                minJumpReach = minJumpNextReach;
                minJumpNextReach = Math.max(minJumpNextReach, i + A[i]);
            } else {
                return -1;
            }
        }
        return minJump;
    }

}
