package zhy2002.leetcode.solutions.caniwin;


import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Integer, Boolean> cache;
    private int maxChoosableInteger;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal)
            return false;

        cache = new HashMap<>();
        this.maxChoosableInteger = maxChoosableInteger;
        return find(0, desiredTotal);
    }

    private boolean find(int taken, int desiredTotal) {
        Boolean result = cache.get(taken);
        if (result == null) {
            result = Boolean.FALSE;
            for (int i=0; i<maxChoosableInteger; i++) {
                if ((taken & (1 << i)) != 0) {
                    continue;
                }
                if (i + 1 >= desiredTotal || !find(taken | (1 << i), desiredTotal - i - 1)) {
                    result = true;
                    break;
                }
            }
            cache.put(taken, result);
        }
        return result;
    }
}
