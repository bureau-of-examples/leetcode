package zhy2002.amazalgo2;

import java.util.Scanner;


public class Potion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextInt();
        long k = scanner.nextInt();
        System.out.println(solve(n, k));

//        System.out.println(solve(3, 5));
//        System.out.println(solve(15, 6));
//        System.out.println(solve(0, 6));
    }

    private static long solve(long n, long k) {
        long red = n * 2;
        long green = n * 5;
        long blue = n * 8;

        long total = 0;
        total += red / k;
        if (red % k != 0) {
            total++;
        }
        total += green / k;
        if (green % k != 0) {
            total++;
        }
        total += blue / k;
        if (blue % k != 0) {
            total++;
        }
        return total;
    }

}
