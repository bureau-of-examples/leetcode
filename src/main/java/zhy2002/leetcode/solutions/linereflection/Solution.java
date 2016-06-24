package zhy2002.leetcode.solutions.linereflection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.
 * <p>
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 * <p>
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 */
public class Solution {

    //Note: there is a O(n) solution with HashMap
    public boolean isReflected(int[][] points) {

        if (points.length == 0)
            return true;

        //sort first by y then by x.
        List<int[]> sorted = Arrays.stream(points).sorted((a, b) -> {
            int result = a[1] - b[1];
            if (result == 0) {
                result = a[0] - b[0];
            }
            return result;
        }).collect(Collectors.toList());

        //get the only possible middle value of x
        int previousY = sorted.get(0)[1];
        double middle = Double.NaN;
        for (int end = 1; end <= sorted.size(); end++) {
            if (end == sorted.size() || previousY != sorted.get(end)[1]) {
                middle = ((double) sorted.get(0)[0] + sorted.get(end - 1)[0]) / 2.0; //no rounding error
                break;
            }
        }
        assert !Double.isNaN(middle);

        //verify the all points
        previousY = sorted.get(0)[1];
        double sum = middle - sorted.get(0)[0];
        for (int end = 1; end <= sorted.size(); end++) {
            if (end == sorted.size() || previousY != sorted.get(end)[1]) {
                if (sum != 0)
                    return false;
                if(end < sorted.size())
                    previousY = sorted.get(end)[1];
            }
            if(end < sorted.size())
                sum += middle - sorted.get(end)[0]; //no rounding error
        }
        return true;
    }
}
