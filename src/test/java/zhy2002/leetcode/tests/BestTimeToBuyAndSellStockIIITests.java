package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.besttimetobuyandsellstockiii.Solution;
import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockIIITests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(0, solution.maxProfit(new int[]{}));
        assertEquals(0, solution.maxProfit(new int[]{15}));
        assertEquals(1, solution.maxProfit(new int[]{15,16}));
        assertEquals(3, solution.maxProfit(new int[]{15,16,18}));
        assertEquals(4, solution.maxProfit(new int[]{15,16,18,12,13}));
        assertEquals(0, solution.maxProfit(new int[]{15,14,13,12,11,11,10}));
        assertEquals(17, solution.maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0,9}));
        assertEquals(12, solution.maxProfit(new int[]{4,7,2,11,1}));
        assertEquals(15, solution.maxProfit(new int[]{3,4,6,0,3,7,5,8,2,9,1,6,6,2}));
    }
}
