package cs2022;

import java.util.Scanner;

public class SolutionD {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] mine = in.nextLine().toCharArray();
        char[] friend = in.nextLine().toCharArray();

        System.out.print(solve(mine, friend));
    }

    private static int solve(char[] mine, char[] friend) {
        int totalCount = 0;
        int mineIndex = 0;
        for (int i = 0; i < friend.length; i++) {
            while (mineIndex < mine.length && mine[mineIndex] != friend[i]) {
                mineIndex++;
            }
            if (mineIndex >= mine.length) {
                break;
            }
            totalCount++;
            mineIndex++;
        }
        return totalCount;
    }

}
