package cs2022;

import java.util.*;


public class SolutionC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] heights = new int[n];
        for (int i=0; i<heights.length; i++) {
            heights[i] = scanner.nextInt();
        }

        solve(heights, k);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<heights.length; i++) {
            if (i != 0) {
                sb.append(' ');
            }
            sb.append(heights[i]);
        }
        System.out.println(sb.toString());
    }

    private static void solve(int[] heights, int k) {
        for (int i=0; i + k - 1 < heights.length; i += k) {
            reverse(heights, i, i + k - 1);
        }
    }

    private static void reverse(int[] heights, int start, int end) {
        while (start < end) {
            int temp = heights[start];
            heights[start] = heights[end];
            heights[end] = temp;
            start++;
            end--;
        }
    }

}
