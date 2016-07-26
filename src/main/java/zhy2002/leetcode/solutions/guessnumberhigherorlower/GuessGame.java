package zhy2002.leetcode.solutions.guessnumberhigherorlower;

/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 */
public abstract class GuessGame {

    private int target;

    public void setTarget(int target) {
        this.target = target;
    }

    protected int guess(int num) {
        return target > num ? 1 : target < num ? -1 : 0;
    }
}
