package zhy2002.leetcode.additional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber2Tests {

    private static class Solution {
        public int nthUglyNumber(int n) {
            if(n<=0) return 0;
            int a=0,b=0,c=0;
            List<Integer> table = new ArrayList<>();
            table.add(1);
            while(table.size()<n)
            {
                int next_val = Math.min(table.get(a)*2,Math.min(table.get(b)*3,table.get(c)*5));
                table.add(next_val);
                if(table.get(a)*2==next_val) a++;
                if(table.get(b)*3==next_val) b++;
                if(table.get(c)*5==next_val) c++;
            }
            return table.get(table.size()-1);
        }
    }


    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }


    @Test
    public void averageDiff() {
        String[] input = new String[]{
        "20:45:19, 22:30:42",
        "20:32:19, 21:09:59",
        "17:34:16, 21:49:37",
        "20:58:06, 21:52:08",
        "16:50:24, 21:58:36",
        "18:46:59, 21:02:43",
        "20:32:55, 21:20:42",
        "19:17:12, 20:19:09",
        "19:36:31, 20:19:09"
        };

        double total = 0;
        for (String val : input) {
            total += diff(val);
        }
        System.out.println(total / input.length);
    }

    private int diff(String val) {
        String[] values = val.split(",\\s*");
        return minutes(values[1]) - minutes(values[0]);
    }

    private int minutes(String val) {
        String[] parts = val.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
