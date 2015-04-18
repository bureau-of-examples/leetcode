package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.besttimetobuyandsellstockii.Solution;
import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockIITests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(0, solution.maxProfit(new int[]{3,2,1}));
        assertEquals(7, solution.maxProfit(new int[]{10,8,15,9,2}));
        assertEquals(4, solution.maxProfit(new int[]{6,7,8,9,10}));
        assertEquals(4, solution.maxProfit(new int[]{4,3,2,1,2,3,4,5}));
        assertEquals(5, solution.maxProfit(new int[]{3,2,1,4,6}));
        assertEquals(9, solution.maxProfit(new int[]{6,5,7,3,9,2,3}));

    }
}
