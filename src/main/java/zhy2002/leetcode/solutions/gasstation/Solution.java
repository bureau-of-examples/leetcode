package zhy2002.leetcode.solutions.gasstation;

/**
 * https://oj.leetcode.com/problems/gas-station/
 * From station 0, do the sum, if get negative number at i, then it means from station 0 we cannot reach station i, thus cannot complete a loop.
 * It also means stations in the range [0, i) cannot reach i because for any j in this range:
 * the car goes into j with leftOver >= 0, but at i we get negative. So j sucks too.
 * The next possible index become i + 1.
 */
public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || gas.length != cost.length)
            throw new IllegalArgumentException();

        int startIndex = 0;
        int total = 0;
        int leftOver = 0;
        for(int i=0; i<gas.length; i++){
            int surplus = gas[i] - cost[i];
            leftOver += surplus;
            total += surplus;
            if(leftOver < 0){
                leftOver = 0;
                startIndex = i + 1;
            }
        }
        return (startIndex == gas.length || total < 0) ? -1 : startIndex;
    }
}
