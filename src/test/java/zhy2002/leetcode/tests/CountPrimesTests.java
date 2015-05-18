package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.countprimes.Solution;
import static org.junit.Assert.*;

public class CountPrimesTests {

    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(0, solution.countPrimes(2));
        assertEquals(1, solution.countPrimes(3));
        assertEquals(4, solution.countPrimes(10));
        assertEquals(8, solution.countPrimes(20));
        assertEquals(168, solution.countPrimes(1000));
        assertEquals(78497, solution.countPrimes(999983));
    }
}
