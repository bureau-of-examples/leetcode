package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.sqrtx.BinarySearchSolution;
import zhy2002.leetcode.solutions.sqrtx.NewtonianSolution;
import zhy2002.leetcode.solutions.sqrtx.Solution;

import static org.junit.Assert.*;

public class SqrtXTests {

    @Test
    public void binarySearchBasicTest() {
        basicTest(new BinarySearchSolution());
    }

    @Test
    public void newtonianBasicTest() {
        basicTest(new NewtonianSolution());
    }

    private void basicTest(Solution solution) {
        for (int i = 0; i < 17; i++)
            assertEquals((int) Math.sqrt(i), solution.sqrt(i), 0.000001);

        assertEquals((int) Math.sqrt(2147395599), solution.sqrt(2147395599), 0.000001);
        assertEquals((int) Math.sqrt(2147395600), solution.sqrt(2147395600), 0.000001);
        assertEquals((int) Math.sqrt(822779234), solution.sqrt(822779234), 0.000001);
        assertEquals((int) Math.sqrt(1579205274), solution.sqrt(1579205274), 0.000001);
    }
}
