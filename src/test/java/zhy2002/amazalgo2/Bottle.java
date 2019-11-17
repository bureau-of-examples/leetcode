package zhy2002.amazalgo2;

import java.util.Scanner;


public class Bottle {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        long n = scanner.nextInt();
//        long k = scanner.nextInt();
//
//        System.out.println(solve(n, k));

        System.out.println(solve(999999999, 2));
    }

    private static long solve(long n, long k) {
        if (k == 1) {
            return -1;
        }

        long result = n;
        while (n >= k) {
            long ex = n / k;
            result += ex;
            n = n % k;
            n += ex;
        }
        return result;
    }

}
