package zhy2002.leetcode.solutions.nimgame;

import java.util.Arrays;

/**
 * Solve with dp:
 * this state (n) can win iff all opponent states cannot win.
 */
public class DpSolution implements Solution{

    private static final int MAX_REMOVE = 3;

    public boolean canWinNim(int n) {

        //trivial case
        if(n <= MAX_REMOVE){
            return true;
        }

        boolean[] buffer = new boolean[MAX_REMOVE]; //a cyclic queue
        Arrays.fill(buffer, true);

        int qHead = MAX_REMOVE - 1;
        for(int index = MAX_REMOVE; index < n; index++){

            boolean firstMoveWins = false;

            for(boolean b : buffer){ //if any of the opponent moves cannot win
                if(!b){
                    firstMoveWins = true;
                    break;
                }
            }

            qHead = (qHead + 1) % MAX_REMOVE;
            buffer[qHead] = firstMoveWins;
        }

        return buffer[qHead];

    }
}
