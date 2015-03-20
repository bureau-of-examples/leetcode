package zhy2002.leetcode.solutions.maxpointsonaline;

import zhy2002.leetcode.common.Point;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class Solution {

    public int maxPoints(Point[] points) {
        if (points.length <= 2)
            return points.length;

        int max = 2;
        HashMap<Long, Integer> kCount = new HashMap<>();
        for (int i = points.length - 1; i >= max; i--) {
            int dupCount = 1;
            int maxKCount = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dupCount++;
                } else {
                    int deltaX = points[j].x - points[i].x;
                    int deltaY = points[j].y - points[i].y;

                    long a, b;
                    if (deltaX == 0){//vertical
                        a = 0;
                        b = 1;
                    }
                    else if (deltaY == 0){//horizontal
                        b = 0;
                        a = 1;
                    }
                    else {
                        a = deltaX;
                        if (a < 0)
                            a = -a;
                        b = deltaY;
                        if (b < 0)
                            b = -b;
                        long gcd = findGCD(a, b);
                        a /= gcd;
                        b /= gcd;
                        a = -a;
                        if ((deltaX ^ deltaY) >= 0) {
                            b = -b;
                        } else {
                            if(b == 0x100000000L){
                                a = -a;
                                b = -b;
                            }
                        }
                    }

                    Long key = (a << 32) | (b & 0x00000000FFFFFFFFL);
                    Integer count = kCount.get(key);
                    count = count == null ? 1 : count + 1;
                    kCount.put(key, count);
                    if (count > maxKCount)
                        maxKCount = count;
                }
            }
            if (dupCount + maxKCount > max)
                max = dupCount + maxKCount;
            kCount.clear();
        }
        return max;
    }

    private static long findGCD(long a, long b) { //a and b are positive numbers
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return (int) a;
    }
}


