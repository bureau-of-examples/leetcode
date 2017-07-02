package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * https://leetcode.com/problems/island-perimeter/#/description
 */
public class IslandPerimeterTests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int islandPerimeter(int[][] grid) {
            int cellCount = 0;
            int removed = 0;
            int r = grid.length, c = grid[0].length;
            for (int i=0; i<r; i++) {
                for (int j=0; j<c; j++) {
                    if (grid[i][j] == 1) {
                        cellCount++;

                        int neighbourR = i;
                        int neighbourC = j;

                        neighbourR -= 1;
                        if (neighbourR >= 0 && grid[neighbourR][neighbourC] == 1) {
                            removed++;
                        }
                        neighbourR += 2;
                        if (neighbourR < r && grid[neighbourR][neighbourC] == 1) {
                            removed++;
                        }
                        neighbourC -= 1;
                        if (neighbourC >= 0 && grid[neighbourR][neighbourC] == 1) {
                            removed++;
                        }
                        neighbourC += 2;
                        if (neighbourC < c && grid[neighbourR][neighbourC] == 1) {
                            removed++;
                        }
                    }
                }
            }
            return cellCount * 4 - removed;

        }
    }
}
