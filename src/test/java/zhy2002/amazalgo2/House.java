package zhy2002.amazalgo2;

import java.util.Scanner;


public class House {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(solve(1));
    }

    private static int solve(int n) {
        boolean[][] mat = new boolean[16][16];
        for (int i=0; i < mat.length; i++) {
            for (int j=0; j < mat[i].length; j++) {
                if (isValid(i) && isValid(j) && check(i, j)) {
                    mat[i][j] = true;
                }
            }
        }

        int[] state = new int[16];
        for (int i = 0; i<state.length; i++) {
            if (isValid(i)) {
                state[i] = 1;
            }
        }

        int[] nextState = new int[16];
        for (int i=2; i<=n; i++) {
            for (int j = 0; j < nextState.length; j++) {
                if (!isValid(j)) {
                    continue;
                }

                for (int k=0; k<state.length; k++) {
                    if (mat[k][j]) {
                        nextState[j] += state[k];
                    }
                }
            }
            int[] temp = state;
            state = nextState;
            nextState = temp;
        }


        int sum = 0;
        for (int i = 0; i<state.length; i++) {
            sum += state[i];
        }
        return sum;
    }

    private static boolean isValid(int v) {
        return v == 0 || v == 1 || v == 2 || v == 4 || v == 8 || v == 10 || v == 5;
    }

    private static boolean check(int i, int j) {
        return (i & j) == 0;
    }
}
