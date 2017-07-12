package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
        assertThat(solution.readBinaryWatch(4), equalTo(Arrays.asList("0:15", "0:23", "0:39", "1:07", "2:07", "4:07", "8:07", "0:27", "0:43", "1:11", "2:11", "4:11", "8:11", "0:51", "1:19", "2:19", "4:19", "8:19", "1:35", "2:35", "4:35", "8:35", "3:03", "5:03", "9:03", "6:03", "10:03", "0:29", "0:45", "1:13", "2:13", "4:13", "8:13", "0:53", "1:21", "2:21", "4:21", "8:21", "1:37", "2:37", "4:37", "8:37", "3:05", "5:05", "9:05", "6:05", "10:05", "0:57", "1:25", "2:25", "4:25", "8:25", "1:41", "2:41", "4:41", "8:41", "3:09", "5:09", "9:09", "6:09", "10:09", "1:49", "2:49", "4:49", "8:49", "3:17", "5:17", "9:17", "6:17", "10:17", "3:33", "5:33", "9:33", "6:33", "10:33", "7:01", "11:01", "0:30", "0:46", "1:14", "2:14", "4:14", "8:14", "0:54", "1:22", "2:22", "4:22", "8:22", "1:38", "2:38", "4:38", "8:38", "3:06", "5:06", "9:06", "6:06", "10:06", "0:58", "1:26", "2:26", "4:26", "8:26", "1:42", "2:42", "4:42", "8:42", "3:10", "5:10", "9:10", "6:10", "10:10", "1:50", "2:50", "4:50", "8:50", "3:18", "5:18", "9:18", "6:18", "10:18", "3:34", "5:34", "9:34", "6:34", "10:34", "7:02", "11:02", "1:28", "2:28", "4:28", "8:28", "1:44", "2:44", "4:44", "8:44", "3:12", "5:12", "9:12", "6:12", "10:12", "1:52", "2:52", "4:52", "8:52", "3:20", "5:20", "9:20", "6:20", "10:20", "3:36", "5:36", "9:36", "6:36", "10:36", "7:04", "11:04", "1:56", "2:56", "4:56", "8:56", "3:24", "5:24", "9:24", "6:24", "10:24", "3:40", "5:40", "9:40", "6:40", "10:40", "7:08", "11:08", "3:48", "5:48", "9:48", "6:48", "10:48", "7:16", "11:16", "7:32", "11:32")));
        assertThat(solution.readBinaryWatch(10), equalTo(Arrays.asList()));
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
