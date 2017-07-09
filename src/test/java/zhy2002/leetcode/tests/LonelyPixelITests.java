package zhy2002.leetcode.tests;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/lonely-pixel-i/#/description
 */
public class LonelyPixelITests {

    @Test
    public void test() {
        assertThat(true, equalTo(true));
    }

    public class Solution {
        public int findLonelyPixel(char[][] picture) {
            int rowCount = picture.length;
            int colCount = picture[0].length;
            int[] rowBlackCount = new int[rowCount];
            int[] colBlackCount = new int[colCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    if (picture[i][j] == 'B') {
                        rowBlackCount[i]++;
                        colBlackCount[j]++;
                    }
                }
            }

            int loneCount = 0;
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    if (picture[i][j] == 'B') {
                        if (rowBlackCount[i] == 1 && colBlackCount[j] == 1) {
                            loneCount++;
                        }
                    }
                }
            }
            return loneCount;
        }
    }

}
