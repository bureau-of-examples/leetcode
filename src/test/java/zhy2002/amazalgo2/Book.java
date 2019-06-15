package zhy2002.amazalgo2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Book {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i=0; i<n; i++) {
            b[i] = scanner.nextInt();
        }

        int[] result = solve(a, b);

        for (int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    private static int[] solve(int[] a, int[] b) {
        Map<Integer, Integer> aPos = new HashMap<>();
        for (int i=0; i<a.length; i++) {
            aPos.put(a[i], i);
        }

        int minAPos = -1;
        int[] result = new int[a.length];
        for (int i=0; i<b.length; i++) {
            int pos = aPos.get(b[i]);
            if (pos > minAPos) {
                result[i] = pos - minAPos;
                minAPos = pos;
            }
        }
        return result;
    }

}
