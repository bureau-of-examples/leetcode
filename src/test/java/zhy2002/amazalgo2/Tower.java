package zhy2002.amazalgo2;

import java.util.Scanner;


public class Tower {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        printTower(n);
    }

    private static void printTower(int n) {
        int size = n * 2 - 1;
        int starCount = 1;
        for (int i = 1; i<=n; i++) {
            StringBuilder sb = new StringBuilder();
            int blankCount = (size - starCount) / 2;
            for (int j = 0; j<blankCount; j++) {
                sb.append(".");
            }
            for (int j = 0; j < starCount; j++) {
                sb.append("#");
            }
            for (int j = 0; j<blankCount; j++) {
                sb.append(".");
            }
            System.out.println(sb.toString());
            starCount+=2;

        }
    }

}
