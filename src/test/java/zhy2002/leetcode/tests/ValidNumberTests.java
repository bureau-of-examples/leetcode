package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.validnumber.ReferenceSolution;
import zhy2002.leetcode.solutions.validnumber.Solution;
import zhy2002.leetcode.solutions.validnumber.StateSolution;

import static org.junit.Assert.*;


public class ValidNumberTests {

    @Test
    public void comparisonTest() {
        ReferenceSolution referenceSolution = new ReferenceSolution();
        StateSolution stateSolution = new StateSolution();

        assertEquals(false, stateSolution.isNumber(""));
        assertEquals(false, referenceSolution.isNumber(""));

        assertEquals(true, stateSolution.isNumber("1"));
        assertEquals(true, referenceSolution.isNumber("1"));

        assertEquals(true, stateSolution.isNumber("01"));
        assertEquals(true, referenceSolution.isNumber("01"));

        assertEquals(true, stateSolution.isNumber("10e01"));
        assertEquals(false, referenceSolution.isNumber("10e01"));

        assertEquals(true, stateSolution.isNumber("10e1"));
        assertEquals(false, referenceSolution.isNumber("10e1"));

        assertEquals(true, stateSolution.isNumber("10.5e1"));
        assertEquals(false, referenceSolution.isNumber("10.5e1"));

        assertEquals(false, stateSolution.isNumber("10.5e1.01"));//don't allow exponent to have a decimal part.
        assertEquals(false, referenceSolution.isNumber("10.5e1.01"));

        assertEquals(false, stateSolution.isNumber("10.5e-1.01"));
        assertEquals(false, referenceSolution.isNumber("10.5e-1.01"));

        assertEquals(false, stateSolution.isNumber("+10.5e-1.01"));
        assertEquals(false, referenceSolution.isNumber("+10.5e-1.01"));

        assertEquals(false, stateSolution.isNumber("+10.50e-1.01"));
        assertEquals(false, referenceSolution.isNumber("+10.50e-1.01"));

        assertEquals(false, stateSolution.isNumber("-0.01e-0.0015"));
        assertEquals(false, referenceSolution.isNumber("-0.01e-0.0015"));

        assertEquals(false, stateSolution.isNumber("e9"));
        assertEquals(false, referenceSolution.isNumber("e9"));

        assertEquals(false, stateSolution.isNumber("e.9"));
        assertEquals(false, referenceSolution.isNumber("e.9"));

        assertEquals(false, stateSolution.isNumber(".8e.9"));
        assertEquals(false, referenceSolution.isNumber(".8e.9"));

        assertEquals(true, stateSolution.isNumber("3."));
        assertEquals(true, referenceSolution.isNumber("3."));

        assertEquals(false, stateSolution.isNumber("."));
        assertEquals(false, referenceSolution.isNumber("."));

        assertEquals(true, stateSolution.isNumber("46.e3"));
        assertEquals(false, referenceSolution.isNumber("46.e3"));

        assertEquals(false, stateSolution.isNumber("6e6.5"));
        assertEquals(false, referenceSolution.isNumber("6e6.5"));

        assertEquals(true, stateSolution.isNumber("6e-5"));
        assertEquals(false, referenceSolution.isNumber("6e-5"));

    }
}
