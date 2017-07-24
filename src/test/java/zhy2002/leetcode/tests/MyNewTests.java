package zhy2002.leetcode.tests;


import org.junit.Test;

public class MyNewTests {

    @Test
    public void testSolve2() {
        System.out.println(solve2(2, 10));
    }

    static int eggDrop(int n, int k) {
        if (k <= 1 || n == 1)
            return k;

        int min = Integer.MAX_VALUE, x, res;
        for (x = 1; x <= k; x++) {
            res = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
            if (res < min)
                min = res;
        }
        return min + 1;
    }

    private static int solve2(int n, int k) {
        if (k <= 1 || n == 1)
            return k;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            int times = Math.max(solve2(n - 1, i - 1), solve2(n, k - i));
            min = Math.min(min, times);
        }
        min++;
        return min;
    }

    @Test
    public void test() {
        System.out.println(solve("be7tnzdlezz4ghodykrlna21j9lemj4dxcm0rz15yg9uxdncyfxl5zmppn3b6n5jfrj6r1b5h00"));
    }

    private static String solve(String str) {
        String result = "";
        int start = 0;
        while (start < str.length()) {
            char startChar = str.charAt(start);
            if (startChar < '0' || startChar > '9') {
                start++;
                continue;
            }
            int end = start + 1;
            while (end < str.length() && str.charAt(end) >= '0' && str.charAt(end) <= '9') {
                end++;
            }
            result = getMaxNumber(result, str.substring(start, end));
            start = end + 1;
        }
        return result;
    }

    private static String getMaxNumber(String existing, String newStr) {
        if (newStr.length() > 1) {//trim leading 0
            int index = 0;
            while (index < newStr.length() - 1 && newStr.charAt(index) == '0') {
                index++;
            }
            newStr = newStr.substring(index);
        }

        if (newStr.length() > existing.length()) {
            return newStr;
        } else if (newStr.length() < existing.length()) {
            return existing;
        }
        return newStr.compareTo(existing) > 0 ? newStr : existing;
    }
}
