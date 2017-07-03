package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/binary-watch/#/description
 */
public class BinaryWatchTests {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertThat(solution.readBinaryWatch(4), equalTo(Collections.emptyList()));
        assertThat(solution.readBinaryWatch(10), equalTo(Collections.emptyList()));
        assertThat(solution.readBinaryWatch(1), equalTo(Arrays.asList("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00")));
    }

    public class Solution {
        public List<String> readBinaryWatch(int num) {
            List<String> result = new ArrayList<>();
            find(result, 0, 0, 0, num);
            return result;
        }

        private void find(List<String> result, int template, int size, int start, int num) {
            if (size == num) {
                String time = read(template);
                if (time != null) {
                    result.add(time);
                }
                return;
            }

            int end = 10 - (num - size);
            for (int i = start; i <= end; i++) {
                find(result, template | (1 << i), size + 1, i + 1, num);
            }
        }

        private String read(int lights) {
            int h = lights >>> 6;
            int m = lights & 63;
            if (h < 12 && m < 60)
                return String.format("%d:%02d", h, m);
            return null;
        }
    }
}
