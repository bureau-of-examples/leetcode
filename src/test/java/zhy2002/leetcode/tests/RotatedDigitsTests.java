package zhy2002.leetcode.tests;

import org.junit.Test;

public class RotatedDigitsTests {

    @Test
    public void test() {
        System.out.println(rotatedDigits(7025)); //1661
        System.out.println(rotatedDigits(1990)); //626
        System.out.println(rotatedDigits(744)); //227
        System.out.println(rotatedDigits(134)); //55
        System.out.println(rotatedDigits(100)); //40
        System.out.println(rotatedDigits(45)); //15
        System.out.println(rotatedDigits(20)); //9
        System.out.println(rotatedDigits(18)); //7
        System.out.println(rotatedDigits(38)); //15
    }

    public int rotatedDigits(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        int a = count018(chars);
        int b = count347(chars);
        return N - a - b;
    }

    private int count347(char[] chars) {
        int[][] dp = new int[chars.length][10];//dp[i][j] = count of number with (len-i) digits and start with j whose each digit is 3 4 7
        dp[chars.length - 1][3] = 1;
        dp[chars.length - 1][4] = 1;
        dp[chars.length - 1][7] = 1;
        int prev = 3;
        int total = 3; //exclude the ones start with 0
        int pow = 10;
        for (int i = chars.length - 2; i >= 0; i--) {
            int cur = 0;
            for (int j = 0; j <= 9; j++) {
                if (j == 3 || j == 4 || j == 7) {
                    dp[i][j] = pow;
                } else {
                    dp[i][j] = prev;
                }
                cur += dp[i][j];
            }
            prev = cur;
            total += prev - dp[i][0];
            pow *= 10;
        }

        //minus the ones > N
        for (int i = 0; i < chars.length; i++) {
            pow /= 10;
            int d = chars[i] - '0';
            int j = 9;
            while (j > d) {
                total -= dp[i][j--];
            }
            if (d == 3 || d == 4 || d == 7) {
                int num = 0;
                for (int k = i + 1; k < chars.length; k++) {
                    num *= 10;
                    num += chars[k] - '0';
                }
                total -= pow - num - 1;
                break;
            }
        }
        return total;
    }

    private int count018(char[] chars) {
        int[][] dp = new int[chars.length][10];//dp[i][j] = count of number with (len-i) digits and start with j whose each digit is 0 1 8
        dp[chars.length - 1][0] = 1;
        dp[chars.length - 1][1] = 1;
        dp[chars.length - 1][8] = 1;
        int total = 2;
        for (int i = chars.length - 2; i >= 0; i--) {
            int prev = dp[i + 1][0] + dp[i + 1][1] + dp[i + 1][8];
            dp[i][0] = prev;
            dp[i][1] = prev;
            dp[i][8] = prev;
            total += dp[i][1] + dp[i][8];
        }
        //minus the ones > N
        for (int i = 0; i < chars.length; i++) {
            int d = chars[i] - '0';
            int j = 9;
            while (j > d) {
                total -= dp[i][j--];
            }
            if (d != 0 && d != 1 && d != 8) {
                break;
            }
        }
        return total;
    }
}
