package zhy2002.leetcode.solutions.smallestrectangleenclosingblackpixels;


/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 * <p>
 * For example, given the following image:
 * <p>
 * [
 * "0010",
 * "0110",
 * "0100"
 * ]
 * <p>
 * and x = 0, y = 2,
 * <p>
 * Return 6.
 */
public class Solution {

    public int minArea(char[][] image, int x, int y) {

        RowNotEmptyChecker rowNotEmptyChecker = new RowNotEmptyChecker();
        ColNotEmptyChecker colNotEmptyChecker = new ColNotEmptyChecker();

        int top = ascSearch(image, 0, x, rowNotEmptyChecker);
        int bottom = descSearch(image, x, image.length - 1, rowNotEmptyChecker);
        int left = ascSearch(image, 0, y, colNotEmptyChecker);
        int right = descSearch(image, y, image[0].length - 1, colNotEmptyChecker);

        return (right - left + 1) * (bottom - top + 1);
    }

    //empty = 0, notEmpty = 1, search for 0.5
    private int ascSearch(char[][] image, int start, int end, NotEmptyChecker checker) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (checker.isNotEmpty(image, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    //empty = 0, notEmpty = 1, search for 0.5
    private int descSearch(char[][] image, int start, int end, NotEmptyChecker checker) {
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (checker.isNotEmpty(image, mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    private interface NotEmptyChecker {
        boolean isNotEmpty(char[][] image, int rowOrCol);
    }

    private static class RowNotEmptyChecker implements NotEmptyChecker {
        @Override
        public boolean isNotEmpty(char[][] image, int x) {
            for (char ch : image[x]) {
                if (ch == '1')
                    return true;
            }
            return false;
        }
    }

    private static class ColNotEmptyChecker implements NotEmptyChecker {
        @Override
        public boolean isNotEmpty(char[][] image, int y) {
            for (char[] row : image) {
                if (row[y] == '1')
                    return true;
            }
            return false;
        }
    }
}
