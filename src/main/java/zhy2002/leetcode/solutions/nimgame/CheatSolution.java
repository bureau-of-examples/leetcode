package zhy2002.leetcode.solutions.nimgame;


/**
 * The result has a pattern.
 */
public class CheatSolution implements Solution {

    public boolean canWinNim(int n){
        return n % 4 != 0;
    }
}
