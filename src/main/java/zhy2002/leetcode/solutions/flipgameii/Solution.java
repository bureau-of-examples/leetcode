package zhy2002.leetcode.solutions.flipgameii;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/flip-game-ii/
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to determine if the starting player can guarantee a win.
 *
 * For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 *
 * Follow up:
 * Derive your algorithm's runtime complexity.
 */
public class Solution {

    private HashMap<String, Boolean> solutionCache = new HashMap<>(); //state -> if player1 has a winning strategy

    //In this game at each state either player 1 can always win or player 2 can always win.
    public boolean canWin(String s) {
        solutionCache.clear();
        return calcWithCache(s.toCharArray());
    }

    private boolean calcWithCache(char[] state){
        for(int i=1; i<state.length; i++){  //calculate all possible moves
            if(state[i-1] == '+' && state[i] == '+'){ //make move
                state[i-1] = '-';
                state[i] = '-';

                String stateString = new String(state);
                Boolean cachedResult = solutionCache.get(stateString);
                boolean otherCanWin = cachedResult == null ? calcWithCache(state) : cachedResult;

                state[i-1] = '+'; //restore state
                state[i] = '+';

                if(cachedResult == null){
                    solutionCache.put(stateString, otherCanWin);
                }
                if(!otherCanWin)  //if there is a move which causes other cannot always win then this player can always win.
                    return true;
            }
        }

        return false;
    }
}
