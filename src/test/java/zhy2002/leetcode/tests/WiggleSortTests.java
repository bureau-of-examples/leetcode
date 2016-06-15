package zhy2002.leetcode.tests;

import org.junit.Test;
import zhy2002.leetcode.solutions.wigglesort.Solution;

public class WiggleSortTests {

    @Test
    public void basicTest() {

        Solution solution = new Solution();

        int[] input = new int[]{};
        solution.wiggleSort(input);
        verify(input);

        input = new int[]{3};
        solution.wiggleSort(input);
        verify(input);

        input = new int[]{3, 2};
        solution.wiggleSort(input);
        verify(input);

        input = new int[]{2, 3};
        solution.wiggleSort(input);
        verify(input);

        input = new int[]{1, 2, 3};
        solution.wiggleSort(input);
        verify(input);

        input = new int[]{1, 2, 3, 4};
        solution.wiggleSort(input);
        verify(input);

        input = new int[]{3, 1, 4, 5, 2, 7};
        solution.wiggleSort(input);
        verify(input);

    }

    private void verify(int[] input) {
        boolean asc = true;
        for (int i = 1; i < input.length; i++) {
            if (asc ? input[i - 1] > input[i] : input[i - 1] < input[i]) {
                throw new RuntimeException("Invalid order");
            }

            asc = !asc;
        }
    }


}
