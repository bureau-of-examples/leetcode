package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/lonely-pixel-ii/description/
 */
public class LonelyPixelIITests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.findBlackPixel(
                new char[][]{{'W', 'B', 'W', 'B', 'B', 'W'}, {'W', 'B', 'W', 'B', 'B', 'W'}, {'W', 'B', 'W', 'B', 'B', 'W'}, {'B', 'W', 'B', 'W', 'W', 'B'}}, 1),
                equalTo(0)
        );
    }

    class Solution {
        public int findBlackPixel(char[][] picture, int N) {
            int m = picture.length;
            if (m == 0)
                return 0;
            int n = picture[0].length;
            int[] rowBlackCount = new int[m];
            int[] colBlackCount = new int[n];
            String[] rowKeys = new String[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (picture[i][j] == 'B') {
                        rowBlackCount[i]++;
                        colBlackCount[j]++;
                    }
                }
                rowKeys[i] = new String(picture[i]);
            }
            if (N == 0) {
                int count = 0;
                for (int c : colBlackCount) {
                    if (c == 0)
                        count++;
                }
                return count;
            }

            Map<String, Integer> keyCount = new HashMap<>();
            for (String key : rowKeys) {
                keyCount.put(key, keyCount.getOrDefault(key, 0) + 1);
            }

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (N == colBlackCount[j]) {
                    for (int i = 0; i < m; i++) {
                        if (picture[i][j] == 'B') {
                            if (rowBlackCount[i] == N && N == keyCount.get(rowKeys[i])) {
                                count += N;
                            }
                            break;
                        }
                    }
                }
            }

            return count;
        }
    }
}
