package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.romantointeger.Solution;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RomanToIntegerTests {

    private class Solution2 {
        private Map<Character, Integer> values = new HashMap<>();

        Solution2() {
            values.put('I', 1);
            values.put('V', 5);
            values.put('X', 10);
            values.put('L', 50);
            values.put('C', 100);
            values.put('D', 500);
            values.put('M', 1000);
        }


        private int romanToInt(String str) {
            int result = 0;
            for (int i=0; i<str.length(); i++) {
                int val = values.get(str.charAt(i));
                result += val;
                if (i > 0) {
                    int prevVal = values.get(str.charAt(i - 1));
                    if (prevVal < val) {
                        result -= prevVal * 2;
                    }
                }
            }
            return result;
        }
    }


    @Test
    public void basicTest(){
        Solution2 solution = new Solution2();
        assertEquals(1, solution.romanToInt("I"));
        assertEquals(2, solution.romanToInt("II"));
        assertEquals(3, solution.romanToInt("III"));
        assertEquals(4, solution.romanToInt("IV"));
        assertEquals(5, solution.romanToInt("V"));
        assertEquals(6, solution.romanToInt("VI"));
        assertEquals(7, solution.romanToInt("VII"));
        assertEquals(8, solution.romanToInt("VIII"));
        assertEquals(9, solution.romanToInt("IX"));
        assertEquals(10, solution.romanToInt("X"));
        assertEquals(11, solution.romanToInt("XI"));
        assertEquals(12, solution.romanToInt("XII"));
        assertEquals(2012, solution.romanToInt("MMXII"));
        assertEquals(2412, solution.romanToInt("MMCDXII"));
        assertEquals(1954, solution.romanToInt("MCMLIV"));




    }
}
