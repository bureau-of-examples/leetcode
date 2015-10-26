package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.productofarrayexceptself.BufferSolution;
import zhy2002.leetcode.solutions.productofarrayexceptself.NoBufferSolution;
import zhy2002.leetcode.solutions.productofarrayexceptself.Solution;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProductOfArrayExceptSelfTests {


    @Test
    public void bufferTest() {
        basicTest(new BufferSolution());
    }

    @Test
    public void noBufferTest() {

        basicTest(new NoBufferSolution());
    }

    private void basicTest(Solution solution) {

        int[] result = solution.productExceptSelf(new int[]{1, 2});
        assertThat(result, equalTo(new int[]{2, 1}));

        result = solution.productExceptSelf(new int[]{1,2,3,4});
        assertThat(result, equalTo(new int[]{24,12,8,6}));

        result = solution.productExceptSelf(new int[]{5,7,3});
        assertThat(result, equalTo(new int[]{21,15,35}));
    }




}
