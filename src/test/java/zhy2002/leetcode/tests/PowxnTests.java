package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.Utils;
import zhy2002.leetcode.solutions.powxn.Solution;

import java.util.Random;

import static org.junit.Assert.*;

public class PowxnTests {

    private static final double EPSILON = 0.000000001;
    @Test
    public void randomTest(){
        Solution solution = new Solution();
        Random rand = Utils.random();

        for(int i=0; i<100; i++){
            double p = rand.nextDouble();
            int n = rand.nextInt();
            assertEquals(Math.pow(p,n), solution.pow(p,n), EPSILON);
        }
    }


    @Test
    public void basicTest(){
        Solution solution = new Solution();
        assertEquals(1.0, solution.pow(55,0), EPSILON);
        assertEquals(2, solution.pow(0.5,-1), EPSILON);
        assertEquals(0.25, solution.pow(2,-2), EPSILON);
        assertEquals(Double.POSITIVE_INFINITY, solution.pow(1.000001,Integer.MAX_VALUE), EPSILON);
    }
}
