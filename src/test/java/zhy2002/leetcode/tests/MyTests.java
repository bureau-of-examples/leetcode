package zhy2002.leetcode.tests;

import org.junit.Test;

/**
 *
 */
public class MyTests {



    @Test
    public void test() {
        int min = Integer.MAX_VALUE;
        for (int limit =5; limit <= 5000; limit++) {
            min = Math.min(min, calc(limit));
        }
        System.out.println(min);
    }

    private int calc(int limit) {
        int money = 40;
        int farmer = 5;
        int target = 10000;
        int building = 0;
        int day = 0;
        while (money < target) {
            if (farmer < limit) {
                farmer += building;
                int toBuild = limit - farmer;
                toBuild = Math.min(toBuild, money / 40);
                building = toBuild;
            }
            day++;
            money += farmer * 15;
        }
        return day;
    }
}
