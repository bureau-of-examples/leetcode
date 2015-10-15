package zhy2002.leetcode.solutions.theskylineproblem;


import java.util.ArrayList;
import java.util.List;

/**
 * Divide and Conquer solution.
 * Convert left half to skyline, and convert the right half to skyline. Then merge them together in O(n).
 */
public class DncSolution implements Solution{

    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static final int BUILDING_HEIGHT = 2;
    private static final int LINE_HEIGHT = 1;

    public List<int[]> getSkyline(int[][] buildings) {

        if (buildings.length == 0)
            return new ArrayList<>();

        return solve(buildings, 0, buildings.length - 1);
    }

    private List<int[]> solve(int[][] buildings, int left, int right) {

        if (left > right)
            return null;

        List<int[]> result = new ArrayList<>();
        if (left == right) {
            int[] building = buildings[left];
            result.add(new int[]{building[LEFT], building[BUILDING_HEIGHT]});
            result.add(new int[]{building[RIGHT], 0});
            return result;
        }

        int mid = (left + right) >>> 1;
        List<int[]> leftResult = solve(buildings, left, mid);
        List<int[]> rightResult = solve(buildings, mid + 1, right);

        return merge(leftResult, rightResult);
    }

    private List<int[]> merge(List<int[]> leftResult, List<int[]> rightResult) {

        List<int[]> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;
        int leftHeight = 0, rightHeight = 0;

        while (true) {
            if (leftIndex < leftResult.size()) {
                if (rightIndex < rightResult.size()) {
                    int[] leftPoint = leftResult.get(leftIndex);
                    int[] rightPoint = rightResult.get(rightIndex);

                    boolean useLeft; //add the left point or the right
                    if (leftPoint[LEFT] < rightPoint[LEFT]) {
                        useLeft = true;
                        leftIndex++;
                        leftHeight = leftPoint[LINE_HEIGHT];
                    } else if (leftPoint[LEFT] > rightPoint[LEFT]) {
                        useLeft = false;
                        rightIndex++;
                        rightHeight = rightPoint[LINE_HEIGHT];
                    } else {
                        useLeft = leftPoint[LINE_HEIGHT] >= rightPoint[LINE_HEIGHT];
                        leftIndex++;
                        rightIndex++;
                        leftHeight = leftPoint[LINE_HEIGHT];
                        rightHeight = rightPoint[LINE_HEIGHT];
                    }

                    if (useLeft) {
                        if (leftPoint[LINE_HEIGHT] > rightHeight) {
                            addPoint(result, leftPoint);
                        } else {
                            addPoint(result, new int[]{leftPoint[LEFT], rightHeight});
                        }
                    } else {
                        if (rightPoint[LINE_HEIGHT] > leftHeight) {
                            addPoint(result, rightPoint);
                        } else {
                            addPoint(result, new int[]{rightPoint[LEFT], leftHeight});
                        }
                    }
                } else {
                    result.add(leftResult.get(leftIndex++));
                }

            } else {
                if (rightIndex < rightResult.size()) {
                    result.add(rightResult.get(rightIndex++));
                } else {
                    break;
                }
            }
        }

        return result;
    }

    private void addPoint(List<int[]> result, int[] point) {
        if (result.size() == 0 || result.get(result.size() - 1)[LINE_HEIGHT] != point[LINE_HEIGHT]) {
            result.add(point);
        }
    }
}
