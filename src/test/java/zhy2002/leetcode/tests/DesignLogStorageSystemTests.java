package zhy2002.leetcode.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/design-log-storage-system/#/description
 */
public class DesignLogStorageSystemTests {

    @Test
    public void test() {
        LogSystem logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");
        logSystem.put(4, "2017:01:02:00:00:00");
        assertThat(logSystem.retrieve("2017:01:01:23:59:59", "2017:01:01:23:59:59", "Day"), equalTo(Arrays.asList(2, 1)));
    }

    public class LogSystem {

        private TreeMap<String, List<Integer>> logs = new TreeMap<>();

        public LogSystem() {
        }

        public void put(int id, String timestamp) {
            logs.computeIfAbsent(timestamp, k -> new ArrayList<>()).add(id);
        }

        public List<Integer> retrieve(String s, String e, String gra) {
            s = normalize(s, gra, false);
            e = normalize(e, gra, true);
            List<Integer> result = new ArrayList<>();
            for (List<Integer> ids : logs.subMap(s, e).values()) {
                result.addAll(ids);
            }
            return result;
        }

        private String normalize(String time, String gra, boolean addOne) {
            int index = granularityIndex(gra);
            String[] parts = time.split(":");
            for (int i = index + 1; i < parts.length; i++) {
                parts[i] = "00";
            }
            if (addOne) {
                parts[index] = String.format("%02d", Integer.parseInt(parts[index]) + 1);
            }
            return String.join(":", parts);
        }

        private int granularityIndex(String gra) {
            if ("Year".equals(gra))
                return 0;
            if ("Month".equals(gra))
                return 1;
            if ("Day".equals(gra))
                return 2;
            if ("Hour".equals(gra))
                return 3;
            if ("Minute".equals(gra))
                return 4;
            if ("Second".equals(gra))
                return 5;
            return -1;
        }
    }
}
