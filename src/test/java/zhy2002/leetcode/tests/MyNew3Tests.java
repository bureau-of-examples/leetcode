package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/#/description
 */
public class MyNew3Tests {

    @Test
    public void test() {
        assertThat(solve(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10}), equalTo(9));
        assertThat(solve(new int[]{1, 2, 3, 5}), equalTo(4));
    }

    private static int solve(int[] array) {
        int index = 0;
        while (index < array.length) {
            if (array[index] == index + 1) {
                index++;
            } else if (array[index] <= array.length) {
                swap(array, index, array[index] - 1);
            } else {
                index++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != i + 1)
                return i + 1;
        }
        throw new RuntimeException("Not found");
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
