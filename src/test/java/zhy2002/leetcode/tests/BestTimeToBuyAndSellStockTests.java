package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.besttimetobuyandsellstock.Solution;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockTests {

    @Test
    public void basicTest() {
        Solution solution = new Solution();
        assertEquals(0, solution.maxProfit(new int[]{3}));
        assertEquals(1, solution.maxProfit(new int[]{3, 4}));
        assertEquals(2, solution.maxProfit(new int[]{3, 4, 5}));
        assertEquals(0, solution.maxProfit(new int[]{5, 4, 3}));
        assertEquals(3, solution.maxProfit(new int[]{5, 4, 3, 6}));
        assertEquals(6, solution.maxProfit(new int[]{5, 4, 3, 6, 5, 9}));
        assertEquals(1, solution.maxProfit(new int[]{9, 8, 7, 6, 7, 4, 2}));

    }
}
