package zhy2002.leetcode.solutions.selfcrossing;

/**
 * https://leetcode.com/problems/self-crossing/
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise.
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 * <p>
 * Example 1:
 * Given x = [2, 1, 1, 2],
 * ┌───┐
 * │      │
 * └───┼──>
 * │
 * <p>
 * Return true (self crossing)s
 */
public class Solution {

    private boolean checkShrinkOnly(int[] x, int startIndex) {
        for (int i = startIndex; i < x.length; i++) {
            if (x[i] >= x[i - 2])
                return true;
        }
        return false;
    }

    //note: I implemented this clockwise - the question is asking counter-clockwise; but this problems is symmetric.
    public boolean isSelfCrossing(int[] x) {
        if (x.length <= 3)
            return false;

        if (x[2] <= x[0]) { //shrink only case
            return checkShrinkOnly(x, 3);
        } else if (x.length >= 5) {
            if (x[1] == x[3] && x[0] + x[4] >= x[2]) //5th segment pass origin
                return true;
            if (x[3] <= x[1]) {
                return checkShrinkOnly(x, 4);
            } else { //grow then shrink case
                for (int i = 5; i < x.length; i++) {
                    if (x[i - 1] <= x[i - 3]) {
                        if (x[i] >= x[i - 2] - x[i - 4] && x[i - 1] >= x[i - 3] - x[i - 5]) {
                            return true;
                        } else {
                            return checkShrinkOnly(x, i + 1);
                        }
                    }
                }
            }
        }

        return false;
    }
}
