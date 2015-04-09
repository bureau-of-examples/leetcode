package zhy2002.leetcode.solutions.sortcolors;

import java.util.Arrays;

/**
 * This solution is similar to insertion sort:
 * 0 0 0 0 1 1 1 1 2 2 2 [0]
 * We want to insert 0 into the sorted list - to do this we maintain an array of boundaries:
 * boundary[i] - A[0 ~ boundary[i]] contains the sorted list of color 0 to i.
 * E.g. in the example above boundary[0] = 3, boundary[1] = 7, boundary[2] = 10
 * To insert value 0, we swap it with the first 2:
 *
 * Then we swap it with the first 1:
 * 0 0 0 0 [0] 1 1 1 1  2 2 2
 * Now its the same color as the current section color, we stop.
 */
public class InsertionSolution implements Solution {

    @Override
    public void sortColors(int[] A) {
        sortColors(A, 3);
    }

    private void sortColors(int[] A, int n) {
        int[] boundary = new int[n];
        Arrays.fill(boundary, -1);

        for (int color : A) {
            for (int i = n - 1; i >= 0; i--) {
                if (color > i)
                    throw new RuntimeException("Assertion failed.");
                if (color < i) {//swap boundary[i]+1 and boundary[i-1]+1
                    int temp = A[boundary[i] + 1];
                    A[boundary[i] + 1] = A[boundary[i - 1] + 1];
                    A[boundary[i - 1] + 1] = temp;
                    boundary[i]++;
                } else {
                    boundary[i]++;
                    break;
                }

            }
        }
    }
}
